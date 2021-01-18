<%-- 
    Document   : imc
    Created on : 13/04/2020, 09:48:55
    Author     : DERICK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <%
        String nome = request.getParameter("nome");
        float altura = Float.parseFloat(request.getParameter("altura"));
        float peso = Float.parseFloat(request.getParameter("peso"));
        float imc  =  peso/(altura * altura);
        if(imc<=18.5){
            out.print("Olá " + nome + ", seu IMC é: " + imc + ". Você está abaixo do peso!");
        }
        else if(imc>=18.6  && imc<=24.9){
            out.print("Olá " + nome + ", seu IMC é: " + imc + ". Você está no peso ideal!");
        }
        else if(imc>=25  && imc<=29.9){
            out.print("Olá " + nome + ", seu IMC é: " + imc + ". Você está levemente acima do peso!");
        }
        else if(imc>=30  && imc<=34.9){
            out.print("Olá " + nome + ", seu IMC é: " + imc + ". Você está acima do peso!");
        }
        else if(imc>=35  && imc<=39.9){
            out.print("Olá " + nome + ", seu IMC é: " + imc + ". Você está obeso!");
        }
        else{
            out.print("Olá " + nome + ", seu IMC é: " + imc + ". Você está extremamente obeso!");
        }
        %>
    </body>
</html>
