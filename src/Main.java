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
//        addBook("978-0061120084", "To Kill a Mockingbird", "Harper Lee", "Classic American novel");
//        addBook("978-0451524935", "1984", "George Orwell", "Dystopian political fiction");
//        addBook("978-0743273565", "The Great Gatsby", "F. Scott Fitzgerald", "Roaring twenties tragedy");
//
//
//        System.out.println("\nAvailable Book Quantity: " + bookQuantity + "\n");
//
//        for (int i = 0; i < bookQuantity; i++) {
//            System.out.println("Book " + (i + 1) + ": ");
//            System.out.println("Title: " + books[i][1]);
//            System.out.println("ISBN: " + books[i][0]);
//            System.out.println("Author: " + books[i][2]);
//            System.out.println("Additional Information: " + books[i][3] + "\n");
//        }
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