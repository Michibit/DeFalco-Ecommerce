package model;

import java.util.Date;

/*
 * CREATE table Spedizione(
	ID CHAR(6) primary key,
    Data_Spedizione date NOT NULL,
    modalita CHAR(20) NOT NULL,
    ID_Ordine CHAR(6) NOT NULL,
    
    foreign key(ID_Ordine) references Ordine(ID)
);
 */


public class Spedizione {
    private String id, modalita, idOrdine;
    private Date Data_Spedizione;


    public Spedizione(String id, String modalita, String idOrdine, Date Data_Spedizione) {
        this.id = id;
        this.modalita = modalita;
        this.idOrdine = idOrdine;
        this.Data_Spedizione = Data_Spedizione;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModalita() {
        return this.modalita;
    }

    public void setModalita(String modalita) {
        this.modalita = modalita;
    }

    public String getIdOrdine() {
        return this.idOrdine;
    }

    public void setIdOrdine(String idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Date getData_Spedizione() {
        return this.Data_Spedizione;
    }

    public void setData_Spedizione(Date Data_Spedizione) {
        this.Data_Spedizione = Data_Spedizione;
    }

}
