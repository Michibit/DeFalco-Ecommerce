package controller;

import dao.ConnectionDB;
import dao.FatturazioneDAO;
import dao.OrdineDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Fatturazione;

import java.io.IOException;

@WebServlet(name = "ProfilePageServlet", value = "/ProfilePageServlet")
public class ProfilePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        String s1 = null;

        if (act.equalsIgnoreCase("mod")) {
            s1 = "/WEB-INF/view/ProfilePageMod.jsp";

        } else if (act.equalsIgnoreCase("modSave")) {

            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String indirizzo = request.getParameter("indirizzo");
            String cap = request.getParameter("cap");
            String citta = request.getParameter("citta");
            FatturazioneDAO fdao = new FatturazioneDAO(ConnectionDB.getConnection());
            Cliente c = (Cliente) request.getSession().getAttribute("Cliente");
            if (fdao.getFatturazionebyUserID(Integer.parseInt(c.getID())) == null) {
                fdao.insertNewFatturazione(c.getID(), nome, cognome, indirizzo, cap, citta);
            } else {
                Fatturazione f = fdao.getFatturazionebyUser(Integer.parseInt(c.getID()), indirizzo, cap, citta);
                if (f != null) {
                    fdao.deleteFatturaioneByUserID(c.getID());
                    fdao.insertNewFatturazione(c.getID(), nome, cognome, indirizzo, cap, citta);
                } else fdao.insertNewFatturazione(c.getID(), nome, cognome, indirizzo, cap, citta);
            }
            s1 = "/WEB-INF/view/ProfilePage.jsp";

        } else if (act.equalsIgnoreCase("order")) {
            String idOrdine = request.getParameter("id");
            OrdineDAO dao = new OrdineDAO(ConnectionDB.getConnection());
            request.setAttribute("Ordine", dao.getOrder(idOrdine));
            Cliente c = (Cliente) request.getSession().getAttribute("Cliente");
            if (c.isAdmin())
                s1 = "/WEB-INF/view/AdminOrdiniDet.jsp";
            else s1 = "/WEB-INF/view/UserOrderDet.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(s1);

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
