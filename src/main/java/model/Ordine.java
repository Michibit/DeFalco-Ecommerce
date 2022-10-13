package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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
    private String dataOrdine;


    public Ordine(String userID, String stato, Prodotto p, int quantita, Date dataOrdine) {
        this.userID = userID;
        this.stato = stato;
        this.dataOrdine = String.valueOf(dataOrdine);
        this.prodotti = new ArrayList<>();
    }

    public Ordine() {
        Random r = new Random();
        this.ID = String.valueOf(r.nextInt(10000));
        this.prodotti = new ArrayList<>();

    }

    public Ordine(String ID, String userID, String stato, Date dataOrdine) {
        this.ID = ID;
        this.userID = userID;
        this.stato = stato;
        this.dataOrdine = String.valueOf(dataOrdine);
        this.prodotti = new ArrayList<>();
    }

    public Ordine(String ID, String stato, Date dataOrdine) {
        this.ID = ID;
        this.stato = stato;
        this.dataOrdine = String.valueOf(dataOrdine);
    }

    public ArrayList<Prodotti> getP() {
        return prodotti;
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

    public ArrayList<Prodotti> getProdotti() {
        return prodotti;
    }

    public void setProdotti(Prodotto p, int quantita) {
        this.prodotti.add(new Prodotti(p, quantita));
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public void setDataOrdine(String dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}

