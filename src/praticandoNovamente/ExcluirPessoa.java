package praticandoNovamente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();

        System.out.println("Informe o código da pessoa a ser excluída");
        int codigo = entrada.nextInt();//recebendo o codigo

        String excluirSQL = "delete from pessoas where codigo = ?";
        PreparedStatement declaracaoPreparada = conexao.prepareStatement(excluirSQL);
        declaracaoPreparada.setInt(1,codigo);

        if (declaracaoPreparada.executeUpdate())


        conexao.close();
        entrada.close();
    }

}
