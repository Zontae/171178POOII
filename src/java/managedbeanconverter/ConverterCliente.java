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
import servico.ClienteDBService;




@FacesConverter("converterCliente")
public class ConverterCliente implements Converter {

	private final ClienteDBService servico = new ClienteDBService();
        
        private List<Cliente> lista = servico.getClientes();
        
        public HashMap<String, Cliente> getHashMap(){
            HashMap<String, Cliente> aux = new HashMap();
            lista.stream().forEach((c) -> {
                aux.put(c.getNome(), c);
            });
            
            return aux;
        }
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		Cliente e=null;
		if(value != null && !value.equals("")) {
			e = servico.getClienteByCodigo(value);
		}
		
		return e;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object cli) {
		if (cli == null || cli.equals("")) {
			return null;
		} else {
			return ((Cliente) cli).getNome();

		}
	}

}
