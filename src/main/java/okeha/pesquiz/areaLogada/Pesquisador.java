package okeha.pesquiz.areaLogada;

public class Pesquisador{
    private String email = new String();
    private String nome = new String();
    private int id_pesquisador = 0;
    
    public void setNome(String nome) {this.nome = nome;}
    public String getNome() {return nome;}
    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}
    public void setIdpesquisador(int id_pesquisador) {this.id_pesquisador = id_pesquisador;}
    public int getIdpesquisador() {return id_pesquisador;}
}
