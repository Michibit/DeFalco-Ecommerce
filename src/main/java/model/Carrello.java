package model;

import java.util.ArrayList;

public class Carrello {
    private int ID;
    private ArrayList<Prodotti> p;

    public Carrello(int ID) {
        this.ID = ID;
        this.p = new ArrayList<>();
    }

    public Carrello() {
        this.p = new ArrayList<>();

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Prodotti> getP() {
        return p;
    }

    public void setP(ArrayList<Prodotti> p) {
        this.p = p;
    }

    public void setP(Prodotto p, int quantita) {
        this.p.add(new Prodotti(p, quantita));
    }

}
