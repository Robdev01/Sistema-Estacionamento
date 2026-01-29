import service.EstacionamentoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EstacionamentoService service = new EstacionamentoService();
        int opcao;

        do {
            System.out.println("\n=== ESTACIONAMENTO ===");
            System.out.println("1 - Entrada de veículo");
            System.out.println("2 - Saída de veículo");
            System.out.println("3 - Listar veículos");
            System.out.println("4 - Faturamento");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();

                    System.out.print("Tipo (1-Carro | 2-Moto): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    service.entrada(tipo == 2 ? "MOTO" : "CARRO", placa);
                }
                case 2 -> {
                    System.out.print("Placa: ");
                    service.registrarSaida(sc.nextLine());
                }
                case 3 -> service.listarVeiculos();
                case 4 -> System.out.println("Faturamento: R$ " + service.getFaturamento());
                case 5 -> System.out.println("Sistema encerrado.");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
