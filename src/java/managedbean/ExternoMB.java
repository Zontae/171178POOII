
package managedbean;

import modelo.ProdutoExterno;
import servico.ProdutoService;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ExternoMB {
    private ProdutoService produtoService =  new ProdutoService();
    private ProdutoExterno pro = new ProdutoExterno();
    private ProdutoExterno selectedPro;
    
    public void salvar(){
        produtoService.salvar(pro);
        pro = new ProdutoExterno();
    }

    public ArrayList<ProdutoExterno> getProdutos() {
                return produtoService.getProdutosExterno();
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public ProdutoExterno getPro() {
        return pro;
    }

    public void setPro(ProdutoExterno pro) {
        this.pro = pro;
    }

    public ProdutoExterno getSelectedPro() {
        return selectedPro;
    }

    public void setSelectedPro(ProdutoExterno selectedPro) {
        this.selectedPro = selectedPro;
    }
    
    public void deleteProd(){
        this.produtoService.remover(selectedPro);
        selectedPro = null;
    }
}
