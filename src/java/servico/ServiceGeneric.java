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

/**
 *
 * @author gabri
 * @param <T>
 */
public class ServiceGeneric <T> {
    
    private EntityManagerFactory emf;
    
    public ServiceGeneric (){
        emf = Persistence.createEntityManagerFactory("POOIIDB");
    }
    
    public void salvarAtualizar(T t) {
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
            em.merge(t);
       em.getTransaction().commit();
       em.close();    
    }
      
    public List<T> getList()
    {
        EntityManager em = emf.createEntityManager();
        //List <T> genericList = em.createQuery("Select g From Generic g").getResultList();
        em.close();
        return null;
    }
    
    public T getGenericByCodigo(int codigo, Class<T> tclass)
    {
            EntityManager em = emf.createEntityManager();
            T t = em.find(tclass, codigo);
            em.close();
            return t;
    }
    
}
