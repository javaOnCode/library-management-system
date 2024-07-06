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


    public static void main(String[] args) {

    }

    static void deleteUserInformation(String userName, String ID){
        if(userQuantity == 0){
            System.out.println("\nThere is no user registered on the system.");
        }

        boolean userFound = false;

        for(int i = 0; i < userQuantity; i++){
            if(users[i][0] == userName && users[i][1] == ID){
                userFound = true;
            }

            for(int j = i; j < userQuantity - 1; j++){
                users[j] = users[j + 1];
            }

            users[userQuantity - 1] = null;
            userQuantity--;
            System.out.printf("\n\"%s\" - user with the given name and \"%s\" - ID is deleted from the system.", userName, ID);
            break;
        }

        if(!userFound){
            System.out.println("\nOops, user not found.");
        }
    }
}