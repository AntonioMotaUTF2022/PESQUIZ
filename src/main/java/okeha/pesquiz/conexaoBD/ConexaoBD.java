package okeha.pesquiz.conexaoBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConexaoBD {
       
    private static final String url = "jdbc:postgresql://localhost:5432/Pesquiz";
    private static final String usuario = "Pesquiz";
    private static final String senha = "pq_2023";
    private static final String tabelaLoginVoluntarios = "login_voluntarios(n_chatbot, senha)";
    private static final String tabelaLoginPesquisadores = "login_pesquisadores(email, senha, nome)";
    private static final String tabelaInfoVoluntarios = "info_voluntarios(id_voluntario, declaracao_racial, idade, genero, pcd, curso, semestre, ano_ingresso)";
    private static final String tabelaInfoPesquisas = "info_pesquisas(n_respostas_obtidas, data_criacao, titulo, id_pesquisador)";
    private static final String tabelaQuestionarios = "questionarios(q1, q2, q3, q4, q5, id_pesquisa)" ;

    public static final  String getTabelaLoginVoluntarios() {return tabelaLoginVoluntarios;}
    public static final  String getTabelaLoginPesquisadores() {return tabelaLoginPesquisadores;}
    public static final  String getTabelaInfoVoluntarios() {return tabelaInfoVoluntarios;}
    public static final  String getTabelaInfoPesquisas() {return tabelaInfoPesquisas;}
    public static final  String getTabelaQuestionarios() {return tabelaQuestionarios;}
    
    public static Connection conexao;
    
    public ConexaoBD() throws SQLException {
        conexao = DriverManager.getConnection(url, usuario, senha);
    }
    
}
