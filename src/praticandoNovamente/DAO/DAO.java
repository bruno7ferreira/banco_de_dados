package praticandoNovamente.DAO;

import praticandoNovamente.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {

    private Connection conexao;

    public int incluir(String sql, Object... atributos) {
        try {
            PreparedStatement declaracaoPreparada = getConexao().prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
