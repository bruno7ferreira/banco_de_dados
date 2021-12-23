package praticandoNovamente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultarPessoa11 {

    public static void main(String[] args) throws SQLException {

        Connection conexao = FabricaConexao.getConexao();

        String sql = "select * from pessoas";
        PreparedStatement declaracaoPreparada = conexao.prepareStatement(sql);
        declaracaoPreparada.execute(sql);

        conexao.close();
    }

}
