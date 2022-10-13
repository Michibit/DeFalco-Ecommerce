package controller;

import dao.CategoriaDAO;
import dao.ConnectionDB;
import model.Categoria;

import java.sql.Connection;
import java.sql.SQLException;

public class prova {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionDB.getConnection();
        CategoriaDAO cat = new CategoriaDAO(c);


        Categoria da = cat.getCategoriaByGenere("uomo");


        System.out.println(da.getGenere());


    }
}
