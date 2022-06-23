<%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 22/06/22
  Time: 02:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="/script/previewImage.js"></script>

<form action="NewProductServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="image" accept="image/*" onchange="showPreview(event);">>
    <label>
        <input type="text" name="nome" placeholder="Nome Prodotto">
    </label>
    <textarea name="descrizione" placeholder="Inserisci una descrizione"></textarea>

    <input type="number" name="prezzo" placeholder="Prezzo">

    <input type="submit" value="Aggiungi prodotto">

</form>

<img id="preview">

</body>
</html>
