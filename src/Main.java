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
}