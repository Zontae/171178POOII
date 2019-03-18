
package managedbea;

import modelo.ProdutoExportacao;
import servico.ProdutoService;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ExternoMB {
    private ProdutoService produtoService =  new ProdutoService();
    private ProdutoExportacao pro = new ProdutoExportacao();
    private ProdutoExportacao selectedPro;
    
    public void salvar(){
        produtoService.salvar(pro);
        pro = new ProdutoExportacao();
    }

    public ArrayList<ProdutoExportacao> getProdutos() {
                return produtoService.getProdutosExterno();
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public ProdutoExportacao getPro() {
        return pro;
    }

    public void setPro(ProdutoExportacao pro) {
        this.pro = pro;
    }

    public ProdutoExportacao getSelectedPro() {
        return selectedPro;
    }

    public void setSelectedPro(ProdutoExportacao selectedPro) {
        this.selectedPro = selectedPro;
    }
    
    public void deleteProd(){
        this.produtoService.remover(selectedPro);
        selectedPro = null;
    }
}
