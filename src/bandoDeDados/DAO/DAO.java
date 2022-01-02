package bandoDeDados.DAO;

import praticandoNovamente.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {

    private Connection conexao;

    private int incluir(String sql, Object... atributos) {
        try {
            PreparedStatement declaracaoPreparada = getConexao().prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Connection getConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return conexao;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        conexao = FabricaConexao.getConexao();
        return conexao;
    }

}
