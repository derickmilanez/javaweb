<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove</title>
    </head>
    <body>
        <form method="post" action="delete.jsp">
            <label>Código do Produto: </label><br>
            <input type="text" name="codigo" value="<%=request.getParameter("codigo")%>"><br>
            <label>Nome do Produto: </label><br>
            <input type="text" name="nome" value="<%=request.getParameter("nome")%>"><br>
            <input type="submit" value="Deletar">
        </form>
    </body>
</html>
