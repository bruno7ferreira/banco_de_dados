package praticandoNovamente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class CriarBanco {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306";
        final String usuario = "root";
        final String senha = "f3rr31r4";

        Connection conexao1 = DriverManager.getConnection(url, usuario, senha);

        Statement stmt = conexao1.createStatement();
        stmt.execute("create database if not exists curso_java14");

        System.out.println("Banco criado com sucesso!");
        conexao1.close();


    }


}
