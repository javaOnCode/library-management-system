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

    }

    static void displayBookDetails() {
        Scanner scanner = new Scanner(System.in);

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
}