package praticandoNovamente.DAO;

import java.util.Scanner;

public class DAOTeste2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        DAO dao = new DAO();

        //Menu
        System.out.println("Selecione a opção desejada!");
        System.out.println("1 - para Consultar \n" +
                "2 - para adicionar \n" +
                "3 - para remover \n");
        String opcao = entrada.nextLine();

        switch (opcao) {
            case "1":
                break;
            case "2":
                String sql = "insert into pessoas (nome) values (?)";
                dao.incluir(sql, "Bruno Rogério Ferreira");
                break;
            case "3":
                break;
        }


//        String sql = "insert into pessoas (nome) values (?)";
//        dao.incluir(sql, "Bruno Rogério Ferreira");

        entrada.close();
    }

}
