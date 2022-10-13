package model;

import java.util.ArrayList;

/*  ID char(6) primary key,
    Nome char(20),
    Peso decimal,
    Prezzo DECIMAL(10, 2) not null,
    Decrizione_Breve CHAR(30),
    Decrizione_Dett CHAR(60),
    Img_THUMB char(50),
    Img_FULL char(50),
    Categoria char(2),   
    */


public class Prodotto {
    private double prezzo, peso;
    private String decrizione,
            ID, nome, img, genere, nomeCategoria;
    private ArrayList<Img> galleriaImg;

    public Prodotto(double prezzo, double peso,
                    String descrizione, String ID, String nome, String img, String genere, String nomeCategoria) {
        this.prezzo = prezzo;
        this.peso = peso;
        this.decrizione = descrizione;
        this.ID = ID;
        this.nome = nome;
        this.img = img;
        this.genere = genere;
        this.nomeCategoria = nomeCategoria;
        this.galleriaImg = new ArrayList<>();
    }

    public Prodotto() {
        this.galleriaImg = new ArrayList<>();
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDecrizione() {
        return decrizione;
    }

    public void setDecrizione(String decrizione) {
        this.decrizione = decrizione;
    }

    public ArrayList<Img> getGalleriaImg() {
        return galleriaImg;
    }

    public void setGalleriaImg(ArrayList<Img> galleriaImg) {
        this.galleriaImg = galleriaImg;
    }

    public void addImg(Img e) {
        this.galleriaImg.add(e);
    }


    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prodotto prodotto = (Prodotto) o;

        if (Double.compare(prodotto.prezzo, prezzo) != 0) return false;
        if (Double.compare(prodotto.peso, peso) != 0) return false;
        if (decrizione != null ? !decrizione.equals(prodotto.decrizione) : prodotto.decrizione != null) return false;
        if (ID != null ? !ID.equals(prodotto.ID) : prodotto.ID != null) return false;
        if (nome != null ? !nome.equals(prodotto.nome) : prodotto.nome != null) return false;
        if (img != null ? !img.equals(prodotto.img) : prodotto.img != null) return false;
        if (genere != null ? !genere.equals(prodotto.genere) : prodotto.genere != null) return false;
        if (nomeCategoria != null ? !nomeCategoria.equals(prodotto.nomeCategoria) : prodotto.nomeCategoria != null)
            return false;
        return galleriaImg != null ? galleriaImg.equals(prodotto.galleriaImg) : prodotto.galleriaImg == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(prezzo);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(peso);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (decrizione != null ? decrizione.hashCode() : 0);
        result = 31 * result + (ID != null ? ID.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (genere != null ? genere.hashCode() : 0);
        result = 31 * result + (nomeCategoria != null ? nomeCategoria.hashCode() : 0);
        result = 31 * result + (galleriaImg != null ? galleriaImg.hashCode() : 0);
        return result;
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


    public String getNomeCategoria() {
        return this.nomeCategoria;
    }


    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }


}
