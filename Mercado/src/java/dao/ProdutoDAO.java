package dao;

import modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
     
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Produto> lista = new ArrayList<>();
    
    public ProdutoDAO(){
        conn = new Conexao().getConexao();
    }
    
    public void insert(Produto produto){
        String sql = "INSERT INTO produto (nome_produto, preco_produto) VALUES (?,?)";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome_produto());
            ps.setDouble(2, produto.getPreco_produto());
            ps.execute();
            ps.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 2: " + erro);
        }
    }
    
    public ArrayList<Produto> select(){
        String sql = "SELECT *  FROM produto";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo_produto(rs.getInt("codigo_produto"));
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setPreco_produto(rs.getInt("preco_produto"));
                lista.add(produto);
            }
        }catch(Exception erro){
            throw new RuntimeException("Erro 3: " + erro);
        }
        return lista;
    }
    
    public void update(Produto produto){
        String sql = "UPDATE produto SET nome_produto=?, preco_produto=? WHERE codigo_produto=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome_produto());
            ps.setDouble(2, produto.getPreco_produto());
            ps.setInt(3, produto.getCodigo_produto());
            ps.execute();
            ps.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 4: " + erro);
        }
    }
    
    public void delete(int valor){
        String sql = "DELETE FROM produto WHERE codigo_produto = " + valor;
        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro 5: " + erro);
        }
    }
    
    public ArrayList<Produto> selectCustom(String valor){
        String sql = "SELECT *  FROM produto WHERE nome_produto LIKE '%"+valor+"%' ";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo_produto(rs.getInt("codigo_produto"));
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setPreco_produto(rs.getInt("preco_produto"));
                lista.add(produto);
            }
        }catch(Exception erro){
            throw new RuntimeException("Erro 6: " + erro);
        }
        return lista;
    }
}
