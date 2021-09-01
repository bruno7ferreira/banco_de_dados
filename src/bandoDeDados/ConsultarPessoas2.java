package bandoDeDados;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);

        //criando conexão e query
        Connection conexao = FabricaConexao.getConexao();
        String sql = "select * from pessoas where nome like ?";

        //recebendo valor da consulta
        System.out.println("Informe o valor para pesquisa: ");
        String valor = entrada.nextLine();

        //criado o parametro da consulta
        PreparedStatement demonstracao = conexao.prepareStatement(sql);
        demonstracao.setString(1, "%" + valor + "%");
        ResultSet resultado = demonstracao.executeQuery();

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
        entrada.close();


    }
}
