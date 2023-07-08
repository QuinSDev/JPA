package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import libreria.entidades.Author;

public class AuthorPersistence {
    
    @PersistenceContext(unitName = "LibreriaPU")
    private EntityManager em;
    Author author = null;
    
    public void createPersistence(String name) {
        
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
