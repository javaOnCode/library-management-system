import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static int INDEX = 50;
    static String[][] books = new String[INDEX][4]; // ISBN - Title - Author - Additional Information
    static String[][] users = new String[INDEX][4]; // Identity Number - Name - Email - Password
    static String[][] transactions = new String[INDEX][3];// ISBN - User Id - Date
    static int bookQuantity = 0;
    static int userQuantity = 0;
    static int transactionQuantity = 0;
    static Scanner scanner = new Scanner(System.in);
    static LocalDate currentDate = LocalDate.now();
    static DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        System.out.print("Do you have active subscription on our library? (y/n): ");
        String ans = scanner.nextLine();

        if(ans.equals("y")){
            Boolean isLogin = login();
            while (true) {
                if (isLogin) {
                    showMenu();
                } else {
                    System.out.println("Please try to login again");
                    login();
                }
            }
        }
        else{
            System.out.println("Let's create an account.");
            System.out.print("Please enter your ID: ");
            String idForRegistration = scanner.nextLine();

            System.out.print("Enter your name: ");
            String nameForRegistration = scanner.nextLine();

            System.out.print("Enter your email: ");
            String mailForRegistration = scanner.nextLine();

            System.out.print("Enter password: ");
            String passwordForRegistration = scanner.nextLine();


            createUser(idForRegistration, nameForRegistration, mailForRegistration, passwordForRegistration);

            while(true){
                showMenu();
            }
        }






    }

    static void showMenu() {
        System.out.println("\nWelcome to our Library!");
        System.out.println("Please choose the operation you would like to implement due to its index.");
        System.out.println("\n1. Register new user");
        System.out.println("2. Login");
        System.out.println("3. Checkout Book");
        System.out.println("4. Return Book");
        System.out.println("5. Reserve Book");
        System.out.println("6. Request New Book");
        System.out.println("7. Update Book Information");
        System.out.println("8. Add Book to the library");
        System.out.println("9. Remove book from the library");
        System.out.println("10. View Available Books");
        System.out.println("11. Display book details");
        System.out.println("12. Count Total Books");
        System.out.println("13. Generate Book Recommendations");
        System.out.println("14. Generate Reports(books,users,transactions)");
        System.out.println("15. Delete User Information");
        System.out.println("16. Update Patron Information");
        System.out.println("17. Check Book Eligibility");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice here: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter user ID: ");
                String IDForRegister = scanner.nextLine();
                System.out.print("Enter user name: ");
                String userNameForRegister = scanner.nextLine();
                System.out.print("Enter email: ");
                String emailForRegister = scanner.nextLine();
                System.out.print("Enter password: ");
                String passwordForRegister = scanner.nextLine();

                createUser(IDForRegister, userNameForRegister, emailForRegister, passwordForRegister);
                break;
            case 2:
                login();
                break;

            case 3:
                System.out.print("Enter the ISBN of the book you would like to check out: ");
                String ISBNforCheckout = scanner.nextLine();

                System.out.print("Enter user ID: ");
                String IDforCheckout = scanner.nextLine();

                checkOutBook(ISBNforCheckout, IDforCheckout);

                break;
            case 4:
                System.out.print("Enter the ISBN of the book you would like to return: ");
                String ISBNForReturn = scanner.nextLine();

                System.out.print("Enter user ID: ");
                String IDForReturn = scanner.nextLine();

                returnBook(ISBNForReturn, IDForReturn);
                break;
            case 5:
                System.out.print("Enter the ISBN of the book you would like to reserve: ");
                String ISBNForReserve = scanner.nextLine();

                System.out.print("Enter user ID: ");
                String IDForReserve = scanner.nextLine();

                System.out.print("Enter reservation duration: ");
                int reservationDurationForReserve = scanner.nextInt();
                scanner.nextLine();

                reserveBook(ISBNForReserve, IDForReserve, reservationDurationForReserve);
                break;
            case 6:
                System.out.print("Enter the ISBN of the book you would like to request: ");
                String ISBNForRequest = scanner.nextLine();
                System.out.print("Enter user ID: ");
                String IDForRequest = scanner.nextLine();

                requestBook(ISBNForRequest, IDForRequest);
                break;
            case 7:
                System.out.print("Enter new ISBN for update: ");
                String ISBNForUpdate = scanner.nextLine();

                System.out.print("Enter new title for update: ");
                String titleForUpdate = scanner.nextLine();

                System.out.print("Enter new Author for update: ");
                String authorForUpdate = scanner.nextLine();

                System.out.print("Enter new Additional Information for update: ");
                String additionalInfoForUpdate = scanner.nextLine();


                updateBook(ISBNForUpdate, titleForUpdate, authorForUpdate, additionalInfoForUpdate);
                break;

            case 8:
                System.out.print("Enter ISBN for adding to the library: ");
                String ISBNForAddition = scanner.nextLine();

                System.out.print("Enter title of the book:  ");
                String titleForAddition = scanner.nextLine();

                System.out.print("Enter author of the book: ");
                String authorForAddition = scanner.nextLine();

                System.out.print("Enter information about the book: ");
                String infoForAddition = scanner.nextLine();

                addBook(ISBNForAddition, titleForAddition, authorForAddition, infoForAddition);
                break;

            case 9:
                System.out.print("Enter ISBN for removing book: ");
                String ISBNForRemoving = scanner.nextLine();

                removeBook(ISBNForRemoving);
                break;

            case 10:
                viewAvailableBooks();
                break;

            case 11:
                displayBookDetails();
                break;

            case 12:
                countTotalBooks();
                break;

            case 13:
                System.out.print("Enter user ID for book recommendation: ");
                String IDForRecommendation = scanner.nextLine();

                generateBookRecommendations(IDForRecommendation);
                break;

            case 14:
                System.out.print("Which of these would you like to generate? - books, users, transactions: ");
                String valueForGeneration = scanner.nextLine();

                generateReports(valueForGeneration);
                break;

            case 15:
                System.out.print("Enter user ID for deleting from the system: ");
                String IDForDeletion = scanner.nextLine();

                deleteUserInformation(IDForDeletion);
                break;

            case 16:
                System.out.print("Enter new user ID for updating an existing user: ");
                String userIDForUpdate = scanner.nextLine();

                System.out.print("Enter new userName: ");
                String userNameForUpdate = scanner.nextLine();

                System.out.print("Enter new email address: ");
                String emailForUpdate = scanner.nextLine();

                System.out.print("Enter new password: ");
                String passwordForUpdate = scanner.nextLine();

                updatePatronInfo(userIDForUpdate, userNameForUpdate, emailForUpdate, passwordForUpdate);
                break;
            case 17:
                System.out.print("Enter user ID for book eligibility: ");
                String IDForEligibility = scanner.nextLine();

                checkPatronEligibilityForCheckout(IDForEligibility);
            case 0:
                System.out.println("Exiting the system.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                showMenu();
        }
    }

    static void createUser(String id, String name, String email, String password) {
        if (userQuantity < INDEX) {
            users[userQuantity][0] = id;
            users[userQuantity][1] = name;
            users[userQuantity][2] = email;
            users[userQuantity][3] = password;
            userQuantity++;

            System.out.println("User created successfully.");
        } else {
            System.out.println("\nUser array is full, cannot add more users.");
        }
    }

    static boolean login() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < userQuantity; i++) {
            if (users[i][2].equals(email) && users[i][3].equals(password)) {
                System.out.println("Login successful. Welcome, " + users[i][1] + "!");
                return true;
            }
        }
        System.out.println("Login failed. Invalid email or password.");
        return false;
    }


    static long checkBookReturnDeadline(String userID) {
        String tempBorrowDate = "";
        for (int i = 0; i < transactionQuantity; i++) {
            if (userID == transactions[i][1]) {
                tempBorrowDate = transactions[i][2];
            }
        }
        LocalDate borrowDate = LocalDate.parse(tempBorrowDate, formattedDate);
        long dayCount = ChronoUnit.DAYS.between(borrowDate, currentDate);

        return dayCount;
    }

    static void checkPatronEligibilityForCheckout(String userID) {
        long dayCount = checkBookReturnDeadline(userID);

        if (dayCount > 5) {
            System.out.println("You did not return your borrowed book in time");
            System.out.println("You can not get another book!");
            System.out.println("Return your book in time please");
        } else {
            System.out.println("You can get a new book");
            System.out.println("Here are our books");
            viewAvailableBooks();
        }
    }


    static void searchBooks(String input, String bookTitle, String bookAuthor, String bookISBN) {
        if (input.toLowerCase().equals("title")) {
            for (int i = 0; i < bookQuantity; i++) {
                if (books[i][1].equals(bookTitle)) {
                    System.out.println("Here is the book you are looking for : ");
                    for (int j = 0; j < 4; j++) {
                        System.out.print("\n" + books[i][j]);
                    }
                }
            }
        } else if (input.toLowerCase().equals("author")) {
            for (int i = 0; i < bookQuantity; i++) {
                if (books[i][2].equals(bookAuthor)) {
                    System.out.println("Here is the book you are looking for : ");
                    for (int j = 0; j < 4; j++) {
                        System.out.print("\n" + books[i][j]);
                    }
                }
            }
        } else if (input.toUpperCase().equals("ISBN") || input.toUpperCase().equals("İSBN")) {
            for (int i = 0; i < bookQuantity; i++) {
                if (books[i][0].equals(bookISBN)) {
                    System.out.println("Here is the book you are looking for : ");
                    for (int j = 0; j < 4; j++) {
                        System.out.print("\n" + books[i][j]);
                    }
                }
            }
        } else {
            System.out.println("We cannot find any books with this method, please try again.");
        }
    }

    static void generateBookRecommendations(String userID) {
        String lastBookISBN = null;
        String lastBookAuthor = null;

        for (int i = 0; i < transactionQuantity; i++) {
            if (transactions[i][1].equals(userID)) {
                lastBookISBN = transactions[i][0];
                break;
            }
        }
        if (lastBookISBN != null) {
            for (int i = 0; i < bookQuantity; i++) {
                lastBookAuthor = books[i][2];
                break;
            }
        }
        if (lastBookAuthor != null) {
            for (int i = 0; i < bookQuantity; i++) {
                if (books[i][2].equals(lastBookAuthor) && !books[i][0].equals(lastBookISBN)) {
                    System.out.println("Recommended book: " + books[i][1] + " Author: " + books[i][2]);
                    return;
                }
            }
        }


        Random random = new Random();
        int randomIndex = random.nextInt(bookQuantity);
        System.out.println("Recommended book: " + books[randomIndex][1] + " Author: " + books[randomIndex][2]);


    }

    static boolean isBookAvailable(String ISBN) {
        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(ISBN)) {
                return true;
            }
        }
        return false;
    }

    static boolean isBookAvailableForReturning(String ISBN) {
        for (int i = 0; i < transactionQuantity; i++) {
            if (transactions[i][0].equals(ISBN)) {
                return true;
            }
        }
        return false;
    }

    static void extendBooksArrayOnAddition(String newBookISBN, String newBookTitle, String newBookAuthor, String newBookAdditionalInformation) {

        String[][] additionalBooks = new String[books.length + 1][4];

        System.arraycopy(books, 0, additionalBooks, 0, books.length);
        additionalBooks[books.length][0] = newBookISBN;
        additionalBooks[books.length][1] = newBookTitle;
        additionalBooks[books.length][2] = newBookAuthor;
        additionalBooks[books.length][3] = newBookAdditionalInformation;

        bookQuantity++;
        books = additionalBooks;

    }

    static void returnBook(String bookISBN, String userID) {
        Boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(bookISBN)) {
                System.out.println("This book has already been returned");
                bookFound = true;
            }
        }
        if (!bookFound) {
            LocalDate returnDate = LocalDate.now();

            transactions[transactionQuantity][0] = bookISBN;
            transactions[transactionQuantity][1] = userID;
            transactions[transactionQuantity][2] = returnDate.toString();
            transactionQuantity++;


            System.out.print("Enter the book name you would like to add: ");
            String bookName = scanner.nextLine();

            System.out.print("Enter the book author you would like to add: ");
            String bookAuthor = scanner.nextLine();

            System.out.print("Enter the book name you would like to add: ");
            String bookINFO = scanner.nextLine();
            succesfullTransactionInfo("returnBook");

            addBook(bookISBN, bookName, bookAuthor, bookINFO);
        }
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


    static void displayBookDetails() {

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


    static void removeBook(String ISBN) {
        if (bookQuantity == 0) {
            System.out.println("There is no book in the library.");
        }

        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(ISBN)) {
                bookFound = true;

                for (int j = i; j < bookQuantity - 1; j++) {
                    books[j] = books[j + 1];
                }

                books[bookQuantity - 1] = null;
                bookQuantity--;
                truncateBooksArrayOnDeletion(ISBN);
                succesfullTransactionInfo("removeBook");
                System.out.printf("\"%s\" - book with specific ISBN is deleted from the library.\n", ISBN);
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book Not Found!");
        }
    }


    static void addBook(String ISBN, String title, String author, String additionalInformation) {
        if (bookQuantity < INDEX) {
            books[bookQuantity][0] = ISBN;
            books[bookQuantity][1] = title;
            books[bookQuantity][2] = author;
            books[bookQuantity][3] = additionalInformation;

            bookQuantity++;
            succesfullTransactionInfo("addBook");
        } else {
            extendBooksArrayOnAddition(ISBN, title, author, additionalInformation);
        }

    }

    static void checkOutBook(String ISBN, String userID) {

        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equalsIgnoreCase(ISBN)) {
                bookFound = true;

                transactions[transactionQuantity][0] = books[i][0];
                transactions[transactionQuantity][1] = userID;
                transactions[transactionQuantity][2] = currentDate.toString();
                transactionQuantity++;

                removeBook(books[i][0]);

                System.out.println(userID + ", you have successfully checked out the book \"" + ISBN + "\".");
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book \"" + ISBN + "\" not found in the library.");
        }
    }


    static void deleteUserInformation(String ID) {
        if (userQuantity == 0) {
            System.out.println("\nThere is no user registered on the system.");
        }

        boolean userFound = false;

        for (int i = 0; i < userQuantity; i++) {
            if (users[i][0].equals(ID)) {
                userFound = true;
            }

            for (int j = i; j < userQuantity - 1; j++) {
                users[j] = users[j + 1];
            }

            users[userQuantity - 1] = null;
            userQuantity--;
            succesfullTransactionInfo("deleteUser");
            System.out.printf("\n\"%s\" - user with the given ID is deleted from the system.", ID);
            break;
        }

        if (!userFound) {
            System.out.println("\nOops, user not found.");
        }
    }


    static void updateBook(String newISBN, String newTitle, String newAuthor, String newInfo) {

        System.out.print("Please enter the ISBN of the book you would like to update here: ");
        String bookISBNForUpdate = scanner.nextLine();

        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(bookISBNForUpdate)) {
                bookFound = true;

                books[i][0] = newISBN;
                books[i][1] = newTitle;
                books[i][2] = newAuthor;
                books[i][3] = newInfo;

                succesfullTransactionInfo("updateBook");
            }
        }
        if (!bookFound) {
            System.out.println("Such book is not available in the library.");
        }
    }

    static void updatePatronInfo(String newID, String newUserName, String newEmail, String newPassword) {

        System.out.print("Please enter the ID of the user you would like to update: ");
        String IDForUpdate = scanner.nextLine();

        boolean userFound = false;

        for (int i = 0; i < userQuantity; i++) {
            if (users[i][0].equals(IDForUpdate)) {
                userFound = true;

                users[i][0] = newID;
                users[i][1] = newUserName;
                users[i][2] = newEmail;
                users[i][3] = newPassword;

                succesfullTransactionInfo("updateUser");
            }
        }
        if (!userFound) {
            System.out.println("\nOops, user with these credentials is not found.");
        }
    }

    static void initialArrays() {
        countTotalBooks();
        for (int i = 0; i < bookQuantity; i++) {
            System.out.println("\nTitle: " + books[i][1]);
            System.out.println("ISBN: " + books[i][0]);
            System.out.println("Author: " + books[i][2]);
            System.out.println("Additional Information: " + books[i][3]);
        }

        System.out.println("\nUsers actively registered on the system: " + userQuantity);
        for (int i = 0; i < userQuantity; i++) {
            System.out.println("\nName: " + users[i][1]);
            System.out.println("ID Number: " + users[i][0]);
            System.out.println("Email: " + users[i][2]);
        }

        System.out.println("\nCurrently active transactions on the system: " + transactionQuantity);
        for (int i = 0; i < transactionQuantity; i++) {
            System.out.println("\nUser ID: " + transactions[i][1]);
            System.out.println("Book ISBN: " + transactions[i][0]);
            System.out.println("Transaction Date: " + transactions[i][2]);
        }
    }

    static void reserveBook(String bookISBN, String userID, int reservationDuration) {

        boolean isBookAvailable = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(bookISBN)) {
                isBookAvailable = true;
                break;
            }
        }

        if (isBookAvailable) {

            int daysTillCheckout = 3;
            LocalDate pickUpDeadline = currentDate.plusDays(daysTillCheckout);// in 3 days, u have to take it from library
            LocalDate reservationEndDate = currentDate.plusDays(reservationDuration);

            succesfullTransactionInfo("reserveBook");
            System.out.printf("You have succesfully reserved this book until this date - \"%s\"\n", reservationEndDate.format(formattedDate));
            System.out.printf("You have to pick up the book  until this date - \"%s\"\n", pickUpDeadline.format(formattedDate));

            LocalDate userPickUpDate = currentDate.plusDays(2);

            if (userPickUpDate.isBefore(pickUpDeadline) || userPickUpDate.isEqual(pickUpDeadline)) {
                System.out.println("You have picked up the book on time.");
                if (transactionQuantity < INDEX) {
                    transactions[transactionQuantity][0] = bookISBN;
                    transactions[transactionQuantity][1] = userID;
                    transactions[transactionQuantity][2] = currentDate.toString();
                    transactionQuantity++;
                }
            } else {
                System.out.println("You failed to pick up the book on time, Reservation failed.");
            }
        } else {
            System.out.println("Reservation failed, please try again.");
        }
    }

    static void succesfullTransactionInfo(String transaction) {
        switch (transaction) {
            case "updateBook":
                System.out.println("\nBook successfully updated.");
                break;
            case "updateUser":
                System.out.println("\nUser updated succesfully.");
                break;
            case "deleteUser":
                System.out.println("\nUser deleted from the system succesfully.");
                break;
            case "addBook":
                System.out.println("\nBook added to the library succesfully.");
                break;
            case "removeBook":
                System.out.println("\nBook removed from the library succesfully.");
                break;
            case "reserveBook":
                System.out.println("\nBook reservation is succesfully done.");
                break;
            case "updateArrays":
                System.out.println("\nArrays updated succesfully.");
                break;
            case "requestBook":
                System.out.println("\nYour specific desired book is succesfully requested.");
                break;
            case "returnBook":
                System.out.println("\nBook returned to the library succesfully.");
                break;
            default:
                System.out.println("\nSuccesfull Operation.");
        }
        updateArrays();
        displayCurrentState();
    }

    static void generateReports(String value) {
        switch (value) {
            case "books":
                countTotalBooks();
                for (int i = 0; i < bookQuantity; i++) {
                    System.out.print("Book " + (i + 1) + ": ");
                    System.out.println(books[i][1]);
                }
                break;
            case "users":
                System.out.println("Total User Quantity in the system: " + userQuantity);
                for (int i = 0; i < userQuantity; i++) {
                    System.out.print("User " + (i + 1) + ": ");
                    System.out.println(users[i][1]);
                }
                break;
            case "transactions":
                System.out.println("Total Transaction Quantity in the system: " + transactionQuantity);
                for (int i = 0; i < transactionQuantity; i++) {
                    System.out.print("Transaction " + (i + 1) + ": ");
                    System.out.println(transactions[i][2]);
                }
                break;
        }
    }


    static void requestBook(String ISBN, String ID) {
        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(ISBN)) {
                bookFound = true;
                System.out.println("\nBook is already available in the library, you can borrow it right now");
                checkOutBook(ISBN, ID);
                break;
            }
        }
        if (!bookFound) {
            int daysForProvidingBook = 5;
            LocalDate dateProvided = currentDate.plusDays(daysForProvidingBook);

            succesfullTransactionInfo("requestBook");
            System.out.println("\nThe book with the given specification is requested and library personal will deliver it for you.");
            System.out.printf("In %d days, \"%s\" - by this date, you will be given the desired book. Thanks for your patience.\n", daysForProvidingBook, dateProvided.format(formattedDate));
            if (transactionQuantity < INDEX) {
                transactions[transactionQuantity][0] = ISBN;
                transactions[transactionQuantity][1] = ID;
                transactions[transactionQuantity][2] = dateProvided.toString();
                transactionQuantity++;

            }
        }
    }

    static void updateArrays() {
        if (bookQuantity == books.length) {
            String[][] newBooksArray = new String[INDEX * 2][4];
            System.arraycopy(books, 0, newBooksArray, 0, books.length);
            books = newBooksArray;
        }
        if (userQuantity == users.length) {
            String[][] newUsersArray = new String[INDEX * 2][4];
            System.arraycopy(users, 0, newUsersArray, 0, users.length);
            users = newUsersArray;
        }
        if (transactionQuantity == transactions.length) {
            String[][] newTransactionsArray = new String[INDEX * 2][4];
            System.arraycopy(transactions, 0, newTransactionsArray, 0, transactions.length);
            transactions = newTransactionsArray;
        }
    }

    static void displayCurrentState() {
        System.out.println("\nCurrent state of the library:");

        System.out.println("Books:");
        for (int i = 0; i < bookQuantity; i++) {
            System.out.printf("%d. ISBN: %s, Title: %s, Author: %s, Additional Info: %s%n", i + 1, books[i][0], books[i][1], books[i][2], books[i][3]);
        }

        System.out.println("Users:");
        for (int i = 0; i < userQuantity; i++) {
            System.out.printf("%d. ID: %s, Name: %s, Email: %s, Password: %s%n", i + 1, users[i][0], users[i][1], users[i][2], users[i][3]);
        }

        System.out.println("Transactions:");
        for (int i = 0; i < transactionQuantity; i++) {
            System.out.printf("%d. ISBN: %s, User ID: %s, Date: %s%n", i + 1, transactions[i][0], transactions[i][1], transactions[i][2]);
        }
    }

    static void truncateBooksArrayOnDeletion(String ISBN) {

        String[][] newBooksArray = new String[books.length][4];
        int newIndex = 0;

        for (int i = 0; i < bookQuantity; i++) {
            if (!books[i][0].equals(ISBN)) {
                newBooksArray[newIndex] = books[i];
                newIndex++;

                System.out.println("Books array has been truncated.");
            }
        }
        books = new String[newIndex][4];
        System.arraycopy(newBooksArray, 0, books, 0, newIndex);

        bookQuantity = newIndex;


        System.out.println("Books array has been truncated.");

    }

}
