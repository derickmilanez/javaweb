package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.FuncionarioDAO;

/**
 *
 * @author Gerson
 */
public class Controle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Verique de onde vem a requisição
            FuncionarioDAO funcDAO = new FuncionarioDAO();
            Funcionario f = new Funcionario();
            RequestDispatcher disp;
            //Conexão com BD
            String conectado = funcDAO.conectar();
            if (!conectado.equals("Conectado")) {
                enviarErro(request, response, conectado);
            }
            String sinal = request.getParameter("sinal");
            if (sinal.equals("listar")) {
                ArrayList<Funcionario> lista = funcDAO.listar();
                //Enviar a lista
                request.setAttribute("sinal", "listar");
                request.setAttribute("lista", lista);
                disp = request.getRequestDispatcher("mensagem.jsp");
                disp.forward(request, response);
            } else if (sinal.equals("cadastrar")) {
                //Receber os parâmetros
                String nome = request.getParameter("nome");
                String cargo = request.getParameter("cargo");
                float salario = Float.parseFloat(request.getParameter("salario"));
                //Atribuir os valores recebidos para a classe Funcionario
                f.setNome(nome);
                f.setCargo(cargo);
                f.setSalario(salario);
                try {
                    //Inserir os dados do funcionário na base de dados
                    int r = funcDAO.inserir(f);
                    //Enviar para um arquivo JSP
                    request.setAttribute("sinal", "resposta");
                    request.setAttribute("resposta", "Inserido com sucesso!!");
                    disp = request.getRequestDispatcher("mensagem.jsp");
                    disp.forward(request, response);
                } catch (IllegalArgumentException e) {
                    enviarErro(request,response,e.getMessage());
                }
            }else if(sinal.equals("atualizar")){
                //Recebe os parâmetros
                int id=Integer.parseInt(request.getParameter("id"));
                float salario=Float.parseFloat(request.getParameter("salario"));
                //Enviar para classe Funcionario - Validação
                f.setId(id);
                f.setSalario(salario);
                //Realizar a atualização do registro no BD
                String mensagem=funcDAO.atualizar(f.getId(), f.getSalario());
                if(mensagem.equals("Atualizado com sucesso")){
                    request.setAttribute("sinal", "resposta");
                    request.setAttribute("resposta", mensagem);
                    disp = request.getRequestDispatcher("mensagem.jsp");
                    disp.forward(request, response);
                }else{
                    enviarErro(request,response,mensagem);
                }
            }

            //Fechar a conexão
            String fechar = funcDAO.fechar();
            if (!fechar.equals("fechado")) {
                enviarErro(request, response, fechar);
            }
        }
    }
/**
 * 
 * @param request HttpServletRequest
 * @param response HttpServletRequest
 * @param mensagem String
 * @throws ServletException
 * @throws IOException 
 */
    public static void enviarErro(HttpServletRequest request, 
            HttpServletResponse response, String mensagem)throws ServletException, IOException {
        RequestDispatcher disp;
        request.setAttribute("resposta", mensagem);
        disp = request.getRequestDispatcher("erro.jsp");
        disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Meu servlet";
    }// </editor-fold>

}
