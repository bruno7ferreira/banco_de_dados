package praticandoNovamente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoa22 {

    public static void main(String[] args) throws SQLException {

        Connection conexao = FabricaConexao.getConexao();

        String sql = "create table pessoas(" +
                "codigo int auto_increment primary key," +
                "nome varchar (80) not null " +
                ")";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.execute(sql);

        System.out.println("Tabela criada com sucesso!");
        conexao.close();
    }

}
