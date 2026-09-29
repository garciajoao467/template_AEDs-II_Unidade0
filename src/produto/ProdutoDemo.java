package produto;

import java.time.LocalDate;

public class ProdutoDemo {
    public static void executarDemonstracao() {
        System.out.println("=== DEMONSTRAÇÃO DE PRODUTOS ===");

        try {
            // Teste 1: Produto Não Perecível
            ProdutoNaoPerecivel p1 = new ProdutoNaoPerecivel("Arroz 5kg", 20.0, 0.3); // 30% lucro
            System.out.println("[Não Perecível] " + p1.toString());

            // Teste 2: Produto Não Perecível (margem padrão de 20%)
            ProdutoNaoPerecivel p2 = new ProdutoNaoPerecivel("Feijão 1kg", 8.0);
            System.out.println("[Não Perecível] " + p2.toString());

            // Teste 3: Produto Perecível com validade distante (> 7 dias) - Sem desconto
            LocalDate validadeLonge = LocalDate.now().plusDays(10);
            ProdutoPerecivel p3 = new ProdutoPerecivel("Leite Integral", 4.0, 0.25, validadeLonge);
            System.out.println("[Perecível, >7d] " + p3.toString());

            // Teste 4: Produto Perecível com validade próxima (<= 7 dias) - Com desconto
            // (25%)
            LocalDate validadeProxima = LocalDate.now().plusDays(5);
            ProdutoPerecivel p4 = new ProdutoPerecivel("Iogurte Natural", 3.0, 0.2, validadeProxima);
            System.out.println("[Perecível, <=7d] " + p4.toString());

            // Teste 5: Produto Perecível com data anterior à hoje (Deve lançar exceção no
            // cadastro)
            System.out.print("[Perecível Exceção de Cadastro] ");
            LocalDate validadePassada = LocalDate.now().minusDays(1);
            ProdutoPerecivel p5 = new ProdutoPerecivel("Queijo", 15.0, 0.3, validadePassada);

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        System.out.println("================================\n");
    }
}
