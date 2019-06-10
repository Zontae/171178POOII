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

    public void salvarAtualizar(Produto prod, int i) {
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       if(i==1){ 
           ProdutoExterno prode = (ProdutoExterno) prod;
           em.merge(prode);
       }
       else{
           ProdutoInterno prodi = (ProdutoInterno) prod;
           em.merge(prodi);
       }
       em.getTransaction().commit();
       em.close();
    }
    
}
