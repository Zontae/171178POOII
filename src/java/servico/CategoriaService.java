
package servico;

import modelo.Categoria;
import java.util.ArrayList;



public class CategoriaService {
    private ArrayList <Categoria>  listCategoria = Dados.getCategorias();
    
    public void salvar (Categoria c){
        listCategoria.add(c);
    }
    
    public ArrayList<Categoria> getCategorias(){
        return listCategoria;
    }

    public void setListCategoria(ArrayList<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }
    
    public void remover(Categoria c){
        listCategoria.remove(c);
    }
    
     public Categoria getCategoriaByDescricao(String value) {
    
        for(Categoria e: listCategoria){
           if(e.getDescricao().equals(value))
               return e;
        
        }
        
        return null;
    }
}
