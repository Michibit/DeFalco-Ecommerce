package controller;

import dao.ConnectionDB;
import dao.OrdineDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.Cliente;
import model.Ordine;
import model.Prodotti;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "CheckOutServlet", value = "/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        Date date = new Date();
        String s1 = null;

        //Utente Loggato
        if (request.getSession().getAttribute("Cliente") != null) {
            Cliente auth = (Cliente) request.getSession().getAttribute("Cliente");
            ArrayList<Carrello> cart_list = auth.getCarrello();
            if (cart_list != null) {
                Ordine order = new Ordine();
                order.setUserID(auth.getID());
                for (Carrello c : cart_list) {
                    for (Prodotti p : c.getP()) {
                        order.setProdotti(p.getP(), p.getQuantita());
                    }
                    order.setDataOrdine(formatter.format(date));
                    order.setStato("Ordinato");
                }
                OrdineDAO oDao = new OrdineDAO(ConnectionDB.getConnection());
                boolean result = oDao.insertOrder(order);
            }
            cart_list.clear();
            s1 = "/WEB-INF/view/Carrello.jsp";
        } else {
            s1 = "/WEB-INF/view/LoginPage.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(s1);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
