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
import modelo.Cliente;
import modelo.Produto;
import servico.ClienteDBService;
import servico.ProdutoDBService;




@FacesConverter("converterProduto")
public class ConverterProduto implements Converter {

	private final ProdutoDBService servico = new ProdutoDBService();
        
        private List<Produto> lista = servico.getProdutos();
        
        public HashMap<String, Produto> getHashMap(){
            HashMap<String, Produto> aux = new HashMap();
            lista.stream().forEach((p) -> {
                aux.put(p.getNome(), p);
            });
            
            return aux;
        }
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		Produto e=null;
		if(value != null && !value.equals("")) {
			e = servico.getProdutoByCodigo(value);
		}
		
		return e;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object produto) {
		if (produto == null || produto.equals("")) {
			return null;
		} else {
			return ((Produto) produto).getNome();

		}
	}

}
