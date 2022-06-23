package model;

import java.util.Date;

/* 
    CREATE table Pagamento(
	ID CHAR(6) primary key,
    Data_Pagamento date,
    Importo decimal,
    Modalita_Pagamento char(20),
	ID_Ordine CHAR(6) NOT NULL,
    
    foreign key(ID_Ordine) references Ordine(ID)
);
 */



public class Pagamento {
    private String idPag, idOrdine, modalitaPag;
    private double Importo;
    private Date Data_Pagamento;

    public Pagamento(String idPag, String idOrdine, String modalitaPag, double Importo, Date Data_Pagamento) {
        this.idPag = idPag;
        this.idOrdine = idOrdine;
        this.modalitaPag = modalitaPag;
        this.Importo = Importo;
        this.Data_Pagamento = Data_Pagamento;
    }

    public String getIdPag() {
        return this.idPag;
    }

    public void setIdPag(String idPag) {
        this.idPag = idPag;
    }

    public String getIdOrdine() {
        return this.idOrdine;
    }

    public void setIdOrdine(String idOrdine) {
        this.idOrdine = idOrdine;
    }

    public String getModalitaPag() {
        return this.modalitaPag;
    }

    public void setModalitaPag(String modalitaPag) {
        this.modalitaPag = modalitaPag;
    }

    public double getImporto() {
        return this.Importo;
    }

    public void setImporto(double Importo) {
        this.Importo = Importo;
    }

    public Date getData_Pagamento() {
        return this.Data_Pagamento;
    }

    public void setData_Pagamento(Date Data_Pagamento) {
        this.Data_Pagamento = Data_Pagamento;
    }
    
}
