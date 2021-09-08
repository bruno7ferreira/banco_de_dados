package bandoDeDados;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Teste {

    public static Properties getProperties() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\broge\\Desktop\\banco de dados java\\conexaoDB.properties");
        props.load(file);
        return props;
    }

    public static void main(String[] args) throws IOException {


        String login;
        String host;
        String passaword;
        System.out.println("**Teste de leitura de arquivo de configuração externo**");

        Properties prop = getProperties();

        login = prop.getProperty("banco.url");
        host = prop.getProperty("banco.usuario");
        passaword = prop.getProperty("banco.senha");

        System.out.println("Login = " + login);
        System.out.println("Host = " + host);
        System.out.println("Senha = " + passaword);


    }
}
