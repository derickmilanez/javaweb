package modelo;

public class Funcionario {

    private int id;
    private String nome, cargo;
    private float salario;

    //Sobrecarga de construtores
    public Funcionario(){}
    
    public Funcionario(String nome,String cargo){
      this.nome=nome;
      this.cargo=cargo;
    }
    
    public Funcionario(String nome,String cargo,float salario){
      this.nome=nome;
      this.cargo=cargo;
      this.salario=salario;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario >= 1000 && salario <= 100000) {
            this.salario = salario;
        }else{
            throw new IllegalArgumentException("Salário inválido!!");  
        }
    }
}
