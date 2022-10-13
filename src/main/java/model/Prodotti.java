package model;

public class Prodotti {
    private Prodotto p;
    private int quantita;

    public Prodotti(Prodotto p, int quantita) {
        this.p = p;
        this.quantita = quantita;
    }

    public double getPrezzoQuantity() {
        return Math.round(p.getPrezzo() * quantita * 100.0) / 100.0;
    }

    public Prodotto getP() {
        return p;
    }

    public void setP(Prodotto p) {
        this.p = p;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
