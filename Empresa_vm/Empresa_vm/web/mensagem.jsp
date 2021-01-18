<%-- 
    Document   : mensagem
    Created on : 08/06/2020, 09:43:00
    Author     : Gerson
--%>

<%@page import="modelo.Funcionario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagem de sucesso!</title>
    </head>
    <body>
        <%
          String sinal=(String) request.getAttribute("sinal");
          if(sinal.equals("listar")){
              out.print("<table border=solid>");
              //Cabeçalho da tabela
              out.print("<tr>");
              out.print("<th>ID</th>");
              out.print("<th>Nome</th>");
              out.print("<th>Cargo</th>");
              out.print("<th>Salário</th>");
              out.print("</tr>");
              //Exibir os dados na tabela
              ArrayList<Funcionario> lista=(ArrayList)request.getAttribute("lista");
              for(Funcionario f:lista){
                out.print("<tr>");
                out.print("<td>"+f.getId()+"</td>");
                out.print("<td>"+f.getNome()+"</td>");
                out.print("<td>"+f.getCargo()+"</td>");
                out.print("<td>"+f.getSalario()+"</td>");
                out.print("</tr>");
              }
              out.print("</table>");
          }else if(sinal.equals("resposta")){
            String resposta=(String)request.getAttribute("resposta");
            out.print(resposta);
          }
        %>
    </body>
</html>
