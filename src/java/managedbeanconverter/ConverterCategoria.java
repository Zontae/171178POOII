/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeanconverter;

/**
 *
 * @author glauc
 */


import java.util.HashMap;
import java.util.List;
import modelo.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import servico.CategoriaDBService;




@FacesConverter("converterCategoria")
public class ConverterCategoria implements Converter {

	private CategoriaDBService servico = new CategoriaDBService();
        
        private List<Categoria> lista = servico.getCategorias();
        
        public HashMap<String, Categoria> getHashMap(){
            HashMap<String, Categoria> aux = new HashMap();
            lista.stream().forEach((c) -> {
                aux.put(c.getCategoria(), c);
            });
            
            return aux;
        }
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		Categoria e=null;
		if(value != null && !value.equals("")) {
			e = servico.getCategoriaByCodigo(value);
		}
		
		return e;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object cat) {
		if (cat == null || cat.equals("")) {
			return null;
		} else {
			return ((Categoria)cat).getCategoria();

		}
	}

}
