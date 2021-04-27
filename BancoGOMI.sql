use master

drop database Gomi

create database Gomi
go

use Gomi

create table Administrador(
	IdAdm int primary key
)

create table Cliente(
	IdCliente int primary key,
	Endereco varchar(max)
)

create table Motorista(
	IdMotorista int primary key,
	CNH bigint,
	DataExpiracao date,
	CategoriaCNH varchar(max)
	/* Armazenamento da foto da CHN */
)

go

create table NaoAdm(
	IdNaoAdm int primary key,
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
	IdUsuario int primary key,
	IdNaoAdm int foreign key references NaoAdm(IdNaoAdm),
	IdAdm int foreign key references Administrador(IdAdm),
	[Login] varchar(max),
	Senha varchar(max),
	Nome varchar(max),
	DataNascimento date
)
go

create table Solicitacao(
	IdSolicitacao int primary key,
	IdCliente int foreign key references Cliente (IdCliente),
	IdMotorista int foreign key references Motorista (IdMotorista),
	Agendamento bit,
	DataSolicitacao date,
	Aberto bit,
	/* Informacoes */	
)

create table Notificacao (
	IdNotificacao int primary key,
	IdSolicitacao int foreign key references Solicitacao(IdSolicitacao),
	IdUsuario int foreign key references Usuario(IdUsuario),
	Mensagem varchar(max)
)

create table [Log] (
	IdLog int primary key,
	Descricao varchar(max)
)

create table Ecoponto (
	IdEcoponto int primary key,
	EnderecoEcoponto varchar(max)
)