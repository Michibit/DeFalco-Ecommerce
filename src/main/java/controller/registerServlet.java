package controller;

import dao.RegisterDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        int validate = RegisterDAO.registerUser(username, pass, email);
        String s1 = null;
        if (validate != 0) {
            s1 = "WEB-INF/view/status/SuccesUser.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(s1);
            dispatcher.forward(request, response);
        }
    }
}

        
        
