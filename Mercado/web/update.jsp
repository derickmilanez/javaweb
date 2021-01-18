<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Produto"%>
<%@page import="dao.ProdutoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <%
            try{
                Produto produto = new Produto();
                ProdutoDAO produtoDAO = new ProdutoDAO();
                if(request.getParameter("nome").equals("") || request.getParameter("preco").equals("")){
                    response.sendRedirect("index.jsp");
                }else{
                    produto.setNome_produto(request.getParameter("nome"));
                    produto.setPreco_produto(Double.parseDouble(request.getParameter("preco")));
                    produto.setCodigo_produto(Integer.parseInt(request.getParameter("codigo")));
                    produtoDAO.update(produto);
                    response.sendRedirect("index.jsp");
                }
            }catch(Exception erro){
                throw new RuntimeException("Erro 8: " + erro);
            }
        %>
    </body>
</html>