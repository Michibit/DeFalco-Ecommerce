//Script file
function validation() {
    var userid = document.getElementById('username').value;
    //var lname = document.getElementById('lname').value;
    var email = document.getElementById('email').value;
    var psw = document.getElementById('pass').value;
    var psw_repeat = document.getElementById('confpass').value;


    /*
    Deve Iniziare con un carattere alfabetico.
    Puo contenere i seguenti caratteri: a-z A-Z 0-9 -  _
     */
    var usercheck = /[a-zA-Z][a-zA-Z0-9-_]{3,32}/;

    var emailcheck = /^(?:(?:[\w`~!#$%^&*\-=+;:{}'|,?\/]+(?:(?:\.(?:"(?:\\?[\w`~!#$%^&*\-=+;:{}'|,?\/\.()<>\[\] @]|\\"|\\\\)*"|[\w`~!#$%^&*\-=+;:{}'|,?\/]+))*\.[\w`~!#$%^&*\-=+;:{}'|,?\/]+)?)|(?:"(?:\\?[\w`~!#$%^&*\-=+;:{}'|,?\/\.()<>\[\] @]|\\"|\\\\)+"))@(?:[a-zA-Z\d\-]+(?:\.[a-zA-Z\d\-]+)*|\[\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\])$/;


    /*
    - Almeno 8 caratteri
    - DEVE contenere 1 lettera MAIUSCOLA, 1 lettera minuscola, e 1 numero
    - Può contenere caratteri speciali

     */
    var pswcheck = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;


    if (usercheck.test(userid)) {
        document.getElementById('username-error').innerHTML = "";
        document.getElementById('username').classList.add("corretto");
        document.getElementById('username').classList.remove("errato");
    } else {
        document.getElementById('username-error').innerHTML = "Username invalido";
        document.getElementById('username').classList.add("errato")
        document.getElementById('username').classList.remove("corretto");
        return false;
    }
    if (emailcheck.test(email)) {
        document.getElementById('email-error').innerHTML = "";
        document.getElementById('email').classList.remove("errato");
        document.getElementById('email').classList.add("corretto")
    } else {
        document.getElementById('email-error').innerHTML = "Email non valida";
        document.getElementById('email').classList.add("errato");
        document.getElementById('email').classList.remove("corretto");
        return false;
    }
    if (pswcheck.test(psw)) {
        document.getElementById('pass-error').innerHTML = "";
        document.getElementById('pass').classList.remove("errato");
        document.getElementById('pass').classList.add("corretto")
    } else {
        document.getElementById('pass-error').innerHTML = "Password non corretta"
        document.getElementById('pass').classList.add("errato")
        document.getElementById('pass').classList.remove("corretto");
        return false;
    }
    if (psw.match(psw_repeat)) {
        document.getElementById('confpass-error').innerHTML = "";
        document.getElementById('confpass').classList.add("corretto")
        document.getElementById('confpass').classList.remove("errato");
    } else {
        document.getElementById('confpass-error').innerHTML = "Le password non coincidono!";
        document.getElementById('confpass').classList.add("errato")
        document.getElementById('confpass').classList.remove("corretto");
        return false;
    }
}