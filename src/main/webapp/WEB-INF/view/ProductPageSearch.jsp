<%@ page import="model.Categoria" %>
<%@ page import="dao.ProdottoDAO" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 28/06/22
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ricerca = (String) request.getAttribute("search");
    ArrayList<Prodotto> allProduct = (ArrayList<Prodotto>) request.getAttribute("Prodotti");
%>

<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/productPage.css">
    <!-- font awesome -->
</head>
<body>
<nav class="navbar">
    <%@include file="Navbar.jsp" %>
</nav>


<div class="products">
    <div class="container">
        <h1 class="lg-title">Ricerca "<%=ricerca%>"
        </h1>
        <%if (allProduct == null) {%>
        <p class="text-light">Nessun risultato
            <i class='bx bx-tired'></i>
        </p>
        <%}%>

        <div class="product-items">
            <!-- single product -->
            <%
                if (allProduct != null) {
                    for (Prodotto p : allProduct) {
            %>
            <div class="product">
                <div class="product-content">
                    <div class="product-img">
                        <img src="<%=p.getImg()%>" alt="product image">
                    </div>
                    <div class="product-btns">
                        <form action="${pageContext.request.contextPath}/CartServlet" method="get">
                            <input type="hidden" name="id" value="<%=p.getID()%>">
                            <button type="submit" class="btn-cart">Aggiungi al carrello</button>
                        </form>
                    </div>
                </div>

                <div class="product-info">
                    <div class="product-info-top">
                        <h2 class="sm-title"><%=p.getNome()%>
                        </h2>
                    </div>
                    <a href="#" class="product-name"><%=p.getDecrizione()%>
                    </a>
                    <p class="product-price"><%=p.getPrezzo()%>€ </p>
                </div>
                <!--
                <div class = "off-info">
                    <h2 class = "sm-title">25% off</h2>
                </div>
                -->
            </div>
            <%
                    }
                }
            %>
            <!-- end of single product -->
        </div>
    </div>
</div>
</body>
</html>

