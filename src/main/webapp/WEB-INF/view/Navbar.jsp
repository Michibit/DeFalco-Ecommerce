<%@ page import="model.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 13/06/22
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/nav2.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/script/AutoComplete.js"></script>

<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
<nav class="navbar">
    <div class="nav">
        <img src="${pageContext.request.contextPath}/icons/eagle.png" class="brand-logo" alt="">
        <div class="nav-items">
            <div class="search">
                <form action="SearchServlet" method="get">
                    <input type="text" name="search" id="search" class="search-box" placeholder="Cerca qui...">
                    <button type="submit" class="search-btn">Cerca</button>
                </form>
            </div>
            <% if (session.getAttribute("Cliente") != null) {
                Cliente cliente = (Cliente) session.getAttribute("Cliente");
            %>
            <p class="utente" style="text-transform: capitalize;font-size: 16px;font-style: italic">
                Benvenuto <%= cliente.getUsername() %>
            </p>
            <%}%>
            <a href="EntryServlet?get=profile"><i class='bx bx-user bx-md '></i></a>
            <a href="EntryServlet?get=car"><i class='bx bx-cart bx-md'></i></a>
            <% if (session.getAttribute("Cliente") != null) {
                Cliente cliente = (Cliente) session.getAttribute("Cliente");
            %>

            <a href="LogoutServlet"><i class='bx bx-log-out bx-flip-vertical bx-md bx-fade-left-hover'></i></a>
            <%} else {%>
            <a href="EntryServlet?get=login"><i class='bx bx-log-in bx-flip-vertical bx-md bx-fade-right-hover'></i></a>
            <%}%>
        </div>
    </div>
    <ul class="links-container">
        <li class="link-item"><a href="UtenteServlet?act=homepage" class="link">Home</a></li>
        <li class="link-item"><a href="UtenteServlet?act=prodotto&genere=Uomo" class="link">Uomo</a></li>
        <li class="link-item"><a href="UtenteServlet?act=prodotto&genere=Donna" class="link">Donna</a></li>
        <li class="link-item"><a href="UtenteServlet?act=prodotto&genere=Bambino" class="link">Bambino</a></li>
    </ul>
</nav>

