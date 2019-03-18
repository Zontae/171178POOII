/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbea;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import servico.ClienteDBService;

/**
 *
 * @author gabri
 */
@ManagedBean
@SessionScoped
public class ClienteDBMB {
    
    private ClienteDBService clientedbservice = new ClienteDBService();
    private Cliente cli = new Cliente();
    private Cliente selectedCli;
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void salvar(){
        clientedbservice.salvar(cli);
        codigo = 0;
        cli = new Cliente();
    }
    
        public List<Cliente> getClientes(){
        return clientedbservice.getClientes();
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
    public void pesquisarCliente(){
        cli = clientedbservice.getClienteByCodigo(codigo);
    }
    
}
