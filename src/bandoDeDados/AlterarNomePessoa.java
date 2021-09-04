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

        String sql = "select codigo, nome from pessoas where codigo = ?"; //Comando SQL
        Connection conexao = FabricaConexao.getConexao();// criando conexao com banco de dados
        PreparedStatement declaracaoPreparada = conexao.prepareStatement(sql);//preparação para receber linha de comando SQL
        declaracaoPreparada.setInt(1, codigo);//tipo de dado recebido na declaração
        ResultSet resultado = declaracaoPreparada.executeQuery(); // resultado da query sql

        if (resultado.next()) {
            Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));
        }

        conexao.close();
        entrada.close();
    }

}
