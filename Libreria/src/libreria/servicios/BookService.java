package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Author;
import libreria.entidades.Book;
import libreria.entidades.Editorial;
import libreria.persistencia.BookPersistence;

public class BookService {

    Scanner read = new Scanner(System.in);
    BookPersistence bookP = new BookPersistence();
    AuthorService authorS = new AuthorService();
    EditorialService editorialS = new EditorialService();
    Book book;
    Author author;
    Editorial editorial;

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
                        editorial = editorialS.createEditorial();
                        book.setAuthor(author);
                        book.setEditorial(editorial);
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

    public void inactiveBook() {

        do {
            try {
                System.out.print("Enter the ISBN of the book: ");
                String isbn = read.nextLine();
                Long isb = Long.parseLong(isbn);

                book = bookP.findBook(isb);

                book.setHigh(false);

                bookP.createBook(book);

            } catch (NumberFormatException e) {
                System.out.println("-".repeat(50));
                System.out.println("Enter a valid a numeric value");
            }

        } while (book.getIsbn() == null);

    }

    public void modifyName() {

        String name = "", isbn = "";
        Long isb = null;

        do {
            try {
                System.out.print("\nEnter the ISBN of the book: ");
                isbn = read.nextLine();
                isb = Long.parseLong(isbn);

                try {
                    book = bookP.findBook(isb);

                    if (book == null) {
                        System.out.println("-".repeat(50));
                        throw new NullPointerException("The book with the "
                                + "specified ISBN doesn't exist!");
                    }

                    do {
                        try {
                            System.out.print("Enter a book's name: ");
                            name = read.nextLine();

                            if (name.isEmpty()) {
                                System.out.println("-".repeat(50));
                                throw new NullPointerException("You must "
                                        + "indicate a book name!\n");
                            }

                            book.setTitle(name);
                            bookP.updateBook(book);
                        } catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (name.isEmpty());
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }

            } catch (NullPointerException e) {
                System.out.println("-".repeat(50));
                System.out.println("Enter a valid numeric value!");
            }
        } while (isb == null || book == null);

    }

    public void modifyAgePublication() {

        String isbn = "", age = "";
        Long isb = null;
        Integer ages = null;

        do {
            try {
                System.out.print("\nEnter the ISBN of the book: ");
                isbn = read.nextLine();
                isb = Long.parseLong(isbn);

                try {
                    book = bookP.findBook(isb);

                    if (book == null) {
                        System.out.println("-".repeat(50));
                        throw new NullPointerException("The book with the "
                                + "specified ISBN doesn't exist!");
                    }

                    do {
                        try {
                            System.out.print("Enter the publication year of the"
                                    + " book: ");
                            age = read.nextLine();

                            if (age.length() > 4 || age.length() < 4) {
                                System.out.println("-".repeat(50));
                                System.out.println("The provided year is"
                                        + " incorrect!\n");
                            } else {
                                ages = Integer.parseInt(age);
                                book.setAge(ages);
                                bookP.updateBook(book);
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("-".repeat(50));
                            System.out.println("You must enter a correct year!");
                        }

                    } while (ages == null);

                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }

            } catch (NumberFormatException e) {
                System.out.println("-".repeat(50));
                System.out.println("Enter a valid numeric value!");
            }
        } while (isb == null || book == null);

    }

    public void updateCopies() {

        String isbn = "", copie = "";
        Long isb = null;
        Integer copies = null;

        do {
            try {
                System.out.print("\nEnter the ISBN of the book: ");
                isbn = read.nextLine();
                isb = Long.parseLong(isbn);

                try {
                    book = bookP.findBook(isb);

                    if (book == null) {
                        System.out.println("-".repeat(50));
                        throw new NullPointerException("The book with the "
                                + "specified ISBN doesn't exist!");
                    }

                    do {
                        try {
                            
                            System.out.print("Enter the number of copies: ");
                            copie = read.nextLine();
                            copies = Integer.parseInt(copie);
                            
                            book.setCopies(book.getCopies() + copies);
                            bookP.updateBook(book);
                            
                        } catch (NumberFormatException e) {
                            System.out.println("-".repeat(50));
                            System.out.println("Enter a valid numeric value");
                        }
                    } while (copies == null);

                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }

            } catch (NumberFormatException e) {
                System.out.println("-".repeat(50));
                System.out.println("Enter a valid numeric value!");
            }
        } while (isb == null || book == null);

    }

}
