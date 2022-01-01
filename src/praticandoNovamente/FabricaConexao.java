package praticandoNovamente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

    public static Connection getConexao() {

        try {
            Properties prop = getProperties();
            final String url = "jdbc:mysql://localhost:3306/curso_java14";
            final String usuario = "root";
            final String senha = "f3rr31r4";

            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);

        }


    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String caminho = "/conexao.properties";
        prop.load(FabricaConexao.class.getResourceAsStream(caminho));
        return prop;
    }


}
