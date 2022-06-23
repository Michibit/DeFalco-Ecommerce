package model;

/*
 * CREATE table Categoria(
	ID CHAR(2) primary key,
    Nome char(20),
    Descrizione char(40),
   Icona char(40)
);
 *

 */


public class Categoria {
    
    private String ID, nome, descrizione;

    public Categoria(String ID, String nome, String descrizione) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
}
