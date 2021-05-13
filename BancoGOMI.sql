use master

drop database Gomi

create database Gomi
go

use Gomi

create table Administrador(
	IdAdministrador int primary key identity(1, 1)
)

create table Cliente(
	IdCliente int primary key identity(1, 1),
	Rua varchar(max),
	Numero int,
	Complemento varchar(max),
	Bairro varchar(max),
	Cidade varchar(max),
	CEP int
)

create table Motorista(
	IdMotorista int primary key identity(1, 1),
	TipoVeiculo varchar(max), --
	CNH bigint, --
	DataExpiracao date, -- 
	CategoriaCNH varchar(max), --
	/* Armazenamento da foto da CHN */ -- 
	CargaSuportada int --
)

go

create table NaoAdm(
	IdNaoAdm int primary key identity(1, 1),
	IdCliente int foreign key references Cliente(IdCliente),
	IdMotorista int foreign key references Motorista(IdMotorista),
	/* Informações de pagamento/Cobrança */ --
	/* Armazenamento da foto */ --
	TelefoneDDD int,
	Telefone int, --
)
go

create table Usuario(
	IdUsuario int primary key identity(1, 1),
	IdNaoAdm int foreign key references NaoAdm(IdNaoAdm),
	IdAdministrador int foreign key references Administrador(IdAdministrador),
	Email varchar(max), --
	Senha varchar(max), --
	Nome varchar(max), --
	DataNascimento date, --
	CPF bigint --
)
go

create table Solicitacao(
	IdSolicitacao int primary key identity(1, 1),
	IdCliente int foreign key references Cliente (IdCliente),
	IdMotorista int foreign key references Motorista (IdMotorista),
	Agendamento bit,
	DataSolicitacao date,
	Aberto bit,
	/* Informacoes */	
)

create table Categoria(
	idCategoria int primary key identity(1, 1),
	descricaoCategoria varchar(max)
)
go

create table CategoriaSolicitacao(
	IdSolicitacao int foreign key references Solicitacao(IdSolicitacao),
	IdCategoria int foreign key references Categoria(IdCategoria)
)

create table Notificacao (
	IdNotificacao int primary key identity(1, 1),
	IdSolicitacao int foreign key references Solicitacao(IdSolicitacao),
	IdUsuario int foreign key references Usuario(IdUsuario),
	Mensagem varchar(max)
)

create table [Log] (
	IdLog int primary key identity(1, 1),
	Descricao varchar(max)
)

create table Ecoponto (
	IdEcoponto int primary key identity(1, 1),
	EnderecoEcoponto varchar(max)
)
go

create procedure spConsult (@id int ,@tabela varchar(max)) as
begin
	declare @sql varchar(max);
	set @sql = 'select * from ' + @tabela +
			   ' where id' + @tabela + ' = ' + cast(@id as varchar(max))
	exec(@sql)
end
go

create procedure spDelete (@id int, @tabela varchar(max))
as
begin
    declare @sql varchar(max)
	set @sql = 'delete ' + @tabela + ' where id' + @tabela + ' = ' + convert(varchar(max),@id)
	exec (@sql)	
end
go

create procedure spList (@tabela varchar(max),@ordem varchar(max)) as
begin
	exec('select * from ' + @tabela +
		 ' order by ' + @ordem)
end
go

/*Criação das procedures de Insert e Update*/

create procedure spInsert_Log (@Id int, @Descricao varchar(max)) as
begin
	insert into [Log] values (@Descricao)
end
go

create procedure spInsert_Solicitacao (@IdSolicitacao int, @IdCliente int, @IdMotorista int, @Agendamento bit, @DataSolicitacao date, @Aberto bit) as
begin
	insert into Solicitacao values (@IdCliente, @IdMotorista, @Agendamento, @DataSolicitacao, @Aberto)
end
go

create procedure spUpdate_Solicitacao (@IdSolicitacao int, @IdCliente int, @IdMotorista int, @Agendamento bit, @DataSolicitacao date, @Aberto bit) as
begin
	update Solicitacao set IdCliente = @IdCliente, 
						   IdMotorista = @IdMotorista, 
						   Agendamento = @Agendamento, 
						   DataSolicitacao = @DataSolicitacao,
						   Aberto = @Aberto
						   where IdSolicitacao = @IdSolicitacao
end
go

create procedure spInsert_Notificacao (@IdNotificacao int, @IdSolicitacao int, @IdUsuario int, @Mensagem varchar(max)) as
begin
	insert into Notificacao values (@IdSolicitacao, @IdUsuario, @Mensagem)
end
go

create procedure spInsert_Administrador (@IdAdministrador int) as
begin
	insert into Usuario default values
end
go

/*
create procedure spUpdate_Administrador (@IdAdministrador int) as
begin
	Update Administrador set ?
	where IdAdministrador = @IdAdministrador
end
go
*/


create procedure spInsert_Cliente (@IdCliente int, @Rua varchar(max), @Numero int, @Complemento varchar(max), @Bairro varchar(max), @Cidade varchar(max), @CEP int) as
begin
	insert into Cliente values (@rua, @Numero, @Complemento, @Bairro, @Cidade, @CEP)
end
go

create procedure spUpdate_Cliente (@IdCliente int, @Rua varchar(max), @Numero int, @Complemento varchar(max), @Bairro varchar(max), @Cidade varchar(max), @CEP int) as
begin
	update Cliente set Rua = @Rua,
					   Numero = @Numero,
					   Complemento = @Complemento,
					   Bairro = @Bairro,
					   Cidade = @Cidade,
					   CEP = @CEP
	where IdCliente = @IdCliente
end
go

create procedure spInsert_Motorista (@IdMotorista int, @tipoVeiculo varchar(max), @Cnh bigint, @DataExpiracao date, @CategoriaCnh varchar(max), @cargaSuportada int) as
begin
	insert into Motorista values (@tipoVeiculo, @Cnh, @DataExpiracao, @CategoriaCnh, @cargaSuportada)
end
go

create procedure spUpdate_Motorista (@IdMotorista int, @tipoVeiculo varchar(max), @Cnh bigint, @DataExpiracao date, @CategoriaCnh varchar(max), @cargaSuportada int) as
begin
	Update Motorista set TipoVeiculo = @tipoVeiculo,
						 CNH = @Cnh,
						 DataExpiracao = @DataExpiracao,
						 CategoriaCNH = @CategoriaCnh,
						 CargaSuportada = @cargaSuportada
						 where IdMotorista = @IdMotorista
end
go

create procedure spInsert_NaoAdm (@IdNaoAdm int, @IdCliente int, @IdMotorista int, @TelefoneDDD int, @Telefone int) as
begin
	insert into NaoAdm values (@IdCliente, @IdMotorista, @TelefoneDDD, @Telefone)
end
go

create procedure spUpdate_NaoAdm (@IdNaoAdm int, @IdCliente int, @IdMotorista int, @TelefoneDDD int, @Telefone int) as
begin
	update NaoAdm set IdCliente = @IdCliente,
					  IdMotorista = @IdMotorista,
					  TelefoneDDD = @TelefoneDDD,
					  Telefone = @Telefone
					  where IdNaoAdm = @IdNaoAdm
end
go

create procedure spInsert_Usuario (@IdUsuario int, @IdNaoAdm int, @IdAdministrador int, @Email varchar(max), @Senha varchar(max), @Nome varchar(max), @DataNascimento date, @CPF bigint) as
begin
	insert into Usuario values (@IdNaoAdm, @IdAdministrador, @Email, @Senha, @Nome, @DataNascimento, @CPF)
end
go

create procedure spUpdate_Usuario (@IdUsuario int, @IdNaoAdm int, @IdAdministrador int, @Email varchar(max), @Senha varchar(max), @Nome varchar(max), @DataNascimento date, @CPF bigint) as
begin
	update Usuario set IdNaoAdm = @IdNaoAdm,
					   IdAdministrador = @IdAdministrador,
					   Email = @Email,
					   Senha = @Senha,
					   Nome = @Nome,
					   DataNascimento = @DataNascimento,
					   CPF = @CPF
					   where IdUsuario = @IdUsuario
end
go

create procedure spInsert_Ecoponto (@idEcoponto int, @EnderecoEcoponto varchar(max)) as
begin
	insert into Ecoponto values (@EnderecoEcoponto)
end
go

create procedure spUpdate_Ecoponto (@idEcoponto int, @EnderecoEcoponto varchar(max)) as
begin
	update Ecoponto set EnderecoEcoponto = @EnderecoEcoponto
end
go
