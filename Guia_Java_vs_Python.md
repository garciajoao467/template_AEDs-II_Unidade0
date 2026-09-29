# Guia de Sobrevivência: Java para quem sabe Python 🐍 ➔ ☕

Como você já domina Python, aprender Java fica bem mais fácil se você fizer paralelos entre as duas linguagens. A principal diferença de mentalidade é: **Java é fortemente tipado e verboso**. No Python, o interpretador "adivinha" o que você quer fazer; no Java, você precisa avisar **tudo** para o compilador com antecedência.

---

## 1. Estrutura Básica de um Arquivo

No Python, você pode simplesmente jogar um `print("Olá")` na primeira linha e rodar.
No Java, **todo código deve estar dentro de uma Classe**, e para o código rodar, ele precisa de um **Ponto de Entrada** chamado `main`.

**Python:**
```python
# main.py
print("Olá, Mundo!")
```

**Java:**
```java
// Main.java (O nome do arquivo DEVE ser igual ao nome da classe pública)
public class Main {
    // O método 'main' é por onde o Java começa a rodar o programa
    public static void main(String[] args) {
        System.out.println("Olá, Mundo!");
    }
}
```

---

## 2. Declaração de Variáveis e Tipos

Enquanto no Python a tipagem é dinâmica (a variável muda de tipo sozinha), no Java a tipagem é estática. Você **deve** dizer o tipo da variável quando for criá-la.

**Python:**
```python
idade = 20          # Int
preco = 49.99       # Float
nome = "João"       # String
aprovado = True     # Bool
```

**Java:**
```java
int idade = 20;             // Inteiros
double preco = 49.99;       // Decimais (double é mais comum que float em Java)
String nome = "João";       // Textos (Sempre com S maiúsculo e aspas duplas "")
boolean aprovado = true;    // Booleanos (tudo minúsculo)

// DICA: No Java sempre tem ; no final de cada instrução!
```

---

## 3. Vetores (Arrays) vs Listas do Python

Essa é uma das maiores diferenças. No Python, uma `list` cresce sozinha, aceita qualquer tipo de dado misturado e tem vários métodos fáceis (`append()`). 
No Java, um **Array (Vetor) tem tamanho fixo**. Se você criar um array de tamanho 5, ele nunca será tamanho 6. E ele só aceita um tipo de dado.

**Python:**
```python
# Lista dinâmica
notas = [8.5, 9.0, 7.5]
notas.append(10.0) # Funciona perfeitamente
print(notas[0])
```

**Java (Arrays):**
```java
// Vetor fixo (Tamanho definido na criação)
double[] notas = new double[3]; // Cria um vetor de 3 espaços vazios
notas[0] = 8.5;
notas[1] = 9.0;
notas[2] = 7.5;
// notas[3] = 10.0; -> ISSO DARIA ERRO (IndexOutOfBoundsException)! O tamanho é 3.

System.out.println(notas[0]);

// Também dá pra criar já com os valores, igual no Python:
double[] notasRapidas = {8.5, 9.0, 7.5};
```
*Se você precisar de uma lista que cresce dinamicamente (como no Python), no Java nós usamos o `ArrayList`, mas para algoritmos básicos na faculdade, normalmente exige-se dominar os vetores `[]`.*

---

## 4. Estruturas de Controle (If / For / While)

No Python a gente usa indentação (espaços). No Java a gente usa chaves `{ }` e parênteses `()`.

**Python:**
```python
if idade >= 18:
    print("Maior")
else:
    print("Menor")

# For de 0 até 4
for i in range(5):
    print(i)
```

**Java:**
```java
if (idade >= 18) {
    System.out.println("Maior");
} else {
    System.out.println("Menor");
}

// For (inicialização ; condição de parada ; incremento)
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

---

## 5. Como criar e instanciar uma Classe (POO)

A Orientação a Objetos é muito parecida. No Python usamos o `__init__` para o construtor e passamos o `self`. No Java o construtor tem **o mesmo nome da classe** e usamos a palavra `this` (opcional, só quando dá conflito de nomes). Além disso, no Java os atributos precisam ser declarados no "corpo" da classe e temos **Modificadores de Acesso** (`public`, `private`, `protected`).

**Python:**
```python
class Cachorro:
    def __init__(self, nome, raca):
        self.nome = nome # atributo solto
        self.raca = raca
    
    def latir(self):
        print(f"{self.nome} disse: Au Au!")

# Usando a classe:
dog = Cachorro("Rex", "Pug")
dog.latir()
```

**Java:**
```java
public class Cachorro {
    
    // 1. Você tem que avisar os atributos ANTES do construtor
    private String nome;
    private String raca;

    // 2. Construtor (Mesmo nome da classe, sem tipo de retorno)
    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    // 3. Métodos
    public void latir() {
        // Concatenando string (+). 
        System.out.println(this.nome + " disse: Au Au!"); 
    }
}

// Para usar a classe em outro arquivo (ex: na main):
// É obrigatório usar a palavra 'new' para criar o objeto.
Cachorro dog = new Cachorro("Rex", "Pug");
dog.latir();
```

---

## 6. Lendo dados do Usuário (Entrada/Input)

Ler coisas do teclado no Python é muito fácil com o `input()`. No Java, precisamos usar uma classe chamada `Scanner`. **Foi por causa do Scanner que o seu programa deu erro agora há pouco!** No VSCode, se você rodar o código pela aba "OUTPUT" (Saída), ele não deixa você digitar nada e o programa quebra (`NoSuchElementException`). Você tem que rodar no **Terminal**.

**Python:**
```python
nome = input("Digite seu nome: ")
idade = int(input("Digite sua idade: "))
```

**Java:**
```java
import java.util.Scanner; // Tem que importar no topo do arquivo!

public class LerDados {
    public static void main(String[] args) {
        // Cria um leitor apontando para o teclado (System.in)
        Scanner leitor = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");
        String nome = leitor.nextLine(); // Lê até dar Enter (Texto)
        
        System.out.print("Digite sua idade: ");
        int idade = leitor.nextInt();    // Lê apenas o número inteiro
        
        System.out.println("Seu nome é " + nome + " e você tem " + idade);
        
        leitor.close(); // Sempre bom fechar
    }
}
```

### Resumo Rápido de Tradução:
| Ação | Em Python | Em Java |
| :--- | :--- | :--- |
| Imprimir na tela | `print("X")` | `System.out.println("X");` |
| Ler Teclado | `input()` | `scanner.nextLine()` / `scanner.nextInt()` |
| Tamanho de Vetor/String | `len(lista)` | `array.length` ou `texto.length()` |
| Herança | `class Gato(Animal):` | `public class Gato extends Animal {` |
| Comentário de 1 Linha | `# comentário` | `// comentário` |
| Função/Método s/ retorno | `def metodo(self):` | `public void metodo() {` |
