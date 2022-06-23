<%@ page import="model.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 13/06/22
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar">
    <div class="nav">
        <img src="./icons/eagle.png" class="brand-logo" alt="">
        <div class="nav-items">
            <div class="search">
                    <input type="text" class="search-box" placeholder="Cerca qui...">

                <button class="search-btn">Cerca</button>
            </div>
            <% if(session.getAttribute("Cliente") != null){
                Cliente cliente = (Cliente)session.getAttribute("Cliente");%>

            <p class="utente" style="text-transform: capitalize;font-size: 16px;font-style: italic">Benvenuto <%= cliente.getUsername() %></p>
            <%}%>
            <a  href="EntryServlet?get=login"><img src="./icons/iconmonstr-user-6.svg" alt=""></a>
            <a href="EntryServlet?get=car"><img src="./icons/iconmonstr-shopping-cart-thin.svg" alt=""></a>

        </div>
    </div>
    <ul class="links-container">
        <li class="link-item"><a href="#" class="link">Home</a></li>
        <li class="link-item"><a href="#" class="link">Uomo</a></li>
        <li class="link-item"><a href="#" class="link">Donna</a></li>
        <li class="link-item"><a href="#" class="link">Bambino</a></li>
    </ul>
</nav>

