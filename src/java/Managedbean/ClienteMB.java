
package managedbean;

import modelo.Cliente;
import servico.ClienteService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ClienteMB {
    private ClienteService clienteService = new ClienteService();
    private Cliente cli = new Cliente();
    private Cliente selectedClin;
    
    public void salvar(){
        clienteService.salvar(cli);
        cli = new Cliente();
    }
    
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }
    
    public Cliente getCli(){
        return cli;
    }
    
    public void setCli(Cliente Cli){
        this.cli = Cli;
    }
    
    public Cliente getSelectedClin(){
        return selectedClin;
    }
    
    public void setSelectedClin(Cliente selectedClin){
        this.selectedClin = selectedClin;
    }
    
    public void deleteCli(){
        this.clienteService.remover(selectedClin);
        selectedClin = null;
    }
}
    

    
    
    
