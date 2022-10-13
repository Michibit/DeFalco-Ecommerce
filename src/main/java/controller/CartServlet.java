package controller;

import dao.CarrelloDao;
import dao.ConnectionDB;
import dao.ProdottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.Cliente;
import model.Prodotti;
import model.Prodotto;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = "/WEB-INF/view/Carrello.jsp";
        Connection con = ConnectionDB.getConnection();

        //Dao
        ProdottoDAO dao = new ProdottoDAO(con);
        CarrelloDao carrelloDao = new CarrelloDao(con);

        //PRODOTTO
        int id = Integer.parseInt(request.getParameter("id"));
        Prodotto prodotto = dao.getSingleProduct(id);
        Carrello cm = new Carrello();
        cm.setP(prodotto, 1);

        //Utente loggato
        if (request.getSession().getAttribute("Cliente") != null) {
            Cliente user = (Cliente) request.getSession().getAttribute("Cliente");
            ArrayList<Carrello> cart_list = user.getCarrello();
            boolean exist = false;
            //Verifico se è presente
            for (Carrello c : cart_list) {
                for (Prodotti p : c.getP()) {
                    if (p.getP().equals(prodotto)) {
                        exist = true;
                        break;
                    }
                }
            }
            if (!exist) {
                cart_list.add(cm);
                user.setCarrello(cart_list);
                carrelloDao.addProductCartDB(user.getID(), prodotto, 1);
                request.getSession().setAttribute("Cliente", user);
            }
        }
        //Non sono loggato
        else {
            ArrayList<Carrello> cart_list = new ArrayList<>();
            if (request.getSession().getAttribute("cart-list") != null) {
                cart_list = (ArrayList<Carrello>) request.getSession().getAttribute("cart-list");
            } else {
                request.getSession().setAttribute("cart-list", cart_list);
            }

            boolean exist = false;
            for (Carrello c : cart_list) {
                for (Prodotti p : c.getP()) {
                    if (p.getP().equals(prodotto)) {
                        exist = true;
                        //Il prodotto gia esiste
                        break;
                    }
                }
            }
            if (!exist) {
                cart_list.add(cm);
                request.getSession().setAttribute("cart-list", cart_list);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(s1);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
