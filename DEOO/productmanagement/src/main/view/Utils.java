package view;

import dto.ProductDto;

import java.util.Scanner;

public class Utils{
    private final static Scanner scanner = new Scanner(System.in);
    private final static String line = "--------------------------------------";

    public static int readInteger(String msg){
        System.out.println(line);
        System.out.print(msg.toUpperCase());
        return scanner.nextInt();
    }

    public static Options menu(){
        System.out.println(line);
        System.out.println("MENU");
        System.out.println("1 - ADICIONAR PRODUTO");
        System.out.println("2 - REMOVER PRODUTO");
        System.out.println("3 - ATUALIZAR PRODUTO");
        System.out.println("4 - LISTAR PRODUTOS");

        System.out.println("0 - SAIR");

        return switch (scanner.nextInt()) {
            case 1 -> Options.ADICIONAR_PRODUTO;
            case 2 -> Options.REMOVER_PRODUTO;
            case 3 -> Options.ATUALIZAR_PRODUTO;
            case 4 -> Options.LISTAR_PRODUTOS;
            default -> Options.SAIR;
        };
    }

    public static ProductDto readProduct(){
        System.out.println(line);
        scanner.nextLine();
        System.out.println("CADASTRO DE PRODUTO");
        System.out.print("NOME.............: ");
        String name = scanner.nextLine();
        System.out.print("DESCRIÇÃO..: ");
        String description = scanner.nextLine();
        System.out.print("PREÇO..........: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("QUANTIDADE EM ESTOQUE..........: ");
        int stock = scanner.nextInt();

        return new ProductDto(name, description, price, stock);
    }

    public static void showProduct(ProductDto product){
        System.out.println(line);
        System.out.println("NOME: " + product.getName());
        System.out.println("\t:DESCRIÇÃO " + product.getDescription());
        System.out.println("\tPREÇO: " + product.getPrice());
        System.out.print("\tQUANTIDADE EM ESTOQUE: " + product.getStock());
    }

    public static void showMessage(String msg){
        System.out.println();
        System.out.println();
        System.out.println(line);
        System.out.println();
        System.out.println(msg.toUpperCase());
        System.out.println();
        System.out.println(line);
        System.out.println();
        System.out.println();
    }
}
