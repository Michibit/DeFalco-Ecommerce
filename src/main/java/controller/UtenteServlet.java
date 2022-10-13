package controller;

import dao.CategoriaDAO;
import dao.ConnectionDB;
import dao.ProdottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "UtenteServlet", value = "/UtenteServlet")
public class UtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        String s1 = null;

        if (act.equalsIgnoreCase("prodotto")) {
            String genere = request.getParameter("genere");

            s1 = "WEB-INF/view/ProductPageCategory.jsp";
            Connection c = ConnectionDB.getConnection();
            ProdottoDAO dao = new ProdottoDAO(c);
            CategoriaDAO dao1 = new CategoriaDAO(c);
            request.setAttribute("Categoria", dao1.getCategoriaByGenere(genere));
            request.setAttribute("Prodotti", dao.getAllProductsByGenere(genere));

        } else if (act.equalsIgnoreCase("homepage")) {
            if (request.getSession().getAttribute("Cliente") != null) {
                s1 = "/WEB-INF/view/HomeLogged.jsp";
            } else
                s1 = "index.html";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(s1);

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
