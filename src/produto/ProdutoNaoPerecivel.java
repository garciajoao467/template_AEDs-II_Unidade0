package produto;

/**
 * Representa um Produto Não Perecível.
 * Esta classe herda de Produto e implementa o construtor apropriado.
 */
public class ProdutoNaoPerecivel extends Produto {

    /**
     * Construtor completo.
     */
    public ProdutoNaoPerecivel(String desc, double precoCusto, double margemLucro) {
        super(desc, precoCusto, margemLucro);
    }

    /**
     * Construtor com margem de lucro padrão.
     */
    public ProdutoNaoPerecivel(String desc, double precoCusto) {
        super(desc, precoCusto);
    }

    /**
     * O valorVenda não sofre alteração para produto não perecível, 
     * logo retorna o mesmo valor base calculado na classe pai.
     */
    @Override
    public double valorVenda() {
        return super.valorVenda();
    }
}
