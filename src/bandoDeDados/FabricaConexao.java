package bandoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public static Connection getConexao() {

        try {
            final String url = "jdbc:mysql://localhost:3306/curso_java";
            final String usuario = "root";
            final String senha = "f3rr31r4";

            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
