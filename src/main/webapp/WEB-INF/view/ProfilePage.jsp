<%@ page import="model.Fatturazione" %>
<%@ page import="dao.FatturazioneDAO" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.OrdineDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ordine" %>
<%@ page import="model.Prodotti" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 10/07/22
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>De Falco | Profilo</title>

    <!-- Custom Css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/profilePage.css">


    <%
        Cliente c = (Cliente) session.getAttribute("Cliente");
        Connection con = ConnectionDB.getConnection();
        OrdineDAO ordineDAO = new OrdineDAO(con);
        ArrayList<Ordine> allOrders = ordineDAO.getOrderByID(c.getID());
        FatturazioneDAO dao = new FatturazioneDAO(con);
        Fatturazione f = dao.getFatturazionebyUserID(Integer.parseInt(c.getID()));

        int numOrdini = allOrders.size();

    %>
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>


<!-- Navbar -->
<%@include file="Navbar.jsp" %>
<!-- End -->


<!-- Sidenav -->
<%@include file="SideNavUser.jsp" %>
<!-- End -->

<!-- Main -->
<div class="main">
    <h2>Identità</h2>
    <div class="card user">
        <div class="card-body">
            <table>

                <tr>
                    <td>Username: </td>
                    <td><%=c.getUsername()%>
                    </td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><%=c.getEmail()%>
                    </td>
                </tr>
                <tr>
                    <td>Ordini Effettuati:</td>
                    <td><%=numOrdini%>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <h2>Fatturazione</h2>
    <div class="card">
        <div class="card-body">
            <a href="ProfilePageServlet?act=mod"><i class='bx bx-edit-alt'></i></a>
            <table>

                <tr>
                    <td>Nome: </td>

                    <td><%=f.getNome()%>
                    </td>
                </tr>
                <tr>
                    <td>Cognome: </td>
                    <td><%=f.getCognome()%>
                    </td>
                </tr>
                <tr>
                    <td>Indirizzo: </td>

                    <td><%=f.getIndirizzo()%>, <%=f.getCap()%>, <%=f.getCitta()%>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<!-- End -->
</body>
</html>

