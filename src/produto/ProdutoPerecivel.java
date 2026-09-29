package produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Representa um Produto Perecível.
 * Esta classe herda de Produto e adiciona as regras de prazo de validade e desconto.
 */
public class ProdutoPerecivel extends Produto {

    private static final double DESCONTO = 0.25; // 25%
    private static final int PRAZO_DESCONTO = 7; // 7 dias
    
    private LocalDate dataDeValidade;

    /**
     * Construtor de ProdutoPerecivel.
     * @param validade Data de validade. Não pode ser anterior ao dia de hoje (no momento do cadastro).
     */
    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate validade) {
        super(desc, precoCusto, margemLucro);
        
        // A regra diz: "Este produto não pode ser cadastrado com uma data de validade anterior ao dia atual"
        if (validade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de validade não pode ser anterior à data de hoje no cadastro.");
        }
        
        this.dataDeValidade = validade;
    }

    /**
     * Retorna o valor de venda. 
     * Regras:
     * - Retorna erro/exception caso a data de validade já tenha passado (produto vencido).
     * - Aplica desconto se a data de validade for em 7 dias ou menos a partir de hoje.
     */
    @Override
    public double valorVenda() {
        LocalDate hoje = LocalDate.now();
        
        // Se a validade expirou (é antes de hoje), o produto não pode ser vendido.
        if (dataDeValidade.isBefore(hoje)) {
            throw new IllegalStateException("Produto vencido! A venda não é permitida.");
        }
        
        // Obter valor base
        double valorBase = super.valorVenda();
        
        // Calcula a diferença de dias
        long diasParaVencer = ChronoUnit.DAYS.between(hoje, dataDeValidade);
        
        // Aplica o desconto de 25% se o prazo for de 7 dias ou menos.
        if (diasParaVencer <= PRAZO_DESCONTO) {
            return valorBase * (1.0 - DESCONTO);
        }
        
        return valorBase;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + " | Validade: " + dataDeValidade.format(formatter);
    }
}
