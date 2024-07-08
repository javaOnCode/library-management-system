import org.w3c.dom.ls.LSOutput;
import java.util.Scanner;


public class Main {

    static int INDEX = 50;
    static String[][] books = new String[INDEX][4]; // ISBN - Title - Author - Additional Information
    static String[][] users = new String[INDEX][4]; // Identity Number - Name - Email - Password
    static String[][] transactions = new String[INDEX][3];// ISBN - User Id - Date
    static int bookQuantity = 0;
    static int userQuantity = 0;
    static int transactionQuantity = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }



    static int countTotalBooks() {
        if (bookQuantity != 0) {
            System.out.println("\nTotal Book Quantity in the library: " + bookQuantity);
            return bookQuantity;
        } else {
            System.out.println("\nThere is no book in the library.");
            return 0;
        }
    }


    static void viewAvailableBooks() {
        boolean bookFound = false;

        if (bookQuantity != 0) {
            bookFound = true;
            System.out.println("\nHere is the list of all available books in the library  ->\n");

            for (int i = 0; i < bookQuantity; i++) {
                System.out.print("Book " + (i + 1) + ": ");
                System.out.println(books[i][1]);
            }
        }
        if (!bookFound) {
            System.out.println("Oops, sth wrong happened while finding books.");
        }
    }
  
  
    static void displayBookDetails() {

        System.out.print("\nEnter the title of the book that you're interested for detailed information: ");
        String bookTitle = scanner.nextLine();

        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][1].equals(bookTitle)) {
                System.out.println("\nHere is your desired book ->");
                System.out.println("Title: " + books[i][1]);
                System.out.println("ISBN: " + books[i][0]);
                System.out.println("Author: " + books[i][2]);
                System.out.println("Additional Information: " + books[i][3]);
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Oops, Book Not Found!");
        }
    }
  
  

    static void removeBook(String ISBN, String bookName) {
        if (bookQuantity == 0) {
            System.out.println("There is no book in the library.");

        }

        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if(books[i][0].equals(ISBN) && books[i][1].equals(bookName)){
                bookFound = true;

                for(int j = i; j < bookQuantity - 1; j++){
                    books[j] = books[j + 1];
                }

                books[bookQuantity - 1] = null;
                bookQuantity--;
                System.out.printf("\"%s\" - book with this specific name and \"%s\" ISBN is deleted from the library succesfully.\n", bookName,ISBN);
                break;
            }
        }

        if(!bookFound){
            System.out.println("Book Not Found!");
        }
    }
  

    static void addBook(String ISBN, String title, String author, String additionalInformation) {
        if (bookQuantity < INDEX) {
            books[bookQuantity][0] = ISBN;
            books[bookQuantity][1] = title;
            books[bookQuantity][2] = author;
            books[bookQuantity][3] = additionalInformation;

            bookQuantity++;
        } else {
            System.out.println("\nOur shelves are full, so that we can't add the new one...");
        }

    }
  
  
    static void deleteUserInformation(String userName, String ID){
        if(userQuantity == 0){
            System.out.println("\nThere is no user registered on the system.");
        }

        boolean userFound = false;

        for(int i = 0; i < userQuantity; i++){
            if(users[i][0] == userName && users[i][1] == ID){
                userFound = true;
            }

            for(int j = i; j < userQuantity - 1; j++){
                users[j] = users[j + 1];
            }

            users[userQuantity - 1] = null;
            userQuantity--;
            System.out.printf("\n\"%s\" - user with the given name and \"%s\" - ID is deleted from the system.", userName, ID);
            break;
        }

        if(!userFound){
            System.out.println("\nOops, user not found.");
        }
    }
  
  
    static void updateBook(String newISBN, String newTitle, String newAuthor, String newInfo) {

        System.out.print("\nPlease enter the title of the book you would like to update here: ");
        String bookTitleForUpdate = scanner.nextLine();
        System.out.print("Please enter the ISBN of the book you would like to update here: ");
        String bookISBNForUpdate = scanner.nextLine();

        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(bookISBNForUpdate) && books[i][1].equals(bookTitleForUpdate)) {
                bookFound = true;

                books[i][0] = newISBN;
                books[i][1] = newTitle;
                books[i][2] = newAuthor;
                books[i][3] = newInfo;

                System.out.println("Book succesfully updated.");
            }
        }
        if(!bookFound){
            System.out.println("Such book is not available in the library.");
        }
    }

}