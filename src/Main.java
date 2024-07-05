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

    static void extendBooksArrayOnAddition(String newBookISBN, String newBookTitle, String newBookAuthor, String newBookAdditionalInformation) {

        String[][] newBooks = new String[books.length + 1][4];

        System.arraycopy(books, 0, newBooks, 0, books.length);
        newBooks[books.length][0] = newBookISBN;
        newBooks[books.length][1] = newBookTitle;
        newBooks[books.length][2] = newBookAuthor;
        newBooks[books.length][3] = newBookAdditionalInformation;

        books = newBooks;

        System.out.println("New book after 50th added to the array succesfully: ");

    }
}