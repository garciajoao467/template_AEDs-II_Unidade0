package desempenho;

/**
 * Esta classe serve como um material de consulta (guia) para a atividade de
 * Contagem de Operações e Medição do Tempo de Execução (Proj1a_ContagemMedição).
 * Ela demonstra como instrumentar um algoritmo em Java para medir o tempo gasto
 * e o número de operações relevantes realizadas.
 */
public class ContagemMedicaoDemo {

    public static void executarDemonstracao() {
        System.out.println("=== DEMONSTRAÇÃO DE CONTAGEM E MEDIÇÃO DE TEMPO ===");
        
        // Exemplo: Somatório dos elementos de um vetor
        int tamanhoTeste = 10000;
        int[] vetor = new int[tamanhoTeste];
        
        // Preenchendo o vetor com dados de exemplo
        for (int i = 0; i < tamanhoTeste; i++) {
            vetor[i] = i + 1;
        }
        
        // --- INÍCIO DA MEDIÇÃO ---
        long inicioTempo = System.nanoTime();
        long operacoes = 0; // Contador de operações
        
        // Algoritmo: Somatório simples
        long soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
            operacoes++; // Conta 1 operação para cada vez que a linha acima é executada
        }
        
        // --- FIM DA MEDIÇÃO ---
        long fimTempo = System.nanoTime();
        
        // Calcula o tempo decorrido em nanosegundos e milissegundos
        long tempoGastoNano = fimTempo - inicioTempo;
        double tempoGastoMillis = tempoGastoNano / 1_000_000.0;
        
        System.out.println("Tamanho do Teste (n): " + tamanhoTeste);
        System.out.println("Resultado da soma   : " + soma);
        System.out.println("Operações contadas  : " + operacoes);
        System.out.println("Tempo de execução   : " + tempoGastoNano + " ns (" + tempoGastoMillis + " ms)");
        
        System.out.println("\n[Dica de Consulta]");
        System.out.println("Para os algoritmos da atividade, você precisa seguir esse mesmo esqueleto:");
        System.out.println("1. Marque 'inicioTempo' com System.nanoTime().");
        System.out.println("2. Crie um contador de 'operacoes'.");
        System.out.println("3. A cada iteração dos laços internos do algoritmo, incremente o contador.");
        System.out.println("4. Marque 'fimTempo', calcule a diferença e armazene na sua planilha.");
        System.out.println("===================================================\n");
    }
}
