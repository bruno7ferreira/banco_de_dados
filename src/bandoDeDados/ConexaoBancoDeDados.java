package bandoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306/wm"; //Criando conexão com banco de dados
        final String usuario = "root"; // criando senha do banco de dados
        final String senha = "f3rr31r4"; // criando usuário do banco de dados

        Connection conexao = DriverManager.getConnection(url, usuario, senha); //conectando no banco de dados
        System.out.println("Conexão realizada com sucesso!");


        conexao.close(); //fechando o conexao com banco de dados
    }

}
