<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProdutoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>
        <%
            try{
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if(request.getParameter("codigo").equals("")){
                response.sendRedirect("index.jsp");
            }else{
                produtoDAO.delete(Integer.parseInt(request.getParameter("codigo")));
                response.sendRedirect("index.jsp");
            }
            }catch(Exception erro){
                throw new RuntimeException("Erro 8: " + erro);
            }
        %>
    </body>
</html>
