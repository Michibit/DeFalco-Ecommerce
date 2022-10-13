<%--
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/home2.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<form action="ProductServlet?act=add" method="post" enctype="multipart/form-data">
    <input type="file" id="img" name="image" accept="image/*">

    <input type="text" name="nome" id="nome" placeholder="Nome Prodotto"
           onkeyup="document.querySelector('.product-brand').innerHTML = this.value">
    <select name="Genere" id="Genere">
        <option value="">--Scegli il genere--</option>
        <option value="Uomo">Uomo</option>
        <option value="Donna">Donna</option>
        <option value="Bambino">Bambino</option>
    </select>
    <input type="text" name="NomeCategoria" id="NomeCategoria" placeholder="Nome Categoria">

    <textarea onkeyup="document.querySelector('.product-short-desc').innerHTML = this.value" name="descrizione"
              id="descrizione" placeholder="Inserisci una descrizione"></textarea>

    <input onkeyup="document.querySelector('.prezzo').innerHTML = this.value + '€'" type="number" name="prezzo" min=0
           step="0.01" id="prezzo" placeholder="Prezzo">

    <input type="submit" value="Aggiungi prodotto">

</form>

<div class="product-card">
    <h2>PREVIEW</h2>
    <div class="product-image">
        <img class="product-thumb" alt="" src="#">
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

</body>
</html>