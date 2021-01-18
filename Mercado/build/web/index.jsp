<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Produto"%>
<%@page import="dao.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <form action="index.jsp" method="post">
            <label>Nome do Produto</label><br>
            <input type="text" name="nome"><br>
            <input type="submit"><br>
        </form>
        <%
            try{
            out.print("<table>");
            out.print("<tr>");
            out.print("<th>Codigo</th><th>Nome</th><th>Preço</th>");
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if(request.getParameter("nome") == "" || request.getParameter("nome") == null){
                ArrayList<Produto> lista = produtoDAO.select();
                for(int index=0; index<lista.size();index++){
                    out.print("<tr>");
                    out.print("<td>"+lista.get(index).getCodigo_produto()+"</td>");
                    out.print("<td>"+lista.get(index).getNome_produto()+"</td>");
                    out.print("<td>"+lista.get(index).getPreco_produto()+"</td>");
                    out.print("<td><a href='alter.jsp?codigo="+lista.get(index).getCodigo_produto()+"&nome="+lista.get(index).getNome_produto()+"&preco="+lista.get(index).getPreco_produto()+"'>Alterar</a></td>");
                    out.print("<td><a href='remove.jsp?codigo="+lista.get(index).getCodigo_produto()+"&nome="+lista.get(index).getNome_produto()+"'>Deletar</a></td>");
                    out.print("</tr>");
                }
            }else{
                ArrayList<Produto> lista = produtoDAO.selectCustom(request.getParameter("nome"));
                for(int index=0; index<lista.size();index++){
                    out.print("<tr>");
                    out.print("<td>"+lista.get(index).getCodigo_produto()+"</td>");
                    out.print("<td>"+lista.get(index).getNome_produto()+"</td>");
                    out.print("<td>"+lista.get(index).getPreco_produto()+"</td>");
                    out.print("<td><a href='alter.jsp?codigo="+lista.get(index).getCodigo_produto()+"&nome="+lista.get(index).getNome_produto()+"&preco="+lista.get(index).getPreco_produto()+"'>Alterar</a></td>");
                    out.print("<td><a href='remove.jsp?codigo="+lista.get(index).getCodigo_produto()+"&nome="+lista.get(index).getNome_produto()+"'>Deletar</a></td>");
                    out.print("</tr>");
                }
            }
            out.print("</tr>");
            out.print("</table>");
            }
            catch(Exception erro){
                throw new RuntimeException("Erro 10: " + erro);
            }
        %>
        
        <a href="create.jsp">CRIAR NOVO REGISTRO</a>
    </body>
</html>
