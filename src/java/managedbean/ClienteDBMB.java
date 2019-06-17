/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import servico.ClienteDBService;

/**
 *
 * @author 
 */
@ManagedBean
@SessionScoped
public class ClienteDBMB {
    
    private ClienteDBService clientedbservice = new ClienteDBService();
    private Cliente cli = new Cliente();
    private int codigo;

    public ClienteDBMB() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void salvar(){
        clientedbservice.salvarAtualizar(cli);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteDBMB other = (ClienteDBMB) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.codigo;
        return hash;
    }
    
    
    
}
