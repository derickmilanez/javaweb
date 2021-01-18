package modelo;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Realizar o CRUD com banco de dados.
 *
 * @author Gerson
 */
public class FuncionarioDAO {

    private final String URL = "jdbc:mysql://localhost:3306/empresa_vm";
    private final String USUARIO = "root";
    private final String SENHA = "";
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    /**
     * Realiza a conexão da aplicação Java com a base de dados.
     * @return String
     */
    public String conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
            return "Conectado";
        } catch (SQLException e) {
            return "Falha ao conectar\n" + e.getMessage();
        } catch (ClassNotFoundException ex) {
            return "Falha ao encontrar a classe\n" + ex.getMessage();
        }
    }

    public String fechar() {
        try {
            con.close();
        } catch (SQLException e) {
            return "Falha ao encerrar\n" + e.getMessage();
        }
        return "fechado";
    }

    public ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            Funcionario f;
            while (rs.next()) {
                f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getFloat("salario"));
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Falha ao consultar\n" + e.getMessage());
        }
        return lista;
    }

    
    public int inserir(Funcionario f) {
        String sql = "INSERT INTO funcionario(nome,cargo,salario) VALUES(?,?,?)";
        try {
            st = con.prepareStatement(sql);
            st.setString(1, f.getNome());
            st.setString(2, f.getCargo());
            st.setFloat(3, f.getSalario());
            st.execute();
        } catch (SQLException e) {
           throw new IllegalArgumentException("Falha ao inserir!!</br>"+e);
        }
       return 1; 
    }

    /**
     * Atualiza o salário do funcionário pelo id.
     *
     * @param id int
     * @param salario float
     * @return String
     */
    public String atualizar(int id, float salario) {
        String sql = "UPDATE funcionario SET salario=" + salario + " WHERE id=" + id;
        try {
            st = con.prepareStatement(sql);
            st.execute();
            return "Atualizado com sucesso";
        } catch (SQLException e) {
            return "Falha ao atualizar!</br>" + e.getMessage();
        }
    }

    /**
     * Remover o registro pelo valor do id.
     *
     * @param id int
     */
    public void remover(int id) {
        String sql = "DELETE FROM funcionario WHERE id=" + id;
        try {
            st = con.prepareStatement(sql);
            st.execute();
            System.out.println("Removido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao deletar\n" + e.getMessage());
        }
    }

    /**
     * Realiza a consulta de funcionários pelo id.
     *
     * @param id int
     * @return Funcionario
     */
    public Funcionario consultar(int id) {
        Funcionario f = null;
        String sql = "SELECT * FROM funcionario WHERE id=" + id;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getFloat("salario"));
            }
        } catch (SQLException e) {
            System.out.println("Falha ao consultar\n" + e.getMessage());
        }
        return f;
    }

}
