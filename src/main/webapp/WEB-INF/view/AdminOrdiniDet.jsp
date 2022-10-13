<%@ page import="model.Cliente" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="dao.ClienteDAO" %>
<%@ page import="dao.OrdineDAO" %>
<%@ page import="model.Ordine" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotti" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 10/07/22
  Time: 00:21
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
    <title>Ordini | DeFalco</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/adminPage.css">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<%@include file="NavbarAdmin.jsp" %>
<section class="home-section">
    <nav>
        <div class="sidebar-button">
            <i class='bx bx-menu sidebarBtn'></i>
            <span class="dashboard">Ordini</span>
        </div>
        <div class="search-box">
            <form action="SearchServlet" method="get">
                <input type="text" id="search" name="search" class="search-box" placeholder="Cerca qui...">
                <button type="submit" class="search-btn">
                </button>
            </form>
        </div>
        <div class="profile-details">
            <span class="admin_name">Ciao <%=c.getUsername()%></span>
        </div>
    </nav>
    <div class="top-sales box">
        <div class="title">Tutti gl Ordinii</div>

        <div class="main">
            <h2>Ordine n: <%=ordine.getID()%>
            </h2>
            <div class="card">
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
                    </table>
                    <h2 class="total">Totale: <%=total%>€</h2>
                </div>
            </div>
        </div>

    </div>
</section>

<script>
    let sidebar = document.querySelector(".sidebar");
    let sidebarBtn = document.querySelector(".sidebarBtn");
    sidebarBtn.onclick = function () {
        sidebar.classList.toggle("active");
        if (sidebar.classList.contains("active")) {
            sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
        } else
            sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
    }
</script>


</body>
</html>
