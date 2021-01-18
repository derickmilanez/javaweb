<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alter</title>
    </head>
    <body>
        <form method="post" action="update.jsp">
            <label>Código do Produto: </label><br>
            <input type="text" name="codigo" value="<%=request.getParameter("codigo")%>" disabled><br>
            <label>Nome do Produto: </label><br>
            <input type="text" name="nome" value="<%=request.getParameter("nome")%>"><br>
            <label>Preço do Produto: </label><br>
            <input type="number" name="preco" step="any" value="<%=request.getParameter("preco")%>"><br>
            <input type="submit" value="Alterar">
        </form>
    </body>
</html>
