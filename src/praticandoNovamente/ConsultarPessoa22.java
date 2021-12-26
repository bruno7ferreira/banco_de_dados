package praticandoNovamente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoa22 {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);//Scanner

        Connection conexao = FabricaConexao.getConexao();//conexao
        String sql = "select * from pessoas where nome like ?";//sql
        String valor = entrada.nextLine();

        PreparedStatement declaracaoPreparada = conexao.prepareStatement(sql);
        declaracaoPreparada.setString(1, "%" + valor + "%");
        ResultSet resultado = declaracaoPreparada.executeQuery();

        List<Pessoa1> pessoas = new ArrayList<>();

        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa1(codigo, nome));

        }

        for (Pessoa1 cont : pessoas) {
            System.out.println(cont.getCodigo() + "-->" + cont.getNome());
        }

        entrada.close();
        declaracaoPreparada.close();
        conexao.close();
    }

}
