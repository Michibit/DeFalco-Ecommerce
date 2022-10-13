<%@ page import="model.Cliente" %>
<%@ page import="dao.ProdottoDAO" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %><%--
      Created by IntelliJ IDEA.
      User: michelemenzione
      Date: 23/06/22
      Time: 02:19
      To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="it">

<% Cliente c;
    if ((c = (Cliente) session.getAttribute("Cliente")) != null) {
%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>De Falco | E-commerce</title>
    <meta name="description" content="De falco è un marchio di abbigliamento maschile e femminile ">
    <meta name="robots" content="index, follow">
    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/home2.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


    <!-- Carico il footer in maniera dinamica con JS-->

</head>

<body>
<nav class="navbar">
    <%@include file="Navbar.jsp" %>
</nav>

<!-- Carico la navbar in maniera dinamica con JS-->


<!-- Sezione home-->
<header class="hero-section">
    <div class="contenuto">
        <img src="./img/logo.svg" class="logo" alt="">
        <p class="sotto-logo"><img class="corsivo-img"
                                   src="${pageContext.request.contextPath}/img/la-migliore-collezione-di-tutti-i-tempi.svg">
        </p>
    </div>
</header>

<!-- Card conteiner-->
<section class="prodotti">
    <h2 class="nomeCategoria-prodotti">Ultimi arrivi</h2>
    <div class="product-conteiner">
        <%
            ProdottoDAO dao = new ProdottoDAO(ConnectionDB.getConnection());
            ArrayList<Prodotto> allP = dao.getAllProducts();
            for (int i = 0; i < 5 && i < allP.size(); i++) {
                Prodotto p = allP.get(i);
        %>
        <div class="product-card">
            <div class="product-image">
                <img src="<%=p.getImg() %>" class="product-thumb" alt="">
                <form action="CartServlet" method="get">
                    <input type="hidden" value="<%=p.getID()%>" name="id">
                    <button class="card-btn">Aggiungi al Carrello</button>
                </form>
            </div>
            <div class="product-info">
                <h2 class="product-brand"><%=p.getNome() %>
                </h2>
                <p class="product-short-desc"><%=p.getDecrizione() %>
                </p>
                <span class="prezzo"><%=p.getPrezzo()%>€</span>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</section>

<!--Animazioni-->


<!-- Collezioni-->
<section class="collection-container">
    <a href="UtenteServlet?act=prodotto&genere=donna" class="collection">
        <img src="./img/Donna-section.jpg" alt="">
        <p class="titolo-collezione"><img class="corsivo-img" src="./img/donna.svg"></p>

    </a>

    <a href="UtenteServlet?act=prodotto&genere=uomo" class="collection">
        <img src="./img/Uomo-section.jpg" alt="">
        <p class="titolo-collezione"><img class="corsivo-img" src="./img/uomo.svg"></p>

    </a>
    <a href="UtenteServlet?act=prodotto&genere=bambino" class="collection">
        <img src="./img/Bambino-section.jpg" alt="">
        <p class="titolo-collezione"><img class="corsivo-img" src="./img/bambino.svg"></p>

    </a>


</section>


<!-- Carico il footer in maniera dinamica con JS-->


<footer class="footer">
    <%@include file="Footer.jsp" %>
</footer>

</body>

</html>
