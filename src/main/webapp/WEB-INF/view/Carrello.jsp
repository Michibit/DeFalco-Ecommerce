
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="model.*" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="dao.ProdottoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  DecimalFormat dcf = new DecimalFormat("#.##");
  request.setAttribute("dcf", dcf);
  Cliente c = null;
  if (session.getAttribute("Cliente") != null) {
    c = (Cliente) session.getAttribute("Cliente");
  }

  if(c.getCarrello() != null){
  ArrayList<Carrello> cart_list = c.getCarrello();
  if (cart_list != null) {
    ProdottoDAO pDao = new ProdottoDAO(ConnectionDB.getConnection());
    double total = pDao.getTotalCartPrice(cart_list);
    request.setAttribute("total", total);
    request.setAttribute("cart_list", cart_list);
  }
  else
    cart_list = new ArrayList<>();
%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="./styles/home.css">
  <title>E-Commerce Cart</title>
  <style type="text/css">

    .table tbody td{
      vertical-align: middle;
    }
    .btn-incre, .btn-decre{
      box-shadow: none;
      font-size: 25px;
    }
  </style>
</head>
<body>
<%@include file="./navbar.jsp"%>

<div class="container my-3">
  <div class="d-flex py-3"><h3>Prezzo Totale: € ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
  <table class="table table-light">
    <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Category</th>
      <th scope="col">Price</th>
      <th scope="col">Buy Now</th>
      <th scope="col">Cancel</th>
    </tr>
    </thead>
    <tbody>
    <%
      if (cart_list.size() > 0) {
        for (Carrello p : cart_list) {
          for (model.Prodotti pr : p.getP()) {
            Prodotto product = pr.getP();
    %>
    <tr>
      <td><%=product.getNome()%></td>
      <td><%=product.getCategoria()%></td>
      <td><%=dcf.format(product.getPrezzo())%>€</td>
      <td>
        <form action="order-now" method="post" class="form-inline">
          <input type="hidden" name="id" value="<%=product.getID()%>" class="form-input">
          <div class="form-group d-flex justify-content-between">
            <a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=product.getID()%>"><i class="fas fa-plus-square"></i></a>
            <input type="text" name="quantity" class="form-control"  value="<%=pr.getQuantita()%>" readonly>
            <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=product.getID()%>"><i class="fas fa-minus-square"></i></a>
          </div>
          <button type="submit" class="btn btn-primary btn-sm">Buy</button>
        </form>
      </td>
      <td><a href="remove-from-cart?id=<%=product.getID()%>" class="btn btn-sm btn-danger">Remove</a></td>
    </tr>

    <%
          }
        }
      }
      }%>
    </tbody>
  </table>
</div>

<%@include file="footer.jsp"%>
</body>
</html>