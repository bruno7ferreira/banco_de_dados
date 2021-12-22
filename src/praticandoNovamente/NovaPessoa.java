package praticandoNovamente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = entrada.nextLine();

        Connection conexao = FabricaConexao.getConexao();

        String sql = "insert into pessoas (nome) values(?)";
        PreparedStatement declaracaoPreparada = conexao.prepareStatement(sql);
        declaracaoPreparada.setString(1, nome );

        declaracaoPreparada.execute();
        System.out.println("Pessoa incluída com sucesso!");

        entrada.close();
    }


}
