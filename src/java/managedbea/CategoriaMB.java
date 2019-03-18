
package managedbea;

import modelo.Categoria;
import servico.CategoriaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CategoriaMB {
    private CategoriaService categoriaService = new CategoriaService();
    private Categoria cat = new Categoria();
    private Categoria selectedCat;
    
    public void salvar(){
        categoriaService.salvar(cat);
        cat = new Categoria();
    }
    
    public List<Categoria> getCategorias(){
        return categoriaService.getCategorias();
    }
    
    public Categoria getCat(){
        return cat;
    }
    
    public void setCat(Categoria Cat){
        this.cat = Cat;
    }
    
    public Categoria getSelectedCat(){
        return selectedCat;
    }
    
    public void setSelectedCat(Categoria selectedCat){
        this.selectedCat = selectedCat;
    }
    
    public void deleteCatg(){
        this.categoriaService.remover(selectedCat);
        selectedCat = null;
    }
    
}
    

    
    
    
