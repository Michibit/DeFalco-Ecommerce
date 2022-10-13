package dao;

import model.Fatturazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FatturazioneDAO {
    private Connection con;

    public FatturazioneDAO(Connection con) {
        this.con = con;
    }

    public Fatturazione getFatturazionebyUserID(int id) {
        Fatturazione p = new Fatturazione();
        try {
            String query = "select * from Fatturazione where ID_Cliente=? ";

            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                p.setID_Cliente(String.valueOf(rs.getInt("ID_Cliente")));
                p.setNome(rs.getString("Nome"));
                p.setCognome(rs.getString("Cognome"));
                p.setIndirizzo(rs.getString("Indirizzo"));
                p.setCap(rs.getString("Cap"));
                p.setCitta(rs.getString("Citta"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return p;
    }


    public Fatturazione getFatturazionebyUser(int id, String indirizzo, String cap, String citta) {
        Fatturazione p = new Fatturazione();
        try {
            String query = "select * from Fatturazione where ID_Cliente=? and Indirizzo=?" +
                    " and Cap=? and Citta=?";

            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, indirizzo);
            pst.setString(3, cap);
            pst.setString(4, citta);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                p.setID_Cliente(String.valueOf(rs.getInt("ID_Cliente")));
                p.setNome(rs.getString("Nome"));
                p.setCognome(rs.getString("Cognome"));
                p.setIndirizzo(rs.getString("Indirizzo"));
                p.setCap(rs.getString("Cap"));
                p.setCitta(rs.getString("Citta"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return p;
    }


    public int insertNewFatturazione(String ID, String nome, String cognome,
                                     String indirizzo, String cap, String citta) {
        int rs;
        try {
            PreparedStatement pst = this.con.prepareStatement("INSERT INTO Fatturazione " +
                    "( ID_Cliente, Nome, Cognome,Indirizzo,Cap,Citta) VALUES(?,?,?,?,?,?)");

            pst.setInt(1, Integer.parseInt(ID));
            pst.setString(2, nome);
            pst.setString(3, cognome);
            pst.setString(4, indirizzo);
            pst.setString(5, cap);
            pst.setString(6, citta);


            rs = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }


    public int deleteFatturaioneByUserID(String ID) {
        int rs;
        try {
            PreparedStatement pst = this.con.prepareStatement("DELETE FROM Fatturazione WHERE ID_Cliente=?");

            pst.setInt(1, Integer.parseInt(ID));


            rs = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
