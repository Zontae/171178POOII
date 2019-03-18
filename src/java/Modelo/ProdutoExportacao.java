
package modelo;


public class ProdutoExportacao extends Produto{
    private String destino;

    public ProdutoExportacao(int codigo, String nome, Categoria categoria, double preco, int moeda, double imposto,String destino) {
        super(nome, categoria, preco, moeda, imposto);
        this.destino = destino;
    }

    public ProdutoExportacao() {
        
    }

    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
}
