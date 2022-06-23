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
            ID, nome, img, categoria;
    private ArrayList<Img> galleriaImg;

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

    public Prodotto(double prezzo, double peso,
                    String descrizione, String ID, String nome, String img, String categoria) {
        this.prezzo = prezzo;
        this.peso = peso;
        this.decrizione = descrizione;
        this.ID = ID;
        this.nome = nome;
        this.img = img;
        this.categoria = categoria;
        this.galleriaImg = new ArrayList<>();
    }

    public Prodotto() {
        this.galleriaImg = new ArrayList<>();
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



    public String getCategoria() {
        return this.categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
