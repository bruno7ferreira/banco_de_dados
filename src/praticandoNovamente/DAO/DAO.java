package praticandoNovamente.DAO;

import praticandoNovamente.FabricaConexao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {

    private Connection conexao;

    private Connection getConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return conexao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexao = FabricaConexao.getConexao();
        return conexao;
    }

}
