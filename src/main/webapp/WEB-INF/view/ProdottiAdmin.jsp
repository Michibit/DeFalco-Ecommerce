<%@ page import="model.Prodotti" %>
<%@ page import="dao.ProdottoDAO" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 09/07/22
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <%
        ProdottoDAO prodottoDAO = new ProdottoDAO(ConnectionDB.getConnection());
        Cliente c = (Cliente) session.getAttribute("Cliente");

        ArrayList<Prodotto> allProducts = prodottoDAO.getAllProducts();

    %>
    <title>Prodotti | DeFalco</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/adminPage.css">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<%@include file="NavbarAdmin.jsp" %>
<section class="home-section">
    <nav>
        <div class="sidebar-button">
            <i class='bx bx-menu sidebarBtn'></i>
            <span class="dashboard">Prodotti</span>
        </div>
        <div class="search-box">
            <form action="SearchServlet" method="get">
                <input type="text" id="search" class="search-box" name="search" placeholder="Cerca qui...">
                <button type="submit" class="search-btn">
                </button>
            </form>
        </div>
        <div class="profile-details">
            <span class="admin_name">Ciao <%=c.getUsername()%></span>
        </div>
    </nav>
    <div class="product box">
        <div class="title">Tutti i Prodotti</div>

        <table class="sales-details" style="margin-block-start: 70px;">
            <tr class="section">
                <th>Anteprima</th>
                <th>Nome</th>
                <th>Genere</th>
                <th>Nome Categoria</th>
                <th>Prezzo</th>
                <th>Modifica</th>
            </tr>
            <%
                for (Prodotto p : allProducts) {
            %>
            <tr>
                <td><img src="<%=p.getImg()%>" class="imgThumb"></td>
                <td><%=p.getNome()%>
                </td>
                <td><%=p.getGenere()%>
                </td>
                <td><%=p.getNomeCategoria()%>
                </td>
                <td><%=p.getPrezzo()%>€</td>
                <td><a href="AdminServlet?act=modProduct&id=<%=p.getID()%>"><i class='bx bx-edit-alt'></i></a></td>
            </tr>
            <% }%>
        </table>
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
