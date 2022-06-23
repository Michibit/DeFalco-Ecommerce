package model;

import java.util.ArrayList;
import java.util.Date;

/*
 * CREATE table Ordine(
 * ID CHAR(6),
 * dataord date,
 * stato char(20),
 * primary key(ID)
 * );
 */


public class Ordine {
    private String ID, userID, stato;
    private ArrayList<Prodotti> prodotti;

    public ArrayList<Prodotti> getP() {
        return prodotti;
    }


    public void setDataOrdine(String dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public Ordine(String ID, String userID, String stato, Prodotto p, int quantita, Date dataOrdine) {
        this.ID = ID;
        this.userID = userID;
        this.stato = stato;
        this.dataOrdine = String.valueOf(dataOrdine);
        this.prodotti = new ArrayList<>();
    }

    public Ordine() {
        this.prodotti = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Ordine{" +
                "ID='" + ID + '\'' +
                ", userID='" + userID + '\'' +
                ", stato='" + stato + '\'' +
                ", prodotti=" + prodotti +
                ", dataOrdine='" + dataOrdine + '\'' +
                '}';
    }

    public Ordine(String ID, String userID, String stato, Date dataOrdine) {
        this.ID = ID;
        this.userID = userID;
        this.stato = stato;
        this.dataOrdine = String.valueOf(dataOrdine);
        this.prodotti = new ArrayList<>();
    }

    public ArrayList<Prodotti> getProdotti() {
        return prodotti;
    }

    public void setProdotti(Prodotto p, int quantita) {
        this.prodotti.add(new Prodotti(p, quantita));
    }

    private String dataOrdine;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Ordine(String ID, String stato, Date dataOrdine) {
        this.ID = ID;
        this.stato = stato;
        this.dataOrdine = String.valueOf(dataOrdine);
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStato() {
        return this.stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getDataOrdine() {
        return String.valueOf(this.dataOrdine);
    }
}

