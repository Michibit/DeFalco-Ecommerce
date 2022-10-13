<%@ page import="model.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 10/07/22
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Cliente cl = (Cliente) session.getAttribute("Cliente");%>
<div class="sidenav">
    <div class="profile">
        <img src="${pageContext.request.contextPath}/icons/Tribal-Eagle-2.svg" alt="" width="100" height="100">

        <div class="name">
            Ciao <%=cl.getUsername()%>
        </div>
    </div>

    <div class="sidenav-url">
        <div class="url">
            <a href="EntryServlet?get=profile">Profilo</a>
        </div>
        <div class="url">
            <a href="EntryServlet?get=order">Ordini</a>
        </div>
    </div>
</div>
