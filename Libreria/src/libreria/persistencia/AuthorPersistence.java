package libreria.persistencia;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Author;

public class AuthorPersistence {
    
    Author author = null;
    
    public void createPersistence(String name) {
        
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU")
                .createEntityManager();
        
        try {
            author = new Author();
            
            if (author == null) {
                throw new NullPointerException("You must indicate an author!");
            }
            
            author.setNombre(name);
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
}
