package dao;

import model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO {
    private final Connection con;
    private String donna="Grintoso ed elegante, femminile e romantico, l'abbigliamento da donna online di Defalco è multi-sfaccettato, proprio come le donne di oggi.";
    private String bambino = "Abiti di abbigliamento e accessori per bambino e bambina da 0 a 16 anni. Tanti modelli di tendenza per vestire i tuoi bimbi con la moda del momento.";
    private String Uomo="Per l'uomo che non rinuncia all'eleganza e vuole rimanere aggiornato sulle ultime tendenze. Tutto sulla moda uomo del momento.";
    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    public Categoria getCategoriaByGenere(String genere) {
        PreparedStatement pst = null;
        Categoria c = new Categoria();
        try {
            pst = con.prepareStatement("SELECT * FROM Categoria WHERE Genere=? ");
            pst.setString(1, genere);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c.setGenere(rs.getString("genere"));
                c.setNome(rs.getString("nome"));
                c.setDescrizione(rs.getString("Descrizione"));
                c.setIcona(rs.getString("Icona"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return c;
    }

    public Categoria getCategoriaByNome(String nome) {
        PreparedStatement pst = null;
        Categoria c = new Categoria();
        try {
            pst = con.prepareStatement("SELECT * FROM Categoria WHERE Nome=? ");
            pst.setString(1, nome);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c.setGenere(rs.getString("genere"));
                c.setNome(rs.getString("nome"));
                c.setDescrizione(rs.getString("Descrizione"));
                c.setIcona(rs.getString("Icona"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return c;
    }

    public boolean isCategoryIn(String genere, String nome) {
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("SELECT * FROM Categoria WHERE Genere=? AND " +
                    "NOME=? ");
            pst.setString(1, genere);
            pst.setString(2, nome);

            ResultSet rs = pst.executeQuery();

            return rs.next();


        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public Categoria getCategoriaByGenereNome(String genere, String nome) {
        PreparedStatement pst = null;
        Categoria c = new Categoria();
        try {
            pst = con.prepareStatement("SELECT * FROM Categoria WHERE Genere=? AND " +
                    "NOME=? ");
            pst.setString(1, genere);
            pst.setString(2, nome);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c.setGenere(rs.getString("genere"));
                c.setNome(rs.getString("nome"));
                c.setDescrizione(rs.getString("Descrizione"));
                c.setIcona(rs.getString("Icona"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return c;
    }


    public int insertNewCategory(String Genere, String Nome) {
        int rs;
        try {
            PreparedStatement pst = this.con.prepareStatement("INSERT INTO Categoria " +
                    "( Genere,Nome,Descrizione) VALUES(?,?,?)");
            String descrizione = null;
            pst.setString(1, Genere);
            pst.setString(2, Nome);
            if(Genere.equalsIgnoreCase("uomo"))
                descrizione = this.Uomo;
            else if (Genere.equalsIgnoreCase("donna")) {
                descrizione = this.donna;
            } else if (Genere.equalsIgnoreCase("bambino")) {
                descrizione = this.bambino;
            }

            pst.setString(3,descrizione);


            rs = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

}
