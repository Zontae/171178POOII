/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import enumfiles.ProdutoEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Produto;
import modelo.ProdutoExterno;
import modelo.ProdutoInterno;
import org.primefaces.event.RowEditEvent;
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
    private Produto selectedProd;
    private int codigo;
    private int from;
    private String mercado;
    private String destino;
    private boolean incentivo;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public Produto getSelectedProd() {
        return selectedProd;
    }

    public void setSelectProd(Produto selectProd) {
        this.selectedProd = selectProd;
    }
    
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
        if(mercado == "interno"){
        ProdutoInterno aux = new ProdutoInterno(prod, incentivo);
        if(produtodbservice.salvarAtualizar(aux))
        {
            FacesMessage msg = new FacesMessage("Produto salvo com sucesso!","");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }
        else
        {
            FacesMessage msg = new FacesMessage("Produto não salvo!","Revise os atributos");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }
    }
        else{
            ProdutoExterno aux = new ProdutoExterno(prod, destino);
            produtodbservice.salvarAtualizar(aux);
            this.destino = "";
        }
        this.prod = new Produto();
        
    }
        
    
    public List<Produto> getProdutos(){
        return produtodbservice.getProdutos();
    }
    
    public void pesquisarProduto(){
        prod = produtodbservice.getProdutoByCodigo(codigo);
    }
    
    public String produtoPorCodigo (int codigo){
       return produtodbservice.getOriginByCode(codigo);
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
    
    public void onRowEdit(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Produto Alterado", ((Produto) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.prod = (Produto) event.getObject();
        salvar();
    }
    
    public void deletar(){
        produtodbservice.remover(selectedProd);
        selectedProd = null;
    }
    
    public ProdutoEnum salvarTest(){
        if(prod != null){
            if(!validarProduto())
                return ProdutoEnum.ERRO;
            else{
                return ProdutoEnum.OK;
            }
        }
        return ProdutoEnum.NULL;
    }

    private boolean validarProduto() {
        return prod.getNome() != null &&
               prod.getPreco() != 0.0 &&
               prod.getCategoria() != null;
    }
}
