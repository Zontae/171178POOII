/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Produto;

/**
 *
 * @author
 */
public class ProdutoDBService {
    
    private EntityManagerFactory emf;
    
    public ProdutoDBService (){
        emf = Persistence.createEntityManagerFactory("POOIIDB");
    }

    public void salvarAtualizar(Produto pro) {
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
            em.merge(pro);
       em.getTransaction().commit();
       em.close();    
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
            Produto p = em.find(Produto.class, codigo);
            em.close();
            System.out.println("servico.ProdutoDBService.getProdutoByCodigo()" + p.getCodigo());
            return p;
    }
    
}
