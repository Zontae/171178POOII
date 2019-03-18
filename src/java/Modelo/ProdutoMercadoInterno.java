
package modelo;


public class ProdutoMercadoInterno extends Produto{
    private boolean incentivo;

    public ProdutoMercadoInterno(String nome, Categoria categoria, double preco, int moeda, double imposto,boolean incentivo) {
        super(nome, categoria, preco, moeda, imposto);
        this.incentivo = incentivo;
    }

    public ProdutoMercadoInterno() {
        
    }
    
    

    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }
    
    
    
}
