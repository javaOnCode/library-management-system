import org.w3c.dom.ls.LSOutput;

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

    static int countTotalBooks() {
        if (bookQuantity != 0) {
            System.out.println("\nTotal Book Quantity in the library: " + bookQuantity);
            return bookQuantity;
        } else {
            System.out.println("\nThere is no book in the library.");
            return 0;
        }
    }
}