package model;

/*
 * CREATE table Categoria(
	Genere CHAR(20) primary key,
    Nome char(20),
    Descrizione char(40),
   Icona char(40)
);
 *

 */


public class Categoria {

    private String genere, nome, descrizione, icona;

    public Categoria() {
    }

    public Categoria(String genere, String nome, String descrizione, String icona) {
        this.genere = genere;
        this.nome = nome;
        this.descrizione = descrizione;
        this.icona = icona;
    }

    public String getGenere() {
        return this.genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIcona() {
        return icona;
    }

    public void setIcona(String icona) {
        this.icona = icona;
    }
}

