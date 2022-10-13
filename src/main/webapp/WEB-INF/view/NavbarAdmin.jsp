<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/script/AutoComplete.js"></script>

<div class="sidebar">
    <div class="logo-details">
        <img class="logo" src="${pageContext.request.contextPath}/icons/Tribal-Eagle-2.svg">
        <span class="logo_name">De falco</span>
    </div>
    <ul class="nav-links">
        <li>
            <a href="AdminServlet?act=dashboard" id="Dashboard">
                <i class='bx bx-grid-alt'></i>
                <span class="links_name">Dashboard</span>
            </a>
        </li>
        <li>
            <a id="Prodotti" href="AdminServlet?act=allProduct">
                <i class='bx bx-box'></i>
                <span class="links_name">Prodotti</span>
            </a>
        </li>
        <li>
            <a id="ListaOrdini" href="AdminServlet?act=ordini">
                <i class='bx bx-list-ul'></i>
                <span class="links_name">Lista Ordini</span>
            </a>
        </li>
        <li>
            <a id="OrdiniTotali" href="UtenteServlet?act=homepage">
                <i class='bx bx-home-alt'></i>
                <span class="links_name">Homepage</span>
            </a>
        </li>
        <li class="log_out">
            <a href="LogoutServlet">
                <i class='bx bx-log-out'></i>
                <span class="links_name">Log out</span>
            </a>
        </li>
    </ul>
</div>

