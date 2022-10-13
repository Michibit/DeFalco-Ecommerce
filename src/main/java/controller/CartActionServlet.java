package controller;

import dao.CarrelloDao;
import dao.ConnectionDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.Cliente;
import model.Prodotti;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartActionServlet", value = "/CartActionServlet")
public class CartActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Carrello> cart_list = new ArrayList<>();
        Cliente user = null;
        if (request.getSession().getAttribute("Cliente") != null) {
            user = (Cliente) request.getSession().getAttribute("Cliente");
            cart_list = user.getCarrello();
        } else if (request.getSession().getAttribute("cart-list") != null) {
            cart_list = (ArrayList<Carrello>) request.getSession().getAttribute("cart-list");
        }
        CarrelloDao dao = new CarrelloDao(ConnectionDB.getConnection());

        if (action != null && id >= 1) {
            if (action.equals("inc")) {
                for (Carrello c : cart_list) {
                    for (Prodotti p : c.getP()) {
                        if (p.getP().getID().equalsIgnoreCase(String.valueOf(id))) {
                            int quantity = p.getQuantita();
                            quantity++;
                            p.setQuantita(quantity);
                            if (user != null) {
                                dao.updateCart(user.getID(), p.getP(), p.getQuantita());
                                continue;
                            }
                            //Solo se non sono loggato
                            request.getSession().setAttribute("cart-list", cart_list);
                            break;
                        }
                    }
                }
            }


            if (action.equals("dec")) {
                for (Carrello c : cart_list) {
                    for (Prodotti p : c.getP()) {
                        if (p.getP().getID().equalsIgnoreCase(String.valueOf(id)) && p.getQuantita() > 1) {
                            int quantity = p.getQuantita();
                            quantity--;
                            p.setQuantita(quantity);
                            if (user != null) {
                                dao.updateCart(user.getID(), p.getP(), p.getQuantita());
                                continue;
                            }
                            request.getSession().setAttribute("cart-list", cart_list);
                            break;
                        }
                    }
                }
            }
            if (action.equals("rem")) {
                for (int i = 0; i < cart_list.size(); i++) {
                    Carrello c = cart_list.get(i);
                    for (int j = 0; j < c.getP().size(); j++) {
                        Prodotti p = c.getP().get(j);
                        if (p.getP().getID().equalsIgnoreCase(String.valueOf(id))) {
                            c.getP().remove(j);
                            if (user != null) {
                                dao.removeCartProductDB(user.getID(), p.getP());
                                continue;
                            }
                            request.getSession().setAttribute("cart-list", cart_list);
                            break;
                        }
                    }
                }
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/Carrello.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
