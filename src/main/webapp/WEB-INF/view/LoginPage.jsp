<%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 14/06/22
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <link rel="icon" href="./icons/icons8-falco-32.png">
    <title>DeFalco | Login </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/login.css">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>

<body>
<div class="main">
    <div class="login">

        <form action="loginServlet" method="post">
            <label class="entra">Entra</label>
            <%if(request.getAttribute("msg") != null){
                String error = (String) request.getAttribute("msg");
            %>
            <p class="error"><%= error%></p>
            <% }%>
            <input type="text" name="username" placeholder="Username" required="">
            <input type="password" name="password" placeholder="Password" required="">
            <button>Entra</button>
        </form>
        <p class="registrati">Non sei registrato? <a href="EntryServlet?get=reg">Registrati</a> </p>
    </div>

</div>
<video autoplay="true" loop muted class="donna" src="${pageContext.request.contextPath}/vid/kk.mp4" alt="ms">
</body>
</html>

