package controller;

import dao.ClienteDAO;
import dao.ConnectionDB;
import dao.ProdottoDAO;
import model.*;

import java.sql.SQLException;

public class prova {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ClienteDAO dao = new ClienteDAO(ConnectionDB.getConnection());
        Cliente c = dao.cercaUtente("michibit","Cavani00");
        ProdottoDAO p = new ProdottoDAO(ConnectionDB.getConnection());


        System.out.println(p.getTotalCartPrice(c.getCarrello()));





    }
}
