package bandoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarBanco {

    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3306/br";
        final String usuario = "root";
        final String senha = "f3rr31r4";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão ao banco de dados realizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar no Banco de Dados...");
            System.out.println("tipo de erro: " + e.getMessage());
        }
    }
}
