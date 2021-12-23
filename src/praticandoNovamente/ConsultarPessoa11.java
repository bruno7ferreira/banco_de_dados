package praticandoNovamente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoa11 {

    public static void main(String[] args) throws SQLException {

        Connection conexao = FabricaConexao.getConexao();

        String sql = "select * from pessoas";
        PreparedStatement declaracaoPreparada = conexao.prepareStatement(sql);
        ResultSet resultado = declaracaoPreparada.executeQuery(sql);

        List<Pessoa1> pessoas = new ArrayList<>();

        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa1(codigo, nome));
        }

        for (Pessoa1 p : pessoas) {
            System.out.println(p.getCodigo() + " --> " + p.getNome());
        }

        declaracaoPreparada.close();
        conexao.close();
    }

}
