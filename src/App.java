import java.util.Scanner;

import produto.ProdutoDemo;
import recursividade.RecursividadeDemo;
import desempenho.ContagemMedicaoDemo;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("==========================================================");
        System.out.println("   BEM-VINDO AO GUIA DE ESTUDOS DE AEDs II (Unidade 0)    ");
        System.out.println("==========================================================");
        System.out.println("Este projeto serve como material de consulta e modelo para");
        System.out.println("construção de programas do zero e para as atividades base.");
        System.out.println("==========================================================");

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1) Atividade 0a: Produtos (Classes, Herança e Polimorfismo)");
            System.out.println("2) Oficina: Revisão de Recursividade");
            System.out.println("3) Projeto 1a: Contagem de Operações e Medição de Tempo");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Executa a demonstração do uso de Produto, ProdutoPerecivel, etc.
                    ProdutoDemo.executarDemonstracao();
                    break;
                case 2:
                    // Chama o submenu específico para os exercícios de recursividade
                    RecursividadeDemo.executarDemonstracao(scanner);
                    break;
                case 3:
                    // Executa a demonstração base para medição de algoritmos
                    ContagemMedicaoDemo.executarDemonstracao();
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Bons estudos!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
