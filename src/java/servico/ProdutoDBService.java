/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import enumfiles.Moeda;
import modelo.Produto;
import modelo.ProdutoExterno;
import modelo.ProdutoInterno;

/**
 *
 * @author
 */
public class ProdutoDBService {
    
    private EntityManagerFactory emf;
    
    public ProdutoDBService (){
        emf = Persistence.createEntityManagerFactory("POOIIDB");
    }
    
    public List<Produto> getProdutos()
    {
        EntityManager em = emf.createEntityManager();
        List <Produto> produtos = em.createQuery("Select p From Produto p").getResultList();
        em.close();
        return produtos;
    }
    
    public Produto getProdutoByCodigo(int codigo)
    {
            EntityManager em = emf.createEntityManager();
            //Produto p = (Produto) em.find(Produto.class, codigo);
            Produto p = (Produto) em.createQuery("Select p From Produto p Where p.codigo = :prodCode").setParameter("prodCode", codigo).getSingleResult();
            em.close();
            System.out.println("servico.ProdutoDBService.getProdutoByCodigo()" + p.getCodigo());
            return p;
    }

    public String getOriginByCode(int codigo) {
        EntityManager em = emf.createEntityManager();
        //Produto p = (Produto) em.nativeQuery("Select p From Produto p Where p.codigo LIKE prodCode").setParameter("prodCode", codigo).getSingleResult();
        Produto p = (Produto) em.createQuery("Select p From Produto p Where p.codigo = :prodCode").setParameter("prodCode", codigo).getSingleResult();
        return p.getNome();
    }
    
    public boolean salvarAtualizar(ProdutoExterno prod) {
       if(validarProduto(prod)){
           EntityManager em = emf.createEntityManager();
           em.getTransaction().begin();
           em.merge(prod);       
           em.getTransaction().commit();
           em.close();
           return true;
       }
        return false;
    }
    
    private boolean validarProduto(ProdutoExterno prod) {
        return prod.getCategoria() != null &&
               prod.getPreco() != 0.0 &&
               prod.getNome() != null &&
               prod.getDestino() != null;
    }
    
    public boolean salvarAtualizar(ProdutoInterno prod) {
       if(validarProduto(prod)){
           EntityManager em = emf.createEntityManager();
           em.getTransaction().begin();
           em.merge(prod);       
           em.getTransaction().commit();
           em.close();
           return true;
       }
        return false;
    }
    
    private boolean validarProduto(ProdutoInterno prod) {
        return prod.getCategoria() != null &&
               prod.getPreco() != 0.0 &&
               prod.getNome() != null;
    }

    public void remover(Produto selectedProd) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.merge(selectedProd);
        em.remove(selectedProd);
        em.getTransaction().commit();
        em.close();
    }

    public Produto getProdutoByCodigo(String value) {
        EntityManager em = emf.createEntityManager();
        Produto p = em.find(Produto.class, value);
        em.close();
        return p;
    }
    
}
