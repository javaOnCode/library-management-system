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

    static void updatePatronInfo(String newID, String newUserName, String newEmail, String newPassword){

        System.out.print("\nPlease enter the name of the user you would like to update: ");
        String userNameForUpdate = scanner.nextLine();
        System.out.print("Please enter the ID of the user you would like to update: ");
        String IDForUpdate = scanner.nextLine();

        boolean userFound = false;

        for(int i = 0; i < userQuantity; i++){
            if(users[i][0].equals(IDForUpdate) && users[i][1].equals(userNameForUpdate)){
                userFound = true;

                users[i][0] = newID;
                users[i][1] = newUserName;
                users[i][2] = newEmail;
                users[i][3] = newPassword;

                System.out.println("\nUser updated succesfully.");
            }
        }
        if(!userFound){
            System.out.println("\nOops, user with these credentials is not found.");
            System.exit(404);
        }
    }

}