import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306";
        final String usuario = "root";
        final String senha = "f3rr31r4";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);



        conexao.close();
    }


}
