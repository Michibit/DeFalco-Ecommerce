<%@ page import="model.Ordine" %>
<%@ page import="dao.OrdineDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="model.Prodotti" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 10/07/22
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/profilePage.css">
    <%
        Connection con = ConnectionDB.getConnection();
        Cliente c = (Cliente) session.getAttribute("Cliente");
        OrdineDAO ordineDAO = new OrdineDAO(con);
        ArrayList<Ordine> allOrders = ordineDAO.getOrderByID(c.getID());%>
    <title>De Falco| Ordini</title>
</head>
<body>

<!-- Navbar -->
<%@include file="Navbar.jsp" %>
<!-- End -->


<!-- Sidenav -->
<%@include file="SideNavUser.jsp" %>
<!-- End -->
<div class="main">
    <h2>Odini</h2>
    <div class="card order">
        <div class="card-body">
            <table class="sales-details">
                <tr class="section">
                    <th>Data</th>
                    <th>Stato</th>
                    <th>Totale</th>
                    <th>Dettagli</th>
                </tr>
                <%
                    for (int i = 0; i < allOrders.size(); i++) {
                        Ordine ordine = allOrders.get(i);
                %>
                <tr>

                    <td><%=ordine.getDataOrdine()%>
                    </td>
                    <td><%=ordine.getStato()%>
                    </td>
                    <%
                        double total = 0;
                        for (Prodotti p : ordine.getP()) {
                            total += p.getPrezzoQuantity();
                        }
                    %>

                    <td><%=total%>€</td>
                    <td><a href="ProfilePageServlet?act=order&id=<%=ordine.getID()%>"><i class='bx bx-package'></i></a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
</div>

</body>
</html>
