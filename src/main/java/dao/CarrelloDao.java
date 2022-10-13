package dao;

import model.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarrelloDao {
    private final Connection c;

    public CarrelloDao(Connection c) {
        this.c = c;
    }

    public int addProductCartDB(String userID, Prodotto p, int quantita) {
        int rs = 0;
        try {
            PreparedStatement pst = this.c.prepareStatement("INSERT INTO Carrello " +
                    "(uID, pID, quantita) VALUES(?,?,?)");
            pst.setString(1, userID);
            pst.setString(2, p.getID());
            pst.setInt(3, quantita);
            rs = pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public int updateCart(String userID, Prodotto p, int quantita) {
        int rs = 0;
        try {

            PreparedStatement pst = this.c.prepareStatement("UPDATE Carrello SET quantita=?" +
                    " where uID=? and pID=?");
            pst.setInt(1, quantita);
            pst.setInt(2, Integer.parseInt(userID));
            pst.setInt(3, Integer.parseInt(p.getID()));
            rs = pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public int removeCartProductDB(String userID, Prodotto p) {
        int rs = 0;
        try {

            PreparedStatement pst = this.c.prepareStatement("DELETE FROM Carrello WHERE uID=? AND pID=?");
            pst.setInt(1, Integer.parseInt(userID));
            pst.setInt(2, Integer.parseInt(p.getID()));
            rs = pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
