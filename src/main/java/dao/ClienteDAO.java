package dao;

import model.Carrello;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    private final Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public Cliente cercaUtente(String username, String Password) {
        ResultSet rs = null;
        Cliente p = new Cliente();
        String userID = null;
        try {
            rs = this.con.createStatement().executeQuery("SELECT * FROM Cliente WHERE " +
                    "Username=" + "'" + username + "' " +
                    "and Pass=" + "'" + Password + "'");
            while (rs.next()) {
                p.setAdmin(rs.getBoolean("admin"));
                p.setEmail(rs.getString("email"));
                p.setUsername(rs.getString("username"));
                p.setPass(rs.getString("pass"));
                userID = rs.getString("id");
                p.setID(userID);
            }
            p.setCarrello(getProductCart(userID));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public Cliente cercaUtenteByID(String ID) {
        ResultSet rs = null;
        Cliente p = new Cliente();
        String userID = null;
        try {
            rs = this.con.createStatement().executeQuery("SELECT * FROM Cliente WHERE " +
                    "ID=" + ID);
            while (rs.next()) {
                p.setAdmin(rs.getBoolean("admin"));
                p.setEmail(rs.getString("email"));
                p.setUsername(rs.getString("username"));
                p.setPass(rs.getString("pass"));
                userID = rs.getString("id");
                p.setID(userID);
            }
            p.setCarrello(getProductCart(userID));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }


    public ArrayList<Carrello> getProductCart(String userID) {
        ArrayList<Carrello> carelloUtente = new ArrayList<>();
        ProdottoDAO p = new ProdottoDAO(this.con);
        query = "select pID,quantita from Carrello where uID=?";
        try {
            pst = this.con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(userID));
            rs = pst.executeQuery();

            while (rs.next()) {
                Carrello c = new Carrello();
                c.setP(p.getSingleProduct(rs.getInt("pID")),
                        rs.getInt("quantita"));
                carelloUtente.add(c);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carelloUtente;
    }


}


