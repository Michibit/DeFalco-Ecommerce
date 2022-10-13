<%@ page import="java.sql.Connection" %>
<%@ page import="dao.OrdineDAO" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="model.Ordine" %>
<%@ page import="dao.FatturazioneDAO" %>
<%@ page import="model.Fatturazione" %><%--
  Created by IntelliJ IDEA.
<%@ page import="model.Fatturazione" %>
<%@ page import="dao.FatturazioneDAO" %>
<%@ page import="dao.ConnectionDB" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.OrdineDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ordine" %>
<%@ page import="model.Prodotti" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 10/07/22
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/icons/icons8-falco-32.png">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>De Falco | Profilo</title>

    <!-- Custom Css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/profilePage.css">

    <!-- FontAwesome 5 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">

    <%
        Cliente c = (Cliente) session.getAttribute("Cliente");
        Connection con = ConnectionDB.getConnection();
        OrdineDAO ordineDAO = new OrdineDAO(con);
        FatturazioneDAO dao = new FatturazioneDAO(con);
        Fatturazione f = dao.getFatturazionebyUserID(Integer.parseInt(c.getID()));
        if(f.getNome() == null ||  f.getNome().equalsIgnoreCase("null")){
            f.setNome(" ");
        }

    %>
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<!-- Navbar -->
<%@include file="Navbar.jsp" %>
<!-- End -->


<!-- Sidenav -->
<%@include file="SideNavUser.jsp" %>
<!-- End -->

<!-- Main -->
<div class="main">
    <h2>Fatturazione</h2>
    <div class="card">
        <div class="card-body">
            <a href="ProfilePageServlet?act=mod"><i class='bx bx-edit-alt'></i></a>
            <form action="ProfilePageServlet" method="get">
                <input type="hidden" name="act" value="modSave">
                <table>
                    <tr>
                        <td>Nome</td>
                        <td>:</td>
                        <td><input type="text" name="nome" value="<%=f.getNome()%>"></td>
                    </tr>
                    <tr>
                        <td>Cognome</td>
                        <td>:</td>
                        <td><input type="text" name="cognome" value="<%=f.getCognome()%>"></td>
                    </tr>
                    <tr>
                        <td>Indirizzo</td>
                        <td>:</td>
                        <td><input type="text" name="indirizzo" value="<%=f.getIndirizzo()%>">,
                            <label>CAP
                                <input type="text" name="cap" value="<%=f.getCap()%>">
                            </label> ,
                            <label>Citta
                                <input type="text" name="citta" value="<%=f.getCitta()%>">
                            </label></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td><input type="submit" name="nome" value="Salva"></td>
                    </tr>

                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>
