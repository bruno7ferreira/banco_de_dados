package bandoDeDados;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

    public static Connection getConexao() {

        try {
            Properties prop = getProperties();
            final String url = prop.getProperty("banco.url");
            final String usuario = prop.getProperty("banco.usuario");
            final String senha = prop.getProperty("banco.senha");

//            CONEXAO COM BANCO DE DADOS, CONFIGURANDO DENTRO DO CODIGO JAVA
//            final String url = "jdbc:mysql://localhost:3306/curso_java"; //url do banco de dados
//            final String usuario = "root"; // usuario do banco de dados
//            final String senha = "f3rr31r4";// senha do banco de dados

            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() throws IOException {
        //criando acesso ao arquivo de configuraçoes
        Properties prop = new Properties();
        String caminho = "/conexao.properties";
        prop.load(FabricaConexao.class.getResourceAsStream(caminho));
        return prop;
    }
}
