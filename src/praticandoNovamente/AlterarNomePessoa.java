package praticandoNovamente;

import bandoDeDados.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();

        System.out.println("Informe o código da pessoa: ");
        int codigo = entrada.nextInt();

        String select = "select  * from pessoas where ";
        String update = "update pessoas set nome = ? where codigo = ?";
        PreparedStatement declaraPreparada = conexao.prepareStatement(select);
        declaraPreparada.setInt(1, codigo);
        ResultSet resultado = declaraPreparada.executeQuery();

        if (resultado.next()) {
            Pessoa1 cont = new Pessoa1(resultado.getInt(1), resultado.getString(2));

            System.out.println("O nome atual é " + cont.getNome());
            entrada.nextLine();

            System.out.println("Informe o novo nome: ");
            String novoNome = entrada.nextLine();


            declaraPreparada.close();
            declaraPreparada = conexao.prepareStatement(update);
            declaraPreparada.setString(1, novoNome);
            declaraPreparada.setInt(2, codigo);
            declaraPreparada.execute();

            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada!");
        }


        conexao.close();
        entrada.close();
    }

}
