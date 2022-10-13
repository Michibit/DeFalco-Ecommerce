<%@ page import="model.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 22/06/22
  Time: 02:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <%
        Prodotto p = (Prodotto) request.getSession().getAttribute("Prodotto");

    %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/home2.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<form action="ProductServlet?act=mod" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="<%=p.getID()%>">
    <input type="file" id="img" name="image" accept="image/*">

    <input type="text" name="nome" id="nome" value="<%=p.getNome()%>"
           onkeyup="document.querySelector('.product-brand').innerHTML = this.value">
    <select name="Genere" id="Genere">
        <option value="<%=p.getGenere()%>"></option>
        <option value="Uomo">Uomo</option>
        <option value="Donna">Donna</option>
        <option value="Bambino">Bambino</option>
    </select>
    <input type="text" name="NomeCategoria" id="NomeCategoria" value="<%=p.getNomeCategoria()%>">

    <textarea onkeyup="document.querySelector('.product-short-desc').innerHTML = this.value" name="descrizione"
              id="descrizione"><%=p.getDecrizione()%></textarea>

    <input onkeyup="document.querySelector('.prezzo').innerHTML = this.value + '€'" type="number" name="prezzo" min=0
           step="0.01" id="prezzo" value="<%=p.getPrezzo()%>">

    <input type="submit" value="Modifica prodotto">

</form>

<div class="product-card">
    <h2>Anteprima</h2>
    <div class="product-image">
        <img class="product-thumb" alt="" src="<%=p.getImg()%>">
    </div>
    <div class="product-info">
        <h2 class="product-brand">
        </h2>
        <p class="product-short-desc">
        </p>
        <span class="prezzo"></span>
    </div>
</div>

<script src="${pageContext.request.contextPath}/script/previewImage.js"></script>
<script src="${pageContext.request.contextPath}/script/AutoComplete.js"></script>
<style>
    .product-card {
        position: absolute;
        width: 300px;
        height: 200px;
        z-index: 10;
        top: 50%;
        left: 50%;
        margin: -300px -150px;
    }
</style>
</body>
</html>
