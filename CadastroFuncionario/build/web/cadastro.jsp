<%@page errorPage="tratarErro.jsp"%>
<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <%
            String nome = request.getParameter("nome");
            String cargo = request.getParameter("cargo");
            float salario = Float.parseFloat(request.getParameter("salario"));
            
            Funcionario func = new Funcionario();
            func.setNome(nome);
            func.setCargo(cargo);
            func.setSalario(salario);
            
            out.print("<h2><center>Cadastrado com sucesso</center></h2>");
        %>
    </body>
</html>
