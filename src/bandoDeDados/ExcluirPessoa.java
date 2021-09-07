package bandoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o código da pessoa a ser excluída");
        int codigo = entrada.nextInt(); //amazenando o valor do codigo recebido na variavel

        Connection conexao = FabricaConexao.getConexao();
        String deletar = "delete from pessoas where codigo =?";

        PreparedStatement declaracaoPreparada = conexao.prepareStatement(deletar);
        declaracaoPreparada.setInt(1, codigo); // tipo de dados recebedidos por parametro

        if (declaracaoPreparada.executeUpdate() > 0) {
            System.out.println("pessoa excluida com sucesso!");
        } else {
            System.out.println("Nenhuma alteração foi realizada!");
        }


        entrada.close();
        conexao.close();

    }


}
