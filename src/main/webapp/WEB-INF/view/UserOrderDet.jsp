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
        Ordine ordine = (Ordine) request.getAttribute("Ordine");
        request.removeAttribute("Ordine");%>

    <title>De Falco| Ordine</title>
</head>
<body>

<!-- Navbar -->
<%@include file="Navbar.jsp" %>
<!-- End -->


<!-- Sidenav -->
<%@include file="SideNavUser.jsp" %>
<!-- End -->
<div class="main">
    <h2>Ordine n:<%=ordine.getID()%>
    </h2>
    <div class="card order">
        <div class="card-body">
            <table class="sales-details">
                <tr class="section">
                    <th>Prodotto</th>
                    <th>Nome</th>
                    <th>Quantita</th>
                    <th>Totale</th>
                </tr>

                <%
                    double total = 0;
                    for (Prodotti p : ordine.getP()) {
                        total += p.getPrezzoQuantity();
                %>
                <tr>
                    <td><img class="imgThumb" src="<%=p.getP().getImg()%>"></td>
                    <td><%=p.getP().getNome()%>
                    </td>
                    <td><%=p.getQuantita()%>
                    </td>
                    <td><%=p.getPrezzoQuantity()%>€</td>
                </tr>
                <%}%>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td style="color: red; font-weight: bold">Totale: <%=total%>€</td>
                </tr>
            </table>

        </div>
    </div>
</div>

</body>
</html>
