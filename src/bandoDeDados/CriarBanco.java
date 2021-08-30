package bandoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306";
        final String usuario = "root";
        final String senha = "f3rr31r4";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        System.out.println("Conexão ao banco de dados realizada com sucesso!");

        Statement stmt = conexao.createStatement();

        stmt.execute("create database if not exists curso_java");
        System.out.println("Banco criado com sucesso!");


        conexao.close();
    }

}
