package dao;

import model.Ordine;
import model.Prodotti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDAO {
    private final Connection con;

    private String query;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;
    private ResultSet rs1;


    public OrdineDAO(Connection con) {
        super();
        this.con = con;
    }

    public boolean insertOrder(Ordine model) {
        boolean result = false;
        try {
            query = "insert into Ordine (ID,userid, dataord,stato) values(?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(model.getID()));
            pst.setString(2, model.getUserID());
            pst.setString(3, model.getDataOrdine());
            pst.setString(4, model.getStato());
            pst.executeUpdate();
            CarrelloDao dao = new CarrelloDao(this.con);
            query = "insert into Composizione ( ID_Ordine, ID_Prodotto,quantita) values(?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setString(1, model.getID());
            for (Prodotti p : model.getProdotti()) {
                pst.setString(2, p.getP().getID());
                pst.setInt(3, p.getQuantita());
                dao.removeCartProductDB(model.getUserID(), p.getP());
                pst.executeUpdate();
            }

            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Ordine getOrder(String ID) {
        Ordine o = null;
        try {
            query = "select * from Ordine where ID=? order by dataord desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(ID));
            rs = pst.executeQuery();

            ProdottoDAO p = new ProdottoDAO(this.con);
            o = new Ordine();
            while (rs.next()) {
                String ordineID = String.valueOf(rs.getInt("ID"));
                //Seleziono tutti i prodotti dell'ordine
                query = "select ID_Prodotto,Quantita from Composizione where ID_Ordine=?";
                pst = this.con.prepareStatement(query);
                pst.setString(1, ordineID);
                rs1 = pst.executeQuery();
                while (rs1.next()) {
                    o.setProdotti(p.getSingleProduct(Integer.parseInt(rs1.getString("ID_Prodotto"))),
                            rs1.getInt("Quantita"));
                }
                o.setID(ordineID);
                o.setUserID(rs.getString("userid"));
                o.setStato(rs.getString("Stato"));
                o.setDataOrdine(rs.getString("dataord"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return o;
    }


    public ArrayList<Ordine> getOrderByID(String user) {
        ArrayList<Ordine> list = new ArrayList<>();
        try {
            //Seleziono tutti gli ordini dell'utente
            query = "select * from Ordine where userid=? order by dataord desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(user));
            rs = pst.executeQuery();
            ProdottoDAO p = new ProdottoDAO(this.con);
            while (rs.next()) {
                Ordine o = new Ordine();
                String ordineID = String.valueOf(rs.getInt("ID"));
                //Seleziono tutti i prodotti dell'ordine
                query = "select ID_Prodotto,Quantita from Composizione where ID_Ordine=?";
                pst = this.con.prepareStatement(query);
                pst.setString(1, ordineID);
                rs1 = pst.executeQuery();
                while (rs1.next()) {
                    o.setProdotti(p.getSingleProduct(Integer.parseInt(rs1.getString("ID_Prodotto"))),
                            rs1.getInt("Quantita"));
                }
                o.setID(ordineID);
                o.setUserID(rs.getString("userid"));
                o.setStato(rs.getString("Stato"));
                o.setDataOrdine(rs.getString("dataord"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Ordine> getAlluserOrdersbyDate() {
        ArrayList<Ordine> list = new ArrayList<>();
        try {
            //Seleziono tutti gli ordini dell'utente
            query = "select * from Ordine  order by dataord desc";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            ProdottoDAO p = new ProdottoDAO(this.con);
            while (rs.next()) {
                Ordine o = new Ordine();
                String ordineID = String.valueOf(rs.getInt("ID"));
                //Seleziono tutti i prodotti dell'ordine
                query = "select ID_Prodotto,Quantita from Composizione where ID_Ordine=?";
                pst = this.con.prepareStatement(query);
                pst.setString(1, ordineID);
                rs1 = pst.executeQuery();
                while (rs1.next()) {
                    o.setProdotti(p.getSingleProduct(Integer.parseInt(rs1.getString("ID_Prodotto"))),
                            rs1.getInt("Quantita"));
                }
                o.setID(ordineID);
                o.setUserID(rs.getString("userid"));
                o.setStato(rs.getString("Stato"));
                o.setDataOrdine(rs.getString("dataord"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Ordine> getAlluserOrders() {
        ArrayList<Ordine> list = new ArrayList<>();
        try {
            //Seleziono tutti gli ordini dell'utente
            query = "select * from Ordine";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            ProdottoDAO p = new ProdottoDAO(this.con);
            while (rs.next()) {
                Ordine o = new Ordine();
                String ordineID = String.valueOf(rs.getInt("ID"));
                //Seleziono tutti i prodotti dell'ordine
                query = "select ID_Prodotto,Quantita from Composizione where ID_Ordine=?";
                pst = this.con.prepareStatement(query);
                pst.setString(1, ordineID);
                rs1 = pst.executeQuery();
                while (rs1.next()) {
                    o.setProdotti(p.getSingleProduct(Integer.parseInt(rs1.getString("ID_Prodotto"))),
                            rs1.getInt("Quantita"));
                }
                o.setID(ordineID);
                o.setUserID(rs.getString("userid"));
                o.setStato(rs.getString("Stato"));
                o.setDataOrdine(rs.getString("dataord"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Ordine> userOrders(String id) {
        ArrayList<Ordine> list = new ArrayList<>();
        try {
            //Seleziono tutti gli ordini dell'utente
            query = "select * from Ordine where userid=? order by Ordine.ID desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(id));
            rs = pst.executeQuery();
            ProdottoDAO p = new ProdottoDAO(this.con);
            while (rs.next()) {
                Ordine o = new Ordine();
                String ordineID = String.valueOf(rs.getInt("ID"));
                //Seleziono tutti i prodotti dell'ordine
                query = "select ID_Prodotto,Quantita from Composizione where ID_Ordine=?";
                pst = this.con.prepareStatement(query);
                pst.setString(1, ordineID);
                rs1 = pst.executeQuery();
                while (rs1.next()) {
                    o.setProdotti(p.getSingleProduct(Integer.parseInt(rs1.getString("ID_Prodotto"))),
                            rs1.getInt("Quantita"));
                }
                o.setID(ordineID);
                o.setUserID(rs.getString("userid"));
                o.setStato(rs.getString("Stato"));
                o.setDataOrdine(rs.getString("dataord"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelOrder(String OrdineID) {
        //boolean result = false;
        try {
            query = "delete from Ordine where ID=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(OrdineID));
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
}

