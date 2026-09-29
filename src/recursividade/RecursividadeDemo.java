package recursividade;

import java.util.Scanner;

public class RecursividadeDemo {

    // 1) Somar todos os números pares até um limite escolhido pelo usuário.
    public static int somarPares(int limite) {
        // Caso base: se limite for menor que 2, a soma de pares positivos é 0.
        if (limite < 2) {
            return 0;
        }
        
        // Se o limite atual for par, soma ele e continua com limite - 2
        if (limite % 2 == 0) {
            return limite + somarPares(limite - 2);
        } else {
            // Se for ímpar, não soma o limite e desce um valor para pegar o próximo par
            return somarPares(limite - 1);
        }
    }

    // 2) Somar todos os elementos de um vetor (array) de números double.
    // Usamos um índice adicional para controlar a posição atual no array (abordagem recursiva padrão)
    public static double somarArrayDouble(double[] arr, int index) {
        // Caso base: se o índice for igual ao tamanho do array, não há mais elementos.
        if (index == arr.length) {
            return 0.0;
        }
        // Chamada recursiva: soma o elemento atual com o restante da soma do array
        return arr[index] + somarArrayDouble(arr, index + 1);
    }
    
    // Método auxiliar (sobrecarga) para não precisar passar o índice inicial no código principal
    public static double somarArrayDouble(double[] arr) {
        return somarArrayDouble(arr, 0);
    }

    // 3) Contar a quantidade de repetições, em um vetor, de um número escolhido pelo usuário.
    public static int contarRepeticoes(int[] arr, int numero, int index) {
        // Caso base: chegamos ao fim do array
        if (index == arr.length) {
            return 0;
        }
        
        // Verifica se o elemento atual é igual ao número buscado
        int count = (arr[index] == numero) ? 1 : 0;
        
        // Chamada recursiva para verificar o restante do array
        return count + contarRepeticoes(arr, numero, index + 1);
    }
    
    // Método auxiliar
    public static int contarRepeticoes(int[] arr, int numero) {
        return contarRepeticoes(arr, numero, 0);
    }

    public static void executarDemonstracao(Scanner scanner) {
        int opcao;
        
        do {
            System.out.println("=== MENU DE RECURSIVIDADE ===");
            System.out.println("1) Somar números pares até um limite");
            System.out.println("2) Somar elementos de um vetor (double)");
            System.out.println("3) Contar repetições em um vetor (int)");
            System.out.println("0) Sair do menu de recursividade");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o limite (número inteiro positivo): ");
                    int limite = scanner.nextInt();
                    int somaPares = somarPares(limite);
                    System.out.println("A soma dos pares até " + limite + " é: " + somaPares);
                    break;
                    
                case 2:
                    System.out.print("Quantos números double você quer inserir? ");
                    int tamanhoDouble = scanner.nextInt();
                    double[] arrDouble = new double[tamanhoDouble];
                    for (int i = 0; i < tamanhoDouble; i++) {
                        System.out.print("Valor " + (i + 1) + ": ");
                        arrDouble[i] = scanner.nextDouble();
                    }
                    double somaArray = somarArrayDouble(arrDouble);
                    System.out.println("A soma total do vetor é: " + somaArray);
                    break;
                    
                case 3:
                    System.out.print("Quantos números inteiros você quer inserir no vetor? ");
                    int tamanhoInt = scanner.nextInt();
                    int[] arrInt = new int[tamanhoInt];
                    for (int i = 0; i < tamanhoInt; i++) {
                        System.out.print("Valor " + (i + 1) + ": ");
                        arrInt[i] = scanner.nextInt();
                    }
                    System.out.print("Qual número você deseja contar as repetições? ");
                    int numBuscado = scanner.nextInt();
                    int repeticoes = contarRepeticoes(arrInt, numBuscado);
                    System.out.println("O número " + numBuscado + " repete " + repeticoes + " vezes no vetor.");
                    break;
                    
                case 0:
                    System.out.println("Saindo do menu de recursividade...");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println();
            
        } while (opcao != 0);
    }
}
