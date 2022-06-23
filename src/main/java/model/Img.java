package model;/*
 *  create TABLE IMG(
    ID_Prodotto char(6),
    URL CHAR(50),
    primary key(ID_Prodotto,URL),
    foreign key (ID_Prodotto) references Prodotto(ID)
);
 */

public class Img {
    private String URL,idProdotto;

    public Img(String URL, String idProdotto) {
        this.URL = URL;
        this.idProdotto = idProdotto;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getIdProdotto() {
        return this.idProdotto;
    }

    public void setIdProdotto(String idProdotto) {
        this.idProdotto = idProdotto;
    }
    
}
