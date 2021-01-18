<%-- 
    Document   : erro
    Created on : 08/06/2020, 09:58:30
    Author     : Gerson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagem de Erro</title>
    </head>
    <body>
        <div id="erro">
            <%
                Object resposta = request.getAttribute("resposta");
                out.print(resposta);
            %>
        </div>
    </body>
</html>
