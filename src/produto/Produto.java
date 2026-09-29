package produto;

import java.text.NumberFormat;

/**
 * Classe abstrata Produto.
 * Representa um produto genérico e serve como base (superclasse) 
 * para ProdutoPerecivel e ProdutoNaoPerecivel.
 * O modificador 'abstract' impede que 'Produto' seja instanciado diretamente.
 */
public abstract class Produto {
    
    // Constante estática, visível para a classe toda
    private static final double MARGEM_PADRAO = 0.2;
    
    // Atributos protegidos (# no UML) para serem acessados nas classes filhas
    private String descricao;
    protected double precoCusto;
    protected double margemLucro;
    
    /**
     * Inicializador privado. Valida os dados de entrada.
     * @param desc Descrição do produto (mínimo de 3 caracteres)
     * @param precoCusto Preço do produto (mínimo 0.01)
     * @param margemLucro Margem de lucro (mínimo 0.01)
     */
    private void init(String desc, double precoCusto, double margemLucro) {
        if ((desc != null && desc.length() >= 3) && (precoCusto > 0.0) && (margemLucro > 0.0)) {
            this.descricao = desc;
            this.precoCusto = precoCusto;
            this.margemLucro = margemLucro;
        } else {
            throw new IllegalArgumentException("Valores inválidos para os dados do produto.");
        }
    }
    
    /**
     * Construtor completo. Como é protected (#), só pode ser chamado pelas classes filhas via 'super()'.
     * @param desc Descrição do produto
     * @param precoCusto Preço de custo
     * @param margemLucro Margem de lucro
     */
    protected Produto(String desc, double precoCusto, double margemLucro) {
        init(desc, precoCusto, margemLucro);
    }
    
    /**
     * Construtor sem margem de lucro. Fica considerado o valor padrão.
     * @param desc Descrição do produto
     * @param precoCusto Preço de custo
     */
    protected Produto(String desc, double precoCusto) {
        init(desc, precoCusto, MARGEM_PADRAO);
    }
    
    /**
     * Retorna o valor de venda do produto.
     * Pode ser reescrito (Overridden) pelas classes filhas devido ao polimorfismo.
     * @return Valor de venda do produto
     */
    public double valorVenda() {
        return (precoCusto * (1.0 + margemLucro));
    }
    
    /**
     * Retorna a descrição do produto formatada.
     */
    @Override
    public String toString() {
        NumberFormat moeda = NumberFormat.getCurrencyInstance();
        // A função valorVenda() será chamada de acordo com o tipo real do objeto (Polimorfismo).
        return String.format("NOME: " + descricao + " | PREÇO DE VENDA: " + moeda.format(valorVenda()));
    }
}
