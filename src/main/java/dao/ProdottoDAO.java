package dao;

import model.Carrello;
import model.Prodotti;
import model.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO {

    private Connection con;

    public ProdottoDAO(Connection con) {
        this.con = con;
    }

    public ArrayList<Prodotto> getAllProducts() {
        ArrayList<Prodotto> all = new ArrayList<>();
        try {

            String query = "select * from Prodotto";
            PreparedStatement pst = this.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setID(String.valueOf(rs.getInt("ID")));
                p.setNome(rs.getString("Nome"));
                p.setCategoria(rs.getString("Categoria"));
                p.setPrezzo(rs.getDouble("Prezzo"));
                p.setImg(rs.getString("IMG"));
                p.setDecrizione(rs.getString("Descrizione"));
                all.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return all;
    }


    public int insertNewProduct(String nome,double Prezzo,String descrizione,
                                String img,int idCateg){
        int rs;
        try {
            PreparedStatement pst = this.con.prepareStatement("INSERT INTO Prodotto " +
                    "( Nome, Prezzo, Descrizione,Img,Categoria) VALUES(?,?,?,?,?)");

            pst.setString(1, nome);
            pst.setDouble(2,Prezzo);
            pst.setString(3,descrizione);
            pst.setString(4,img);
            pst.setInt(5,idCateg);

            rs = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }


    public Prodotto getSingleProduct(String id) {
        Prodotto p = new Prodotto();
        try {
            String query = "select * from Prodotto where ID=? ";

            PreparedStatement pst  = this.con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                p.setID(String.valueOf(rs.getInt("ID")));
                p.setNome(rs.getString("Nome"));
                p.setCategoria(rs.getString("Categoria"));
                p.setPrezzo(rs.getDouble("Prezzo"));
                p.setImg(rs.getString("IMG"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return p;
    }

    public double getTotalCartPrice(ArrayList<Carrello> cartList) {
        double sum = 0;
                for (Carrello item : cartList) {
                    for(Prodotti p : item.getP()){
                        sum += p.getPrezzoQuantity();
                    }
                }
        return sum;
    }


}
