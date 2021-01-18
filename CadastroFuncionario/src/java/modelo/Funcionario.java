package modelo;

public class Funcionario {
    private String nome, cargo;
    private float salario;
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void setCargo(String cargo){
        this.cargo=cargo;
    }
    
    public void setSalario(float salario){
        if(salario >= 1000 && salario <= 5000){
            this.salario=salario;
        }
        else{
            throw new IllegalArgumentException("Salario inválido. Informe um salario na faixa de 1000 a 5000.");
        }
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public float getSalario(){
        return salario;
    }
}
