package ordenacao;

public class MetodosOrdenacao {

    /**
     * 1. BUBBLE SORT (Ordenação por Bolha)
     * 
     * QUANDO USAR: Quase nunca em sistemas reais. Só use na prova se o professor pedir 
     * especificamente o Bubble Sort. 
     * POR QUÊ? Ele é muito lento (Complexidade O(n^2)), mas é o mais fácil de entender e decorar.
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // A cada iteração o maior elemento vai pro final, então não precisamos testar o final novamente
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos (swap)
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 2. SELECTION SORT (Ordenação por Seleção)
     * 
     * QUANDO USAR: Quando a escrita na memória for muito cara (custosa), 
     * pois ele faz o mínimo de "trocas" (swaps) possível. Mas ainda é lento (O(n^2)).
     */
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Encontra o índice do menor elemento no restante do array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            // Troca o menor elemento encontrado com o elemento da posição 'i'
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 3. INSERTION SORT (Ordenação por Inserção)
     * 
     * QUANDO USAR: Excelente se o array for MUITO PEQUENO ou se o array já estiver QUASE ORDENADO. 
     * Na prática, algoritmos complexos como QuickSort usam o InsertionSort internamente para 
     * ordenar pedaços pequenos do array.
     */
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int chave = array[i]; // Elemento a ser inserido na parte ordenada
            int j = i - 1;

            // Move os elementos que são maiores que a chave uma posição para a frente
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = chave;
        }
    }

    /**
     * 4. QUICK SORT (Ordenação Rápida)
     * 
     * QUANDO USAR: É o algoritmo de ordenação mais usado na vida real para arrays.
     * Extremamente rápido na média (O(n log n)) e gasta pouca memória extra. 
     * Use sempre que o professor pedir "um algoritmo eficiente de ordenação".
     * 
     * PARA COPIAR: O QuickSort precisa de DOIS métodos, o principal e o de partição.
     */
    public static void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivot = particionar(array, inicio, fim);
            // Ordena recursivamente as duas metades
            quickSort(array, inicio, indicePivot - 1);
            quickSort(array, indicePivot + 1, fim);
        }
    }
    
    // Para chamar o QuickSort mais facilmente (copie este tbm)
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static int particionar(int[] array, int inicio, int fim) {
        int pivot = array[fim]; // Escolhendo o último elemento como pivot
        int i = (inicio - 1); // Índice do menor elemento

        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivot) {
                i++;
                // Troca array[i] e array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Coloca o pivot na sua posição correta (i + 1)
        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1;
    }

    /**
     * 5. MERGE SORT (Ordenação por Mistura)
     * 
     * QUANDO USAR: Quando precisar de "estabilidade" (elementos iguais mantêm a ordem original) 
     * ou quando for ordenar listas encadeadas (LinkedList) ou grandes volumes de dados no disco 
     * (arquivos externos). Ponto negativo: gasta mais memória (cria arrays auxiliares). O(n log n).
     * 
     * PARA COPIAR: Também precisa de dois métodos (o recursivo e o que junta as metades).
     */
    public static void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            // Ordena as duas metades
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);

            // Mistura as metades ordenadas
            merge(array, inicio, meio, fim);
        }
    }
    
    // Para chamar o MergeSort mais facilmente
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void merge(int[] array, int inicio, int meio, int fim) {
        // Tamanhos dos dois sub-arrays a serem misturados
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        // Copiando os dados para os arrays temporários
        for (int i = 0; i < n1; ++i) esquerda[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j) direita[j] = array[meio + 1 + j];

        // Índices para percorrer as metades
        int i = 0, j = 0;
        int k = inicio; // Índice do array principal

        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes, se houver
        while (i < n1) {
            array[k] = esquerda[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = direita[j];
            j++;
            k++;
        }
    }
}
