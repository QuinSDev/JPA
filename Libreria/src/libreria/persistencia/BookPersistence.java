package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Book;

public class BookPersistence {

    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("LibreriaPU");
    private EntityManager em = emf.createEntityManager();
    Book books = null;
    
    public void conectBook() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }
    
    public void disconectBook() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    public void createBook(Book book) {
        conectBook();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        disconectBook();
    }
        
    
    public Book findBook(Long book){
        conectBook();
        try {
            books = em.find(Book.class, book);
            
            if (books == null) {
                System.out.println("-".repeat(50));
                throw new NullPointerException("You must indicate a book!");
            }
            
            return books;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
}
