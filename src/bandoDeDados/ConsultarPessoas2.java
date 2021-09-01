package bandoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws SQLException {

        //criar conexão
        Connection conexao = FabricaConexao.getConexao();
        String sql = "select * from pessoas";

        Statement demonstracao = conexao.createStatement();
        ResultSet resultado = demonstracao.executeQuery(sql);

        List<Pessoa> pessoas = new ArrayList<>();
        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }
        for (Pessoa p : pessoas) {
            System.out.println(p.getCodigo() + " --> " + p.getNome());
        }

        demonstracao.close();
        conexao.close();


    }
}
