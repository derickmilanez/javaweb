<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <form method="post" action="insert.jsp">
            <label>Nome do Produto: </label><br>
            <input type="text" name="nome"><br>
            <label>Preço do Produto: </label><br>
            <input type="number" name="preco" step=".01"><br>
            <input type="submit" value="Inserir">
        </form>
    </body>
</html>
