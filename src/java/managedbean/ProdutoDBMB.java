/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Produto;
import servico.ProdutoDBService;

/**
 *
 * @author gabri
 */
@ManagedBean
@SessionScoped
public class ProdutoDBMB {
    
    private ProdutoDBService produtodbservice = new ProdutoDBService();
    private Produto prod = new Produto();
    private int codigo;
    private int from;

    public ProdutoDBMB(){
    }
    
    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
    
    public void salvar(){
        produtodbservice.salvarAtualizar(prod);
        prod = new Produto();
    }
    
    public List<Produto> getProdutos(){
        return produtodbservice.getProdutos();
    }
    
    public void pesquisarProduto(){
        prod = produtodbservice.getProdutoByCodigo(codigo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigo;
        return hash;
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
        final ProdutoDBMB other = (ProdutoDBMB) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    
}
