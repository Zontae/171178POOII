package servico;


import modelo.Produto;
import modelo.ProdutoExterno;
import modelo.ProdutoInterno;
import java.util.ArrayList;

public class ItemPedidoService {
        private ArrayList <Produto>  listProdutos = Dados.getProdutos();
    
    public void salvar (Produto p){
        listProdutos.add(p);
    }
    
    public ArrayList<Produto> getProdutos(){
        return listProdutos;
    }

    public void setListProdutos(ArrayList<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }
    
    public void remover(Produto p){
        listProdutos.remove(p);
    }

    public ArrayList<ProdutoExterno> getProdutosExterno() {
    
        ArrayList <ProdutoExterno> aux = new ArrayList();
        for(Produto p: listProdutos)
        {
            if(p instanceof ProdutoExterno){
                aux.add((ProdutoExterno) p);
            }
        
        }
        
        return aux;
    }
    
     public ArrayList<ProdutoInterno> getProdutosInterno() {
    
        ArrayList <ProdutoInterno> aux = new ArrayList();
        for(Produto p: listProdutos)
        {
            if(p instanceof ProdutoInterno){
                aux.add((ProdutoInterno) p);
            }
        
        }
        
        return aux;
    }

    
}
