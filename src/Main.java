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


}