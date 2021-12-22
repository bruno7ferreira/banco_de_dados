package praticandoNovamente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CriarBanco {

    public static void main(String[] args) throws SQLException {


        Connection conexao = FabricaConexao.getConexao();

        Statement stmt = conexao.createStatement();
        stmt.execute("create database if not exists curso_java14");

        System.out.println("Banco criado com sucesso!");
        conexao.close();


    }


}
