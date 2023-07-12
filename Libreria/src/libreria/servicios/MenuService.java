package libreria.servicios;

import java.util.Scanner;

public class MenuService {
    
    Scanner read = new Scanner(System.in);
    int width = 50;
    AuthorService authorS = new AuthorService();
    int option = 0;
    
    public void welcome() {
        String welcome = "Welcome to Pages & Coffee";
        int padding = (width - welcome.length()) / 2;
        
        System.out.println("-*".repeat(width/2));
        staticMenu(padding,padding, welcome);
        System.out.println("\n"+"*-".repeat(width/2));
        
        menuMain();
    }
            
    public void menuMain() {
        
        
        String  menuMain = "Menu Main",
                authorMe = "1. Author menu",
                bookMen = "2. Book menu",
                exit = "3. Exit";
        
        int paddingM = (width - menuMain.length()) / 2;
        int paddinA = (width - authorMe.length()) / 2;
        int paddinB = (width - bookMen.length()) / 2;
        int paddinE = (width - exit.length()) / 2;
        
        
        
        
        do {
            try {
                System.out.println("\n"+"-".repeat(width));
                staticMenu(paddingM,paddingM, menuMain);
                System.out.println("\n" + "-".repeat(width));
                staticMenu(paddinA, (paddinA-1), authorMe);
                System.out.println("");
                staticMenu(paddinA, paddinB, bookMen);
                System.out.println("");
                staticMenu(paddinA, (paddinE+3), exit);
                System.out.println("\n" + "-".repeat(width));
                System.out.print("\nEnter the desired option: ");
                String op = read.nextLine();
                option = Integer.parseInt(op);
                optionsMenu(option);
                
            } catch (NumberFormatException e) {
                System.out.print("-".repeat(width));
                System.out.println("\nError! Enter a valid numeric value.");
                option = 0;
            }
            
            
        } while (option != 4);
        
    }
    
    public void authorMenu() {
        
        String authorEnter = "1. Enter an author into the database",
                authorModify = "2. Modify an author",
                authorDelete = "3. Delete an author from the database",
                authorSearch = "4. Search an author's name",
                exit = "5. Exit",
                authorMenu = "Author menu";
        
        int paddingAE = (width - authorEnter.length()) / 2;
        int paddingAM = (width - authorModify.length()) / 2;
        int paddingAD = (width - authorDelete.length()) / 2;
        int paddingAMe = (width - authorMenu.length()) / 2;
        int paddingAS = (width - authorSearch.length()) / 2;
        int paddinE = (width - exit.length()) / 2;
        
        do {
            try {
                System.out.println("\n"+"-".repeat(width));
                staticMenu(paddingAMe, paddingAMe, authorMenu);
                System.out.println("\n"+"-".repeat(width));
                staticMenu(paddingAE,(paddingAE-1), authorEnter);
                System.out.println("");
                staticMenu(paddingAE, (paddingAM+8), authorModify);
                System.out.println("");
                staticMenu(paddingAE, (paddingAD-1), authorDelete);
                System.out.println("");
                staticMenu(paddingAE, (paddingAS+4), authorSearch);
                System.out.println("");
                staticMenu(paddingAE, (paddinE+14), exit);
                System.out.println("\n" + "-".repeat(width));
                System.out.print("\nEnter the desired option: ");
                String op = read.nextLine();
                option = Integer.parseInt(op);
                optionsAuthor(option);
                
            } catch (NumberFormatException e) {
                System.out.print("-".repeat(width));
                System.out.println("\nError! Enter a valid numeric value.");
                option = 0;
            }
        } while (option != 5);
        
        
    }
    
    public void staticMenu(int paddin1,int paddin, String message) {
        
        System.out.format("|%" + paddin1 + "s%s%" + (paddin-1) + "s|", "",
                        message, "");
        
    }
    
    public void optionsMenu(int option) {
        
        switch(option) {
            case 1:
                authorMenu();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.print("-".repeat(width));
                System.out.println("\nInvalid option! Try again.");
        }
        
    }
    
    public void optionsAuthor(int option) {
        
        switch(option) {
            case 1:
                authorS.createAuthor();
                break;
            case 2:
                authorS.modifyAuthor();
                break;
            case 3:
                authorS.deleteAuthor();
                break;
            case 4:
                authorS.authorSearch();
                break;
            case 5:
                menuMain();
                break;
            default:
                System.out.print("-".repeat(width));
                System.out.println("\nInvalid option! Try again.");
        }
    }
    
}
