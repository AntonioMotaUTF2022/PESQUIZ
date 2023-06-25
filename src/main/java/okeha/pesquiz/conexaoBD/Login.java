package okeha.pesquiz.conexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import okeha.pesquiz.areaLogada.Pesquisador;
import okeha.pesquiz.areaLogada.Voluntario;

public class Login extends ConexaoBD {
    
    public Login() throws Exception {
        super();
    }
    
    public Pesquisador login_pesquisador(String email, String senha) throws SQLException{
        int verificador = 0;
        while (verificador == 0) {
            try {
                Statement statement = conexao.createStatement();
                ResultSet rs = statement.executeQuery("SELECT senha FROM login_pesquisadores WHERE email = '" + email + "';");
                if(!rs.next()) JOptionPane.showMessageDialog(null,"Usuário não cadastrado.","Erro.",1);
                while (rs.next()) {
                    String senhaBD = rs.getString(1);
                    if(senhaBD.equals(senha)) {
                        JOptionPane.showMessageDialog(null,"Bem vindo(a)!","Login realizado com sucesso.",1);
                        verificador = 1;
                        break;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Senha incorreta.","Erro.",1);
                    }
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }

        Pesquisador pesquisadorLogado = new Pesquisador();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM login_pesquisadores WHERE email = '" + email + "';");
            while (rs.next()) {
                pesquisadorLogado.setEmail(rs.getString(1));
                pesquisadorLogado.setNome(rs.getString(3));
                pesquisadorLogado.setIdpesquisador(rs.getInt(4));
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return pesquisadorLogado;
    }
    
    public Voluntario login_voluntario(String n_chatbot, String senha) throws SQLException{
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT senha FROM login_voluntarios WHERE n_chatbot = '" + n_chatbot + "';");
            if(!rs.next()) JOptionPane.showMessageDialog(null,"Usuário não cadastrado.","Erro.",1);
            while (rs.next()) {
                String senhaBD = rs.getString(1);
                if(senhaBD.equals(senha)) {
                    JOptionPane.showMessageDialog(null,"Bem vindo(a)!","Login realizado com sucesso.",1);
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null,"Senha incorreta.","Erro.",1);
                }
            }
        }
        catch (SQLException se) {}

        Voluntario voluntarioLogado = new Voluntario();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM login_voluntarios WHERE n_chatbot = '" + n_chatbot + "';");
            while (rs.next()) {
                voluntarioLogado.setNchatbot(rs.getString(1));
                voluntarioLogado.setIdvoluntario(rs.getInt(3));
            }
        }
        catch (SQLException se) {}
        return voluntarioLogado;
    }

}
