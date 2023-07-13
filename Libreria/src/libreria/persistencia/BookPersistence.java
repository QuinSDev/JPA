package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Book;

public class BookPersistence {

    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("LibreriaPU");
    private EntityManager em = emf.createEntityManager();

    Book book = null;

    public void conectBook() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }
    
    public void disconectNook() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    public void createBook(Book book) {
        conectBook();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        disconectNook();
    }
    
}
