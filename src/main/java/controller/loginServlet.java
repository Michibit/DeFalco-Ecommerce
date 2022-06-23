package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dao.ClienteDAO;
import dao.ConnectionDB;
import dao.LoginDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        boolean validate = LoginDao.validate(username,pass);

        HttpSession session = request.getSession();
        if (validate) {
            try {
                ClienteDAO dao = new ClienteDAO(ConnectionDB.getConnection());
                request.getSession().setAttribute("Cliente", dao.cercaUtente(username,pass));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            /*String originalUrl = request.getRequestURL().toString();
            String baseUrl = originalUrl.substring(0, originalUrl.length() - request.getRequestURI().length()) + request.getContextPath();
            response.sendRedirect(baseUrl + "/WEB-INF/view/HomeLogged.jsp");
             */
            request.getRequestDispatcher("/WEB-INF/view/HomeLogged.jsp").forward(
                    request, response);
        }
        else{
            String errore = "Credenziali errate!";
            request.setAttribute("msg", errore);
            request.getRequestDispatcher("/WEB-INF/view/loginPage.jsp").forward(
                    request, response);
        }


    }
}
