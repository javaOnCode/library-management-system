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

    static void viewAvailableBooks() {
        boolean bookFound = false;

        if (bookQuantity != 0) {
            bookFound = true;
            System.out.println("Here is the list of all available books in the library  ->");

            for (int i = 0; i < bookQuantity; i++) {

                System.out.println("\nBook " + (i + 1) + ":");
                System.out.println("Title: " + books[i][1]);
                System.out.println("ISBN: " + books[i][0]);
                System.out.println("Author: " + books[i][2]);
                System.out.println("Additional Information: " + books[i][3]);
            }
        }
        if (!bookFound) {
            System.out.println("Oops, sth wrong happened while finding books.");
        }
    }
}