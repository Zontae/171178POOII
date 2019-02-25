
package managedbean;

import modelo.ProdutoMercadoInterno;
import servico.ProdutoService;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class InternoMB {
    private ProdutoService produtoService =  new ProdutoService();
    private ProdutoMercadoInterno pro = new ProdutoMercadoInterno();
    private ProdutoMercadoInterno selectedPro;
    
    public void salvar(){
        produtoService.salvar(pro);
        pro = new ProdutoMercadoInterno();
    }

    public ArrayList<ProdutoMercadoInterno> getProdutos() {
        return produtoService.getProdutosInterno();
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public ProdutoMercadoInterno getPro() {
        return pro;
    }

    public void setPro(ProdutoMercadoInterno pro) {
        this.pro = pro;
    }

    public ProdutoMercadoInterno getSelectedPro() {
        return selectedPro;
    }

    public void setSelectedPro(ProdutoMercadoInterno selectedPro) {
        this.selectedPro = selectedPro;
    }

    public void deleteProd(){
        this.produtoService.remover(selectedPro);
        selectedPro = null;
    }
}
