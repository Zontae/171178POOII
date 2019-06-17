
package servico;

import modelo.Cliente;
import java.util.ArrayList;


public class ClienteService {
    private ArrayList <Cliente>  listcliente = Dados.getClientes();
    
    public void salvar (Cliente c){
        listcliente.add(c);
    }
    
    public ArrayList<Cliente> getClientes(){
        return listcliente;
    }

    public void setListcliente(ArrayList<Cliente> listcliente) {
        this.listcliente = listcliente;
    }
    
    public void remover(Cliente c){
        listcliente.remove(c);
    }
}
