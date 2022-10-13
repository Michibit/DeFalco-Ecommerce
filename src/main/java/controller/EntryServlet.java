package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.Cliente;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EntryServlet", value = "/EntryServlet")
public class EntryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = null;
        String s = request.getParameter("get");

        //Loggato
        if (request.getSession().getAttribute("Cliente") != null) {
            Cliente c = (Cliente) request.getSession().getAttribute("Cliente");
            //Profile Page
            if (s.equalsIgnoreCase("profile")) {
                if (c.getAdmin())
                    s1 = "WEB-INF/view/DashboardAdminPage.jsp";
                else
                    s1 = "WEB-INF/view/ProfilePage.jsp";
            } else if (s.equalsIgnoreCase("car")) {
                s1 = "WEB-INF/view/Carrello.jsp";
            } else if (s.equalsIgnoreCase("order")) {
                s1 = "WEB-INF/view/UserOrder.jsp";
            }
        }
        //Non loggato
        else {
            s1 = "WEB-INF/view/LoginPage.jsp";
            if (s.equalsIgnoreCase("reg")) {
                s1 = "WEB-INF/view/RegisterPage.jsp";
            } else if (s.equalsIgnoreCase("car")) {
                if (request.getSession().getAttribute("cart-list") == null) {
                    ArrayList<Carrello> cartList = new ArrayList<>();
                    request.getSession().setAttribute("cart-list", cartList);
                }
                s1 = "WEB-INF/view/Carrello.jsp";
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(s1);

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
