package model;/*
 * CREATE Table Fatturazione(
	ID_Cliente CHAR(6),
    Nome char(20),
    Cognome CHAR(20),
    Indirizzo char(20) not null,
    Cap CHAR(5) not null, 
    Citta char(30) not null,
    primary key (ID_Cliente,Nome,Cognome),
    foreign key(ID_Cliente) references Cliente(ID)
);
 */

public class Fatturazione {
    private String ID_Cliente, nome, cognome,
            indirizzo, cap, citta;


    public Fatturazione(String ID_Cliente, String nome, String cognome, String indirizzo, String cap, String citta) {
        this.ID_Cliente = ID_Cliente;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.citta = citta;
    }

    public Fatturazione() {

    }

    public String getID_Cliente() {
        return this.ID_Cliente;
    }

    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return this.cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return this.citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }


}
