package bandoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o código da Pessoa: ");
        int codigo = entrada.nextInt();

        String select = "select codigo, nome from pessoas where codigo = ?"; //Comando SQL
        String update = "update pessoas set nome= ? where codigo = ?"; //comando SQL
        Connection conexao = FabricaConexao.getConexao();// criando conexao com banco de dados
        PreparedStatement declaracaoPreparada = conexao.prepareStatement(select);/*preparação para  receber linha
         de comando SQL*/
        declaracaoPreparada.setInt(1, codigo);//tipo de dado recebido na declaração
        ResultSet resultado = declaracaoPreparada.executeQuery(); // resultado da query sql

        if (resultado.next()) {
            Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));

            System.out.println("O nome atual é " + p.getNome());

            System.out.println("Informe o novo nome: ");
            String novoNome = entrada.nextLine();

            declaracaoPreparada.close();
            declaracaoPreparada = conexao.prepareStatement(update);
            declaracaoPreparada.setString(1, novoNome);//definindo parametro da declaração SQL
            declaracaoPreparada.setInt(2, codigo);//definindo parametro da declaração SQL

        }

        conexao.close();
        entrada.close();
    }

}
