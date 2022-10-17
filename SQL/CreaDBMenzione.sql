Drop database if exists DeFalco;
create database DeFalco;
use DeFalco;



CREATE table Cliente(
	ID int auto_increment,
    Username CHAR(20) NOT NULL,
    Pass char(20) NOT NULL,
    Email CHAR(30) NOT NULL,
    admin bool default false,
    
    primary key(ID)
);

CREATE table Ordine(
	ID int ,
    userid int,
	dataord char(20),
    stato char(20),
    primary key(ID),
    foreign key (userid) references Cliente(ID)
);






CREATE Table Fatturazione(
	ID_Cliente int,
    Nome char(20),
    Cognome CHAR(20),
    Indirizzo char(20) not null,
    Cap CHAR(5) not null, 
    Citta char(30) not null,
    primary key (ID_Cliente,Indirizzo,Cap,Citta),
    foreign key(ID_Cliente) references Cliente(ID)
);









CREATE table Categoria(
	Genere char(20),
    Nome char(20),
    Descrizione char(40),
    Icona char(40),
    primary key (Genere,Nome)
);


CREATE table Prodotto(
	ID int primary key AUTO_INCREMENT,
    Nome char(20),
    Prezzo DECIMAL(10, 2) not null,
    Descrizione CHAR(50),
    Img char(100),
    Genere char(20),
    NomeCategoria char(20),
    foreign key (Genere,NomeCategoria) references Categoria(Genere,Nome)
)AUTO_INCREMENT=123;

CREATE table Composizione(
	ID_Ordine int,
    ID_Prodotto int,
    quantita int,
    primary key(ID_Ordine,ID_Prodotto),
    foreign key(ID_Ordine) references Ordine(ID),
    foreign key(ID_Prodotto) references Prodotto(ID)
    
);


CREATE TABLE Carrello(
	uID int,
    pID int,
    quantita int,
    primary key(uID,pID),
    foreign key (uID) references Cliente(ID),
    foreign key (pID) references Prodotto(ID)
);


