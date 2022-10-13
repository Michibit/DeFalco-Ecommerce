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

    private final Connection con;

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
                p.setGenere(rs.getString("Genere"));
                p.setNomeCategoria(rs.getString("NomeCategoria"));
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

    public ArrayList<Prodotto> getAllProductsByNome(String Nome) {
        ArrayList<Prodotto> all = new ArrayList<>();
        try {

            String query = "select * from Prodotto WHERE Nome=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, Nome);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setID(String.valueOf(rs.getInt("ID")));
                p.setNome(rs.getString("Nome"));
                p.setGenere(rs.getString("Genere"));
                p.setNomeCategoria(rs.getString("NomeCategoria"));
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


    public ArrayList<Prodotto> getAllProductsByNomeCat(String NomeCat) {
        ArrayList<Prodotto> all = new ArrayList<>();
        try {

            String query = "select * from Prodotto WHERE NomeCategoria=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, NomeCat);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setID(String.valueOf(rs.getInt("ID")));
                p.setNome(rs.getString("Nome"));
                p.setGenere(rs.getString("Genere"));
                p.setNomeCategoria(rs.getString("NomeCategoria"));
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

    public ArrayList<Prodotto> getAllProductsByGenere(String genere) {
        ArrayList<Prodotto> all = new ArrayList<>();
        try {

            String query = "select * from Prodotto WHERE Genere=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, genere);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setID(String.valueOf(rs.getInt("ID")));
                p.setNome(rs.getString("Nome"));
                p.setGenere(rs.getString("Genere"));
                p.setNomeCategoria(rs.getString("NomeCategoria"));
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


    public int modificaProduct(String nome, double Prezzo, String descrizione,
                               String img, String Genere, String NomeCategoria, String id) {
        int rs;
        try {
            PreparedStatement pst = this.con.prepareStatement("UPDATE Prodotto " +
                    "SET Nome=?,Prezzo=?,Descrizione=?,Img=?,Genere=?,NomeCategoria=? " +
                    "WHERE ID=?");

            pst.setString(1, nome);
            pst.setDouble(2, Prezzo);
            pst.setString(3, descrizione);
            pst.setString(4, img);
            pst.setString(5, Genere);
            pst.setString(6, NomeCategoria);
            pst.setInt(7, Integer.parseInt(id));

            CategoriaDAO dao1 = new CategoriaDAO(this.con);
            if (!dao1.isCategoryIn(Genere, NomeCategoria)) {
                dao1.insertNewCategory(Genere, NomeCategoria);
            }

            rs = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }


    public int insertNewProduct(String nome, double Prezzo, String descrizione,
                                String img, String Genere, String NomeCategoria) {
        int rs;
        try {
            PreparedStatement pst = this.con.prepareStatement("INSERT INTO Prodotto " +
                    "( Nome, Prezzo, Descrizione,Img,Genere,NomeCategoria) VALUES(?,?,?,?,?,?)");

            pst.setString(1, nome);
            pst.setDouble(2, Prezzo);
            pst.setString(3, descrizione);
            pst.setString(4, img);
            pst.setString(5, Genere);
            pst.setString(6, NomeCategoria);

            CategoriaDAO dao1 = new CategoriaDAO(this.con);
            if (!dao1.isCategoryIn(Genere, NomeCategoria)) {
                dao1.insertNewCategory(Genere, NomeCategoria);
            }

            rs = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }


    public Prodotto getSingleProduct(int id) {
        Prodotto p = new Prodotto();
        try {
            String query = "select * from Prodotto where ID=? ";

            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                p.setID(String.valueOf(rs.getInt("ID")));
                p.setNome(rs.getString("Nome"));
                p.setNomeCategoria(rs.getString("NomeCategoria"));
                p.setGenere(rs.getString("Genere"));
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
            for (Prodotti p : item.getP()) {
                sum += p.getPrezzoQuantity();
            }
        }
        return Math.round(sum * 100.0) / 100.0;
    }


}
