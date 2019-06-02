
package managedbean;

import modelo.Categoria;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import servico.CategoriaDBService;

@ManagedBean
@SessionScoped
public class CategoriaDBMB {
    private CategoriaDBService categoriadbservice = new CategoriaDBService();
    private Categoria cat = new Categoria();
    private Categoria selectedCat;
    private int catCode;
    
    
    public Categoria getCat(){
        return cat;
    }
    
    public void setCat(Categoria Cat){
        this.cat = Cat;
    }

    public int getCatCode() {
        return catCode;
    }

    public void setCatCode(int catCode) {
        this.catCode = catCode;
    }
    
    public void pesquisarCategoria(){
        cat = categoriadbservice.getCategoriaByCodigo(catCode);
    }
    
    public List<Categoria> getCategorias(){
        return categoriadbservice.getCategorias();
    }
    
    public void deleteCatg(){
    }

    public Categoria getSelectedCat() {
        return selectedCat;
    }

    public void setSelectedCat(Categoria selectedCat) {
        this.selectedCat = selectedCat;
    }
    
    public void salvar(){
        categoriadbservice.salvarAtualizar(cat);
        cat = new Categoria();
    }
}
    

    
    
    
