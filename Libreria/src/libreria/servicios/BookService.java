package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Author;
import libreria.entidades.Book;
import libreria.persistencia.BookPersistence;

public class BookService {

    Scanner read = new Scanner(System.in);
    BookPersistence bookP = new BookPersistence();
    AuthorService authorS = new AuthorService();
    Book book;
    Author author;

    public void createBook() {

        String isbn = "", name = "", age = "";

        do {

            try {
                book = new Book();
                System.out.print("\nEnter the book ISBN: ");
                isbn = read.nextLine();
                book.setIsbn(Long.parseLong(isbn));

                do {
                    try {
                        System.out.print("Enter the book's name: ");
                        name = read.nextLine();

                        if (name.isEmpty()) {
                            System.out.println("-".repeat(50));
                            throw new NullPointerException("You must indicate "
                                    + "a book name");
                        }
                        book.setTitle(name);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                } while (name.isEmpty());

                do {
                    try {
                        System.out.print("Enter the publication year of the book: ");
                        age = read.nextLine();

                        if (age.length() > 4 || age.length() < 4) {
                            System.out.println("-".repeat(50));
                            System.out.println("The provided year is"
                                    + " incorrect!");
                        } else {
                            book.setAge(Integer.parseInt(age));
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("-".repeat(50));
                        System.out.println("You must enter a correct year!");
                    }
                    
                } while (book.getAge() == null);

                do {
                    try {
                        System.out.print("Enter the number of copies: ");
                        String number = read.nextLine();
                        book.setCopies(Integer.parseInt(number));

                        System.out.print("Enter the number of borrowed copies: ");
                        String copiesB = read.nextLine();
                        book.setBorrowedCopies(Integer.parseInt(copiesB));

                        book.setRemainingCopies(book.getCopies()
                                - book.getBorrowedCopies());

                        author = authorS.createAuthor();
                        book.setAuthor(author);
                        bookP.createBook(book);

                    } catch (NumberFormatException e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Enter a valid numeric value!");
                    }
                    
                } while (book.getCopies() == null);

            } catch (IllegalArgumentException e) {
                System.out.println("-".repeat(50));
                System.out.println("Enter a valid ISBN!");
            }

        } while (book.getIsbn() == null);

    }

}
