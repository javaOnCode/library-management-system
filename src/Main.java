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