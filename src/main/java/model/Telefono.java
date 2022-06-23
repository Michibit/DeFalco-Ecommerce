package model;/*
 * CREATE table Telefono(
	Numero char(20),
    ID_Cliente char(6),
    primary key(Numero,ID_Cliente),
    foreign key(ID_Cliente) references Cliente(ID)
);
 */

public class Telefono {
    private String num, idCliente;

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }


    public Telefono(String num, String idCliente) {
        this.num = num;
        this.idCliente = idCliente;
    }
    
}
