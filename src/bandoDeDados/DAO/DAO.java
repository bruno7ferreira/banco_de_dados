package bandoDeDados.DAO;

import bandoDeDados.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    private Connection conexao;

    protected int incluir(String sql, Object... atributos) {
        try {
            PreparedStatement declaracaoPreparada = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributos(declaracaoPreparada, atributos);
            if (declaracaoPreparada.executeUpdate() > 0) {
                ResultSet resultado = declaracaoPreparada.getGeneratedKeys();
                if (resultado.next()) {
                    return resultado.getInt(1);
                }
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void adicionarAtributos(PreparedStatement declaracaoPreparada, Object[] atributos) throws SQLException {
        int indice = 1;
        for (Object atributo : atributos) {
            if (atributo instanceof String) {
                declaracaoPreparada.setString(indice, (String) atributo);
            } else if (atributo instanceof Integer) {
                declaracaoPreparada.setInt(indice, (Integer) atributo);
            }

            indice++;
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
