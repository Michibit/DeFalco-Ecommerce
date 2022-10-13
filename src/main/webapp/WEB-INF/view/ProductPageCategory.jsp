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
<%Categoria cat = (Categoria) session.getAttribute("Categoria");
    ProdottoDAO dao = new ProdottoDAO(ConnectionDB.getConnection());
    ArrayList< Prodotto> allProduct = dao.getAllProductsByCategory(cat.getID());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/productPage.css">
    <!-- font awesome -->
    <script src="https://kit.fontawesome.com/dbed6b6114.js" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar">
    <%@include file="Navbar.jsp" %>
</nav>


<div class = "products">
    <div class = "container">
        <h1 class = "lg-title"><%=cat.getNome()%> </h1>
        <p class = "text-light"><%=cat.getDescrizione()%></p>

        <div class = "product-items">
            <!-- single product -->
            <%for(Prodotto p : allProduct){
            %>
            <div class = "product">
                <div class = "product-content">
                    <div class = "product-img">
                        <img src = "<%=p.getImg()%>" alt = "product image">
                    </div>
                    <div class = "product-btns">
                        <button type = "button" class = "btn-cart"> Aggiungi al Carrello
                            <span><i class = "fas fa-plus"></i></span>
                        </button>
                    </div>
                </div>

                <div class = "product-info">
                    <div class = "product-info-top">
                        <h2 class = "sm-title"> <%=p.getNome()%> </h2>
                    </div>
                    <a href = "#" class = "product-name"><%=p.getDecrizione()%> </a>
                    <p class = "product-price"><%=p.getPrezzo()%>€ </p>
                </div>
                <!--
                <div class = "off-info">
                    <h2 class = "sm-title">25% off</h2>
                </div>
                -->
            </div>
            <%}%>
            <!-- end of single product -->
        </div>
    </div>
</div>

<div class = "product-collection">
    <div class = "container">
        <div class = "product-collection-wrapper">
            <!-- product col left -->
            <div class = "product-col-left flex">
                <div class = "product-col-content">
                    <h2 class = "sm-title">men's shoes </h2>
                    <h2 class = "md-title">men's collection </h2>
                    <p class = "text-light">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae consequatur facilis eligendi quibusdam voluptatibus exercitationem autem voluptatum, beatae architecto odit, quisquam repellat. Deleniti, architecto ab.</p>
                    <button type = "button" class = "btn-dark">Shop now</button>
                </div>
            </div>

            <!-- product col right -->
            <div class = "product-col-right">
                <div class = "product-col-r-top flex">
                    <div class = "product-col-content">
                        <h2 class = "sm-title">women's dresses </h2>
                        <h2 class = "md-title">women's collection </h2>
                        <p class = "text-light">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae consequatur facilis eligendi quibusdam voluptatibus exercitationem autem voluptatum, beatae architecto odit, quisquam repellat. Deleniti, architecto ab.</p>
                        <button type = "button" class = "btn-dark">Shop now</button>
                    </div>
                </div>

                <div class = "product-col-r-bottom">
                    <!-- left -->
                    <div class = "flex">
                        <div class = "product-col-content">
                            <h2 class = "sm-title">summer sale </h2>
                            <h2 class = "md-title">Extra 50% Off </h2>
                            <p class = "text-light">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae consequatur facilis eligendi quibusdam voluptatibus exercitationem autem voluptatum, beatae architecto odit, quisquam repellat. Deleniti, architecto ab.</p>
                            <button type = "button" class = "btn-dark">Shop now</button>
                        </div>
                    </div>
                    <!-- right -->
                    <div class = "flex">
                        <div class = "product-col-content">
                            <h2 class = "sm-title">shoes </h2>
                            <h2 class = "md-title">best sellers </h2>
                            <p class = "text-light">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae consequatur facilis eligendi quibusdam voluptatibus exercitationem autem voluptatum, beatae architecto odit, quisquam repellat. Deleniti, architecto ab.</p>
                            <button type = "button" class = "btn-dark">Shop now</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
