<%@page import="java.util.*" %>
<%@page import="java.text.DecimalFormat" %>
<%@ page import="model.*" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="dao.ProdottoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    ArrayList<Carrello> cart_list;
    ProdottoDAO pDao = new ProdottoDAO(ConnectionDB.getConnection());
    //Se il cliente è loggato
    if (session.getAttribute("Cliente") != null) {
        Cliente c = (Cliente) session.getAttribute("Cliente");
        cart_list = c.getCarrello();
    }
    //Non sono loggato
    else {
        cart_list = (ArrayList<Carrello>) session.getAttribute("cart-list");
    }

%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <title>E-Commerce Cart</title>
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<%@include file="Navbar.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/cartt.css">


<div class="top-sales box">
    <div class="title">Carrello</div>
    <table class="sales-details">
        <%
            if (cart_list.size() > 0) {
                for (Carrello p : cart_list) {
                    for (model.Prodotti pr : p.getP()) {
                        Prodotto product = pr.getP();
        %>

        <tr>
            <td><img class="imgThumb" src="<%=product.getImg()%>"></td>
            <td><%=product.getNome()%>
            </td>
            <td><%=product.getPrezzo()%>€</td>

            <td><a class="btn btn-sm btn-decre" href="CartActionServlet?action=dec&id=<%=product.getID()%>">
                <i class='bx bxs-chevron-up bx-rotate-180'></i></a>
                <span class="price"><%=pr.getQuantita()%> </span>
                <a class="btn bnt-sm btn-incre" href="CartActionServlet?action=inc&id=<%=product.getID()%>">
                    <i class='bx bxs-chevron-up bx-flip-horizontal'></i></a>
            </td>
            <td><a class="btn bnt-sm btn-incre" href="CartActionServlet?action=rem&id=<%=product.getID()%>">
                <i class='bx bx-trash'></i></a></td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <%

        }
    %>
    <div class="result-highlight">
        <div class="total-order"><h3>Prezzo Totale: <%=pDao.getTotalCartPrice(cart_list)%> € </h3>
            <a class="check-out" href="CheckOutServlet">
                <button> Check Out.
                </button>
            </a>
        </div>
    </div>
</div>


</body>
</html>