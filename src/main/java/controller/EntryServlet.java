package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EntryServlet", value = "/EntryServlet")
public class EntryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String s = (String) request.getParameter("get");
        String s1 = null;
        if(s.equalsIgnoreCase("login")){
            s1 = "WEB-INF/view/loginPage.jsp";
        }
        else if(s.equalsIgnoreCase("reg")){
            s1 = "WEB-INF/view/registerPage.jsp";
        }

        else if(s.equalsIgnoreCase("car")){
            s1 = "WEB-INF/view/addProduct.jsp";
        }



        RequestDispatcher dispatcher = request.getRequestDispatcher(s1);

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
