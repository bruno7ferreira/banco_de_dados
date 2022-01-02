package bandoDeDados.DAO;

public class DAOTeste {

    public static void main(String[] args) {

        DAO dao =new DAO();

        String sql = "insert into pessoas (nome) values (?)";
        dao.incluir(sql, "Bruno Rogério Ferreira");

    }

}
