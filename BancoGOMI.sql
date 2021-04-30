use master

drop database Gomi

create database Gomi
go

use Gomi

/*Criação das tabelas*/

create table Administrador(
	IdAdministrador int primary key identity(1,1)
)

create table Cliente(
	IdCliente int primary key identity(1,1),
	Endereco varchar(max)
)

create table Motorista(
	IdMotorista int primary key identity(1,1),
	CNH bigint,
	DataExpiracao date,
	CategoriaCNH varchar(max)
	/* Armazenamento da foto da CHN */
)

go

create table NaoAdm(
	IdNaoAdm int primary key identity(1,1),
	IdCliente int foreign key references Cliente(IdCliente),
	IdMotorista int foreign key references Motorista(IdMotorista),
	CPF bigint,
	/* Informações de pagamento/Cobrança */
	/* Armazenamento da foto */
	Telefone int,
	Email varchar(max)
)
go

create table Usuario(
	IdUsuario int primary key identity(1,1),
	IdNaoAdm int foreign key references NaoAdm(IdNaoAdm),
	IdAdministrador int foreign key references Administrador(IdAdministrador),
	[Login] varchar(max),
	Senha varchar(max),
	Nome varchar(max),
	DataNascimento date
)
go

create table Solicitacao(
	IdSolicitacao int primary key identity(1,1),
	IdCliente int foreign key references Cliente (IdCliente),
	IdMotorista int foreign key references Motorista (IdMotorista),
	Agendamento bit,
	DataSolicitacao date,
	Aberto bit,
	/* Informacoes */	
)

create table Notificacao (
	IdNotificacao int primary key identity(1,1),
	IdSolicitacao int foreign key references Solicitacao(IdSolicitacao),
	IdUsuario int foreign key references Usuario(IdUsuario),
	Mensagem varchar(max)
)

create table [Log] (
	IdLog int primary key identity(1,1),
	Descricao varchar(max)
)

create table Ecoponto (
	IdEcoponto int primary key identity(1,1),
	EnderecoEcoponto varchar(max)
)
go

/*Criação das Procedures Genericas*/

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


create procedure spInsert_Cliente (@IdCliente int, @Endereco varchar(max)) as
begin
	insert into Cliente values (@Endereco)
end
go

create procedure spUpdate_Cliente (@IdCliente int, @Endereco varchar(max)) as
begin
	update Cliente set Endereco = @Endereco
	where IdCliente = @IdCliente
end
go

create procedure spInsert_Motorista (@IdMotorista int, @Cnh bigint, @DataExpiracao date, @CategoriaCnh varchar(max)) as
begin
	insert into Motorista values (@Cnh, @DataExpiracao, @CategoriaCnh)
end
go

create procedure spUpdate_Motorista (@IdMotorista int, @Cnh bigint, @DataExpiracao date, @CategoriaCnh varchar(max)) as
begin
	Update Motorista set CNH = @Cnh,
						 DataExpiracao = @DataExpiracao,
						 CategoriaCNH = @CategoriaCnh
						 where IdMotorista = @IdMotorista
end
go

create procedure spInsert_NaoAdm (@IdNaoAdm int, @IdCliente int, @IdMotorista int, @Cpf bigint, @Telefone int, @Email int) as
begin
	insert into NaoAdm values (@IdCliente, @IdMotorista, @Cpf, @Telefone, @Email)
end
go

create procedure spUpdate_NaoAdm (@IdNaoAdm int, @IdCliente int, @IdMotorista int, @Cpf bigint, @Telefone int, @Email int) as
begin
	update NaoAdm set IdCliente = @IdCliente,
					  IdMotorista = @IdMotorista,
					  CPF = @Cpf,
					  Telefone = @Telefone,
					  Email = @Email
					  where IdNaoAdm = @IdNaoAdm
end
go

create procedure spInsert_Usuario (@IdUsuario int, @IdNaoAdm int, @IdAdministrador int, @Login varchar(max), @Senha varchar(max), @Nome varchar(max), @DataNascimento date) as
begin
	insert into Usuario values (@IdNaoAdm, @IdAdministrador, @Login, @Senha, @Nome, @DataNascimento)
end
go

create procedure spUpdate_Usuario (@IdUsuario int, @IdNaoAdm int, @IdAdministrador int, @Login varchar(max), @Senha varchar(max), @Nome varchar(max), @DataNascimento date) as
begin
	update Usuario set IdNaoAdm = @IdNaoAdm,
					   IdAdministrador = @IdAdministrador,
					   [Login] = @Login,
					   Senha = @Senha,
					   Nome = @Nome,
					   DataNascimento = @DataNascimento
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
