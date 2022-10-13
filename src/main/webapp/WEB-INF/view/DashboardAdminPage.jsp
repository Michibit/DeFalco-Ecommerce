<%@ page import="model.Cliente" %>
<%@ page import="dao.OrdineDAO" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ordine" %>
<%@ page import="model.Prodotti" %>
<%@ page import="dao.ClienteDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 27/06/22
  Time: 03:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/script/AutoComplete.js"></script>
    <% Cliente c = (Cliente) session.getAttribute("Cliente");
        Connection con = ConnectionDB.getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        String isAdded = (String) session.getAttribute("isAdded");
        OrdineDAO o = new OrdineDAO(con);
        ArrayList<Ordine> allOrders = o.getAlluserOrdersbyDate();
        double totalOrder = 0;
        int numProdotti = 0;
        int numOrdini = 0;
        for (Ordine or : allOrders) {
            for (Prodotti p : or.getProdotti()) {
                totalOrder = totalOrder + p.getPrezzoQuantity();
                numProdotti = numProdotti + p.getQuantita();
                numOrdini++;
            }
        }
    %>
    <meta charset="UTF-8">
    <title> Admin Dashboard | DeFalco </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/adminPage.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<%@include file="NavbarAdmin.jsp" %>
<section class="home-section">
    <nav>
        <div class="sidebar-button">
            <i class='bx bx-menu sidebarBtn'></i>
            <span class="dashboard">Dashboard</span>
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

    <div class="home-content">
        <div class="overview-boxes">
            <div class="box">
                <div class="right-side">
                    <div class="box-topic">Numero Ordini</div>
                    <div class="number"><%=numOrdini%>
                    </div>
                </div>
                <i class='bx bx-cart-alt cart'></i>
            </div>

            <div class="box">
                <div class="right-side">
                    <a class="fancy" href="AdminServlet?act=addProduct">
                        <span class="top-key"></span>
                        <span class="text">Aggiungi Prodotto</span>
                        <span class="bottom-key-1"></span>
                        <span class="bottom-key-2"></span>
                    </a>
                    <%if (isAdded != null) {%>
                    <p class="isAdded"><%=isAdded%>
                    </p>
                    <%}%>
                </div>
            </div>

            <div class="box">
                <div class="right-side">
                    <div class="box-topic">Prodotti Venduti</div>
                    <div class="number"><%=numProdotti%>
                    </div>
                </div>
                <i class='bx bxs-cart-add cart two'></i>
            </div>
            <div class="box">
                <div class="right-side">
                    <div class="box-topic">Profitto</div>
                    <div class="number"><%=Math.round(totalOrder * 100.0) / 100.0%> €</div>
                </div>
                <i class='bx bxs-credit-card cart bx-md three'></i>
            </div>
        </div>

        <div class="sales-boxes">
            <div class="recent-sales box">
                <div class="title">Ultimi Ordini</div>
                <table class="sales-details">
                    <tr class="section">
                        <th>Data</th>
                        <th>Cliente</th>
                        <th>Acquisto</th>
                        <th>Totale</th>
                    </tr>
                    <%
                        for (int i = 0; i < allOrders.size() && i < 7; i++) {
                            Ordine ordine = allOrders.get(i);
                    %>
                    <tr>

                        <td><%=ordine.getDataOrdine()%>
                        </td>
                        <td><%=clienteDAO.cercaUtenteByID(ordine.getUserID()).getUsername()%>
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
                    </tr>
                    <%}%>
                </table>

                <div class="button">
                    <a href="AdminServlet?act=ordini">Vedi tutti</a>
                </div>
            </div>
            <div class="top-sales box">
                <div class="title">Ultimi prodotti Venduti</div>

                <table class="sales-details">
                    <tr class="section">
                        <th>Preview</th>
                        <th>Nome</th>
                        <th>Quantità</th>
                        <th>Totale</th>
                    </tr>
                    <% int j = 0;
                        for (int i = 0; i < allOrders.size(); i++) {
                            Ordine ordine = allOrders.get(i);
                    %>
                    <%
                        for (Prodotti p : ordine.getP()) {
                    %>
                    <tr>
                        <td><img src="<%=p.getP().getImg()%>" class="imgThumb"></td>
                        <td><%=p.getP().getNome()%>
                        </td>
                        <td><%=p.getQuantita()%>
                        </td>
                        <td><%=p.getPrezzoQuantity()%>€</td>
                    </tr>
                    <% if (j >= 7) break;
                        j++;
                    }%>
                    <%
                            if (j >= 7) break;
                        }
                    %>
                </table>
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