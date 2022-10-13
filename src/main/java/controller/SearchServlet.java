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
import java.sql.Connection;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        request.setAttribute("search", search);
        Connection con = ConnectionDB.getConnection();


        ProdottoDAO prodDao = new ProdottoDAO(con);

        if (prodDao.getAllProductsByGenere(search).size() != 0) {
            request.setAttribute("Prodotti", prodDao.getAllProductsByGenere(search));

        } else if (prodDao.getAllProductsByNomeCat(search).size() != 0) {
            request.setAttribute("Prodotti", prodDao.getAllProductsByNomeCat(search));
        } else if (prodDao.getAllProductsByNome(search).size() != 0) {
            request.setAttribute("Prodotti", prodDao.getAllProductsByNome(search));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/ProductPageSearch.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
