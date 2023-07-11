package libreria.servicios;

import java.util.Scanner;

public class MenuService {
    
    Scanner read = new Scanner(System.in);
    int width = 50;
    AuthorService authorS = new AuthorService();
            
    public void menuMain() {
        
        int option = 0;
        String welcome = "Welcome to Pages & Coffee",
                menuMain = "Menu Main",
                authorEnter = "1. Enter an author into the database",
                authorModify = "2. Modify an author",
                authorDelete = "3. Delete an author from the database",
                exit = "4. Exit";
        
        int padding = (width - welcome.length()) / 2;
        int paddingM = (width - menuMain.length()) / 2;
        int paddingAE = (width - authorEnter.length()) / 2;
        int paddingAM = (width - authorModify.length()) / 2;
        int paddingAD = (width - authorDelete.length()) / 2;
        int paddinE = (width - exit.length()) / 2;
        
        System.out.println("-*".repeat(width/2));
        staticMenu(padding,padding, welcome);
        System.out.println("\n"+"*-".repeat(width/2));
        
        do {
            try {
                System.out.println("\n"+"-".repeat(width));
                staticMenu(paddingM,paddingM, menuMain);
                System.out.println("\n" + "-".repeat(width));
                staticMenu(paddingAE,(paddingAE-1), authorEnter);
                System.out.println("");
                staticMenu(paddingAE, (paddingAM+8), authorModify);
                System.out.println("");
                staticMenu(paddingAE, (paddingAD-1), authorDelete);
                System.out.println("");
                staticMenu(paddingAE, (paddinE+14), exit);
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
    
    public void staticMenu(int paddin1,int paddin, String message) {
        
        System.out.format("|%" + paddin1 + "s%s%" + (paddin-1) + "s|", "",
                        message, "");
        
    }
    
    public void optionsMenu(int option) {
        
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
                break;
            default:
                System.out.print("-".repeat(width));
                System.out.println("\nInvalid option! Try again.");
        }
        
    }
    
}
