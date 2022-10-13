package controller;

import dao.ConnectionDB;
import dao.ProdottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s2 = request.getParameter("act");
        String s1 = null;
        if (s2.equalsIgnoreCase("addProduct"))
            s1 = "/WEB-INF/view/AddProduct.jsp";
        else if (s2.equalsIgnoreCase("modProduct")) {
            String id = request.getParameter("id");
            ProdottoDAO d = new ProdottoDAO(ConnectionDB.getConnection());
            request.getSession().setAttribute("Prodotto", d.getSingleProduct(Integer.parseInt(id)));
            s1 = "/WEB-INF/view/ModificaProdotto.jsp";
        } else if (s2.equalsIgnoreCase("allProduct")) {
            s1 = "/WEB-INF/view/ProdottiAdmin.jsp";
        } else if (s2.equalsIgnoreCase("dashboard")) {
            s1 = "/WEB-INF/view/DashboardAdminPage.jsp";
        } else if (s2.equalsIgnoreCase("ordini")) {
            s1 = "/WEB-INF/view/OrdiniAdmin.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(s1);

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
