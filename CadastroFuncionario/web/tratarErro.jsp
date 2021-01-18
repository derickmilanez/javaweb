<%@page isErrorPage="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Erro</title>
    </head>
    <body>
        <%
            out.print("<h1><center>" + exception.getMessage() + "</h1></center>");
        %>
    </body>
</html>
