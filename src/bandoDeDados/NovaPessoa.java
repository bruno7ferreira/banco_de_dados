package bandoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String nome = entrada.nextLine();

        Connection conexao = FabricaConexao.getConexao(); //criando a conexão com banco de dados
        String sql = "insert into pessoas (nome) values(?)"; //adicionando valor da variavel no banco de dados
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome); //parametro de entrada da variavel para o sql

        stmt.execute();
        System.out.println("Pessoa incluida com sucesso!");

        entrada.close();

    }
}
