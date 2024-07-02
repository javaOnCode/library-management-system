import java.util.Scanner;

public class Main {

    static int INDEX = 50;
    static String[][] books = new String[INDEX][4]; // ISBN - Title - Author - Additional Information
    static String[][] users = new String[INDEX][4]; // Identity Number - Name - Email - Password
    static String[][] transactions = new String[INDEX][3];// ISBN - User Id - Date
    static int bookQuantity = 0;
    static int userQuantity = 0;
    static int transactionQuantity = 0;


    public static void main(String[] args) {


        displayBookDetails();
    }
    // for displaying book details - get ISBN and title.
    // show details to the user.

    static void displayBookDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the title of the book that you're interested for detailed information: ");
        String title = scanner.nextLine();

        for (int i = 0; i < books.length; i++) {
            if (books[i][1] != title) {
                System.out.println("Oops, Book Not Found!");
                break;
            } else {
                System.out.println("ISBN: " + books[i][0]);
                System.out.println("Title: " + title);
                System.out.println("Author: " + books[i][2]);
                System.out.println("Additional Information: " + books[i][3]);

            }
        }
    }
}