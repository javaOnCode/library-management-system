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
}