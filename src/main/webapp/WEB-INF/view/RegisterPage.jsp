<%--
  Created by IntelliJ IDEA.
  User: michelemenzione
  Date: 14/06/22
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="icon" href="./icons/icons8-falco-32.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/register.css">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
    <title>DeFalco | Registrazione</title>
</head>
<body>
<script src="${pageContext.request.contextPath}/script/checkRegister.js"></script>
<div class="main">
    <div class="signup">
        <form id="registrazione" action="registerServlet" method="post"  onsubmit="return validation()">
        <label>Registrazione</label>

        <p id="username-error" class="input-not"></p>
        <input id="username" type="text" name="username" placeholder="Username" required="">

        <input id="email" type="email" name="email" placeholder="Email" required="">
        <p id="email-error" class="input-not"></p>
        <input id="pass" type="password" name="password" placeholder="Password" required="">
        <p id="pass-error" class="input-not"></p>
        <input id="confpass" type="password" name="confPass" placeholder="Conferma Password" required="">
        <p id="confpass-error" class="input-not"></p>

        <button>Registrati</button>
    </form>
    <p class="loginPage">Sei già Registrato? <a href="EntryServlet?get=login">Login</a> </p>
    </div>
</div>

</body>
</html>
