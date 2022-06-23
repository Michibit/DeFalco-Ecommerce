package model;

import java.util.ArrayList;

public class Carrello {
    private ArrayList<Prodotti> p;

    public Carrello() {
        this.p = new ArrayList<>();

    }

    public ArrayList<Prodotti> getP() {
        return p;
    }

    public void setP(Prodotto p,int quantita) {
        this.p.add(new Prodotti(p,quantita));
    }

}
