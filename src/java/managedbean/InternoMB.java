
package managedbean;

import modelo.ProdutoInterno;
import servico.ProdutoService;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class InternoMB {
    private ProdutoService produtoService =  new ProdutoService();
    private ProdutoInterno pro = new ProdutoInterno();
    private ProdutoInterno selectedPro;
    
    public void salvar(){
        produtoService.salvar(pro);
        pro = new ProdutoInterno();
    }

    public ArrayList<ProdutoInterno> getProdutos() {
        return produtoService.getProdutosInterno();
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public ProdutoInterno getPro() {
        return pro;
    }

    public void setPro(ProdutoInterno pro) {
        this.pro = pro;
    }

    public ProdutoInterno getSelectedPro() {
        return selectedPro;
    }

    public void setSelectedPro(ProdutoInterno selectedPro) {
        this.selectedPro = selectedPro;
    }

    public void deleteProd(){
        this.produtoService.remover(selectedPro);
        selectedPro = null;
    }
}
