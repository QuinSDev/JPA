package libreria.entidades;

import javax.persistence.*;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;
    private String title;
    private Integer age;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private Boolean high = true;
    
    @ManyToOne
    private Author author;
    
    @OneToOne
    private Editorial editorial;

    public Book() {
    }

    public Book(Long isbn, String title, Integer age, Integer copies, Integer borrowedCopies, Author author, Editorial editorial) {
        this.isbn = isbn;
        this.title = title;
        this.age = age;
        this.copies = copies;
        this.borrowedCopies = borrowedCopies;
        this.author = author;
        this.editorial = editorial;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getBorrowedCopies() {
        return borrowedCopies;
    }

    public void setBorrowedCopies(Integer borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
    }
    
    public Integer getRemaininCopies() {
        return remainingCopies;
    }
    
    public void setRemainingCopies(Integer remainingCopies) {
        this.remainingCopies = remainingCopies;
    }

    public Boolean getHigh() {
        return high;
    }

    public void setHigh(Boolean high) {
        this.high = high;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    
    
}
