package okeha.pesquiz.conexaoBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Creates extends ConexaoBD {
    
    public Creates() throws Exception {
        super();
    }
    
    public void novo_pesquisador(String email, String senha, String nome) throws SQLException{
        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery("SELECT email FROM login_pesquisadores WHERE email = '" + email + "';");
        while (rs.next()) {
            JOptionPane.showMessageDialog(null,"Usuário já cadastrado!","Cadastro inválido",1);
            return;
        }
        String sql = "INSERT INTO " + getTabelaLoginPesquisadores() + " VALUES (?, ?, ?)";
        PreparedStatement statement2 = conexao.prepareStatement(sql);
        statement2.setString(1, email);
        statement2.setString(2, senha);
        statement2.setString(3, nome);
        int rowsInserted = statement2.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null,"Novo usuário pesquisador cadastrado!","Cadastro Valido",1);
        }
    }
    
    public void novo_voluntario(String numero_chatbot, String senha) throws SQLException{
        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery("SELECT email FROM login_voluntarios WHERE n_chatbot = '" + numero_chatbot + "';");
        while (rs.next()) {
            JOptionPane.showMessageDialog(null,"Usuário já cadastrado!","Cadastro inválido",1);
            return;
        }
        String sql = "INSERT INTO " + getTabelaLoginVoluntarios() + " VALUES (?, ?)";
        PreparedStatement statement2 = conexao.prepareStatement(sql);
        statement2.setString(1, numero_chatbot);
        statement2.setString(2, senha);
        int rowsInserted = statement2.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null,"Novo usuário voluntário cadastrado!","Cadastro Valido",1);
        }
    }
    
    public int nova_pesquisa(int id_pesquisador, String titulo) throws SQLException{
        String sql = "INSERT INTO " + getTabelaInfoPesquisas() + " VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, 0); //n_respostas_obtidas
        statement.setDate(2, null); //data_criacao
        statement.setString(3, titulo); //titulo
        statement.setInt(3, id_pesquisador); //id_pesquisador
        int rowsInserted = statement.executeUpdate();
        int id_pesquisa = 0;
        if (rowsInserted > 0) {
            System.out.println("Agora preencha o questionário!");
        }
        try {
            Statement statement2 = conexao.createStatement();
            ResultSet rs = statement2.executeQuery("SELECT id_pesquisa FROM login_pesquisadores WHERE titulo = '" + titulo + "';");
            while (rs.next()) {
                id_pesquisa = rs.getInt(1);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return id_pesquisa;
    }

    public void novo_questionario(int id_pesquisa, String Q1, String Q2, String Q3, String Q4, String Q5) throws SQLException{
        String sql = "INSERT INTO " + getTabelaQuestionarios() + " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, Q1);
        statement.setString(2, Q2);
        statement.setString(3, Q3);
        statement.setString(4, Q4);
        statement.setString(5, Q5);
        statement.setInt(11, id_pesquisa);
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Nova pesquisa criada!");
        }
    }
        
}