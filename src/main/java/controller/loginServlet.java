package controller;

import dao.CarrelloDao;
import dao.ClienteDAO;
import dao.ConnectionDB;
import dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.Cliente;
import model.Prodotti;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        boolean validate = LoginDao.validate(username, pass);

        if (validate) {
            Connection con = ConnectionDB.getConnection();
            ClienteDAO dao = new ClienteDAO(con);
            Cliente c = dao.cercaUtente(username, pass);

            //Verifico se l'utente aveva un carrello prima di loggare
            if (request.getSession().getAttribute("cart-list") != null) {
                CarrelloDao dao1 = new CarrelloDao(con);
                ArrayList<Carrello> cartlist = (ArrayList<Carrello>) request.getSession().getAttribute("cart-list");
                ArrayList<Carrello> userCart = c.getCarrello();
                //Se il carrello utente è vuoto ma aveva aggiunto degli elementi
                if (userCart == null) {
                    c.setCarrello(cartlist);
                } else {
                    boolean isIn = false;
                    for (Carrello cart : userCart) {
                        for (Carrello noLogCart : cartlist) {
                            for (Prodotti noLogPr : noLogCart.getP()) {
                                for (Prodotti pr : cart.getP()) {
                                    if (pr.getP().equals(noLogPr.getP())) {
                                        pr.setQuantita(pr.getQuantita() + noLogPr.getQuantita());
                                        dao1.updateCart(c.getID(), pr.getP(), pr.getQuantita());
                                        isIn = true;
                                    }
                                }
                                if (!isIn) {
                                    cart.getP().add(noLogPr);
                                    dao1.addProductCartDB(c.getID(), noLogPr.getP(), noLogPr.getQuantita());
                                }
                            }
                        }
                    }
                }
            }
            request.getSession().setAttribute("Cliente", c);
            request.getSession().removeAttribute("cart-list");
            request.getRequestDispatcher("/WEB-INF/view/HomeLogged.jsp").forward(
                    request, response);
        } else {
            String errore = "Credenziali errate!";
            request.setAttribute("msg", errore);
            request.getRequestDispatcher("/WEB-INF/view/LoginPage.jsp").forward(
                    request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
