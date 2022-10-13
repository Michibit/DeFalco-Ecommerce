package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class AjaxDAO {
    private final Connection con;

    public AjaxDAO(Connection c) {
        this.con = c;
    }

    public ArrayList<String> getCategoryLike(String Genere) {


        //select Genere from Categoria where Genere like 'u%'
        ArrayList<String> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //Genere
            ps = this.con.prepareStatement("SELECT * FROM Categoria  WHERE Genere LIKE ?");
            ps.setString(1, Genere + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String data = rs.getString("Genere");
                list.add(data);
            }
            //Nome Categoria
            ps = this.con.prepareStatement("SELECT * FROM Categoria  WHERE Nome LIKE ?");
            ps.setString(1, Genere + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String data = rs.getString("Nome");
                list.add(data);
            }
            //Nome Prodotti
            ps = this.con.prepareStatement("SELECT * FROM Prodotto  WHERE Nome LIKE ?");
            ps.setString(1, Genere + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String data = rs.getString("Nome");
                list.add(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Elimino duplicati
        Set<String> listWithoutDuplicates = new LinkedHashSet<>(list);
        list.clear();

        list.addAll(listWithoutDuplicates);
        return list;
    }
}
