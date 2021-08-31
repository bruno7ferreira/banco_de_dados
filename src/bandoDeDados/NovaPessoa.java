package bandoDeDados;

import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String nome = entrada.next();

        String sql = "insert into pessoas (nome) values('" + nome + "')";
        System.out.println(sql);


        entrada.close();
    }
}
