import java.util.Scanner;

public class LibraryRunner {
    static final String FILE_PATH = "";
    static final int CHECKOUT_LIMIT = 5, PIN_LENGTH = 4, ID_LENGTH = 14;
    static final Scanner INPUT = new Scanner(System.in);
    static Library library = null;

    public static void main(String[] args) {

        String peopleFilename = "", itemFilename = "", bookFilename = "",
                miscFilename = "", clientFilename = "", librarianFilename = "";
        int choice, pin;

        // Login Variables
        long libraryId;
        String password;
        boolean success, running = true;

        while (running) {

            printLibraryMenu();

            if (library != null) {
                choice = getChoice(10);
            }
            else {
                System.out.println("There is no file loaded!");
                choice = 1;
            }

            switch (choice) {
                case 0:   // Exit.
                    System.out.println("Closing Library Program...");
                    running = false;
                    break;

                case 1: // Load People and Item Files
                    boolean itemSuccess = false, peopleSuccess = false;
                    library = new Library();
                    do {
                        if (!peopleSuccess && itemSuccess){
                            System.out.println("People list not loaded!\n");

                            System.out.printf("Enter the PEOPLE filename to load (default location: %s): ", FILE_PATH);
                            peopleFilename = INPUT.nextLine();
                            peopleSuccess = library.loadPeopleList(FILE_PATH + peopleFilename);
                        }
                        else if (!itemSuccess && peopleSuccess){
                            System.out.println("Item list not loaded!\n");

                            System.out.printf("Enter the ITEM filename to load (default location: %s): ", FILE_PATH);
                            itemFilename = INPUT.nextLine();
                            itemSuccess = library.loadItemList(FILE_PATH + itemFilename);
                        }
                        else {
                            System.out.println("Both Item and People list not loaded!\n");

                            System.out.printf("Enter the ITEM filename to load (default location: %s): ", FILE_PATH);
                            itemFilename = INPUT.nextLine();
                            // System.out.println(FILE_PATH + itemFilename);
                            itemSuccess = library.loadItemList(FILE_PATH + itemFilename);

                            System.out.printf("Enter the PEOPLE filename to load (default location: %s): ", FILE_PATH);
                            peopleFilename = INPUT.nextLine();
                            peopleSuccess = library.loadPeopleList(FILE_PATH + peopleFilename);
                        }
                    } while (!(peopleSuccess && itemSuccess));

                    System.out.println("Item and People list in file '" + itemFilename + "' and '" + peopleFilename + "' loaded.\n");
                    break;

                case 2:     // Save the Book List into a file
                    System.out.println("Please enter the filename to save the Book List:");
                    bookFilename = INPUT.nextLine();

                    System.out.println("Saving file '" + bookFilename + "' ...");
                    library.saveItemList(FILE_PATH + bookFilename, true);

                    System.out.println();
                    break;

                case 3:     // Save the Miscellaneous List into a file
                    System.out.println("Please enter the filename to save the Miscellaneous List:");
                    miscFilename = INPUT.nextLine();

                    System.out.println("Saving file '" + miscFilename + "' ...");
                    library.saveItemList(FILE_PATH + miscFilename, false);

                    System.out.println();
                    break;

                case 4:     // Save the Client List into a file
                    System.out.println("Please enter the filename to save the Client List:");
                    clientFilename = INPUT.nextLine();

                    System.out.println("Saving file '" + clientFilename + "' ...");
                    library.savePeopleList(FILE_PATH + clientFilename, true);
                    System.out.println();
                    break;

                case 5:     // Save the Librarian List into a file
                    System.out.println("Please enter the filename to save the Librarian List:");
                    librarianFilename = INPUT.nextLine();

                    System.out.println("Saving file '" + librarianFilename + "' ...");
                    library.savePeopleList(FILE_PATH + librarianFilename, false);

                    System.out.println();
                    break;

                case 6:     // List all the CLients in the Library
                    library.listAllClients();
                    break;

                case 7:     // List all Books in the library
                    library.listAllItems(true);
                    break;

                case 8:     // List all Misc. items in the Library
                    library.listAllItems(false);
                    break;

                case 9:     // Login into the Client's account
                    Client client = null;

                    System.out.println("Sign into your Library Account:");
                    System.out.println("-------------------------------");

                    libraryId = getLibraryId();
                    pin = getPin();
                    client = library.getClient(libraryId);

                    // check if pin and client's pins match (totally secure... )
                    if (client != null && client.getPin() == pin){
                        success = true;
                    }
                    else {
                        System.out.println("Incorrect ID or password, please try again.\n");
                        break;
                    }

                    // Menu if granted
                    if (success) {
                        System.out.println("Access Granted.");
                        System.out.printf("Logging into %s %s's Account...%n", client.getFirstName(), client.getLastName());

                        clientMenu(client);
                    }
                    else {
                        System.out.println("Accesss Denied, you have typed your creditendals wrong. Please try again later.\n");
                    }
                    break;

                case 10:    // Login into the Librarian's account
                    Librarian librarian = null;

                    System.out.println("Sign into your Library Account:");
                    System.out.println("-------------------------------");

                    libraryId = getLibraryId();
                    System.out.print("Please enter your password: ");
                    password = INPUT.nextLine();

                    librarian = library.getLibrarian(libraryId);

                    // check if pin and client's passwords match (totally secure... )
                    if (librarian != null && librarian.getPassword().equals(password)){
                        success = true;
                    }
                    else {
                        System.out.println("Incorrect ID or password , please try again.\n");
                        break;
                    }

                    // Menu if granted
                    if (success) {
                        System.out.println("Access Granted.");
                        System.out.printf("Logging into %s %s's Account...%n", librarian.getFirstName(), librarian.getLastName());

                        librarianMenu(librarian);
                    }
                    else {
                        System.out.println("Accesss Denied, you have typed your creditendals wrong. Please try again later.\n");
                    }
                    break;
            }
        }
    }

    public static void printLibraryMenu() {
        System.out.println("WELCOME TO THE BCI LIBRARY");
        System.out.println("-------------------------------");
        System.out.println("Choose an option from the menu:");
        System.out.println("  1. Load Item and People list from file");
        System.out.println("  2. Save Book List");
        System.out.println("  3. Save Miscellaneous List");
        System.out.println("  4. Save Client List");
        System.out.println("  5. Save Librarian List");
        System.out.println("  ================================");
        System.out.println("  6. Print all Clients");
        System.out.println("  7. Print all Books");
        System.out.println("  8. Print all Miscellaneous Items");
        System.out.println("  ================================");
        System.out.println("  9. Sign into Client account");
        System.out.println(" 10. Sign into Librarian account");
        System.out.println("  ================================");
        System.out.println("  0. Exit Library\n");
    }

    public static void printClientMenu(Client c) {
        System.out.printf("WELCOME BACK, %-5s %-5s TO THE LIBRARY!%n", c.getFirstName(), c.getLastName());
        System.out.printf("Library ID: %-20d%n", c.getLibraryId());
        System.out.println("----------------------------");
        System.out.println("Choose an option from the menu:");
        System.out.println("  1. Display User Info");
        System.out.println("  ================================");
        System.out.println("  2. Check out an item");
        System.out.println("  3. Return an item");
        System.out.println("  ================================");
        System.out.println("  4. Search up a Book by Title");
        System.out.println("  5. Search up an Item by Title");
        System.out.println("  ================================");
        System.out.println("  6. Change library credentials");
        System.out.println("  7. Change personal information");
        System.out.println("  ================================");
        System.out.println("  0. Return to the Library\n");
    }

    public static void clientMenu(Client c) {

        // Local variables for Client parameters
        int choice, pin, age;
        long isbn, libraryId;
        String title, name;

        boolean running = true;

        while (running) {
            boolean checkout = true, finished = false;
            Item item = null;

            printClientMenu(c);
            choice = getChoice(9);

            switch (choice) {
                case 0:   // Exit.
                    System.out.println("Logging out...");
                    running = false;
                    break;

                case 1: // Displays the Client's information
                    System.out.printf("Name: %s %s%n", c.getFirstName(), c.getLastName());
                    System.out.printf("Age: %d%n", c.getAge());
                    System.out.println("Current Checkouts:");

                    // print checkouts here
                    // might need to use Arrays.toString
                    System.out.println(c.getCheckout().toString());
                    System.out.println();
                    break;

                case 2:     // Checkout an Item
                    System.out.println("Welcome to the Library Checkout!");
                    System.out.println("----------------------------");

                    if (c.getCheckout().size() == CHECKOUT_LIMIT) {
                        System.out.println("Max Checkout reached, please return items to checkout.");
                        break;
                    }

                    // Get the information of the book upon checking out.
                    while (!finished) {
                        System.out.println("Please register the item to checkout using the following methods:\n");
                        System.out.println("  ================================");
                        System.out.println("  1. ISBN (Book only)");
                        System.out.println("  2. Title of the Item (All items)");
                        System.out.println("  0. Return to Menu");
                        System.out.println("  ================================");

                        choice = getChoice(2);

                        switch (choice) {
                            case 0:     // Quit
                                System.out.println("Canceling Checkout...");
                                checkout = false;
                                finished = true;
                                break;

                            case 1:     // Search and Checkout Book by ISBN
                                isbn = getIsbn();
                                item = library.getBook(isbn);

                                // check if it exists or not
                                if (item == null) {
                                    System.out.println("This book cannot be found in this Library, please try again.\n");
                                }
                                else {
                                    finished = true;
                                }
                                break;

                            case 2:     // Search Item by Title and Checkout
                                System.out.println("Is the Item a \n 0. Book \nor a\n 1. Misc. Item?");
                                choice = getChoice(1);

                                System.out.print("Please enter the Title of the Item: ");
                                title = INPUT.nextLine();

                                // search if book or item
                                if (choice == 0) {
                                    item = library.searchBook(title);
                                }
                                else {
                                    item = library.searchItem(title);
                                }

                                // check if it exists or not
                                if (item == null) {
                                    System.out.println("This book cannot be found in this Library, please try again.\n");
                                }
                                else {
                                    finished = true;
                                }
                                break;
                        }
                    }

                    if (checkout) {
                        library.checkout(c, item);
                        System.out.println("Successfully Checked out: " + item);
                    }
                    break;

                case 3:     // Return an item
                    System.out.println("Welcome to the Library Checkin!");
                    System.out.println("----------------------------");

                    System.out.println("Select\n1. To confirm Checkin\n or \n0. to Terminate.");
                    choice = getChoice(1);

                    if (choice == 0) {
                        break;
                    }

                    System.out.println("Please select an Item to return: ");
                    System.out.println(c.getCheckout().toString());

                    System.out.println("Please register the item by choosing it's index in your checkout list: \n");
                    choice = getChoice(c.getCheckout().size());

                    item = c.getCheckout().get(choice);
                    library.checkin(c, item);
                    break;

                case 4:     // Search Book by Title
                    System.out.print("Please print the Title of the Book you are looking for: ");
                    title = INPUT.nextLine();

                    item = library.searchBook(title);

                    if (item != null) {
                        System.out.println(item + "\n");
                    }
                    else {
                        System.out.println("This book does not exist in this Library. \n");
                    }
                    break;

                case 5:     // Search Item by Title
                    System.out.print("Please print the Title of the Book you are looking for: ");
                    title = INPUT.nextLine();

                    item = library.searchItem(title);

                    if (item != null) {
                        System.out.println(item + "\n");
                    }
                    else {
                        System.out.println("This item does not exist in this Library. \n");
                    }
                    break;

                case 6:     // Change Library Credentials
                    while (!finished) {
                        System.out.println("What would you like to update on your library account?");
                        System.out.println("  ================================");
                        System.out.println("  1. Update Pin");
                        System.out.println("  2. Update Library ID");
                        System.out.println("  0. Quit");
                        System.out.println("  ================================");

                        choice = getChoice(2);

                        switch (choice) {
                            case 0:     // Quit
                                finished = true;
                                break;

                            case 1:     // Update pin by confirming old one and setting new one
                                System.out.println("Enter your old pin: ");
                                pin = getPin();
                                if (pin == c.getPin()) {
                                    System.out.println("Enter the new updated pin: ");
                                    pin = getPin();
                                    c.setPin(pin);
                                    System.out.println("Updated your pin...");
                                }
                                else {
                                    System.out.println("Incorrect pin, terminating process.");
                                }
                                break;

                            case 2:     // Update id by confirming old one and setting new one
                                System.out.println("Enter your old library id: ");
                                libraryId = getLibraryId();
                                if (libraryId == c.getLibraryId()) {
                                    System.out.println("Enter the new updated library id: ");
                                    libraryId = getLibraryId();
                                    c.setLibraryId(libraryId);
                                    System.out.println("Updated your library id...");
                                }
                                else {
                                    System.out.println("Incorrect id, terminating process.");
                                }
                                break;
                        }
                    }
                    break;

                case 7:     // Change Personal Information
                    while (!finished) {
                        System.out.println("What would you like to change for your personal information?");
                        System.out.println("  ================================");
                        System.out.println("  1. First Name");
                        System.out.println("  2. Last Name");
                        System.out.println("  3. Age");
                        System.out.println("  0. Quit");
                        System.out.println("  ================================");

                        choice = getChoice(3);

                        switch (choice) {
                            case 0:     // Quit
                                finished = true;
                                break;

                            case 1:     // Change first name
                                System.out.print("Enter your updated first name: ");
                                name = INPUT.nextLine();    // assume valid name (anything works)
                                c.setFirstName(name);
                                System.out.println("Updated first name to: '" + name + "'");
                                break;

                            case 2:     // Change last name
                                System.out.print("Enter your updated last name: ");
                                name = INPUT.nextLine();    // assume valid name (anything works)
                                c.setLastName(name);
                                System.out.println("Updated lat name to: '" + name + "'");
                                break;

                            case 3:     // Change age
                                System.out.println("Enter your new age: ");
                                age = getAge();
                                c.setAge(age);
                                System.out.println("Updated age to: '" + age + "'");
                                break;
                        }
                    }
                    break;
            }
        }
    }

    public static void printLibrarianMenu(Librarian l) {
        System.out.printf("WELCOME BACK, %-5s %-5s TO THE LIBRARY. KEEP UP THE GOOD WORK!%n", l.getFirstName(), l.getLastName());
        System.out.printf("Library ID: %-20d%n", l.getLibraryId());
        System.out.println("----------------------------");
        System.out.println("  1. Search up an Item by Title");
        System.out.println("  2. Search up an Book by Title");
        System.out.println("  3. Search up a Book by ISBN");
        System.out.println("  ================================");
        System.out.println("  4. Add new Item to Library");
        System.out.println("  5. Remove item from Library");
        System.out.println("  6. Add new Client to Library");
        System.out.println("  7. Remove Client from Library");
        System.out.println("  ================================");
        System.out.println("  8. Sort Book list by ISBN");
        System.out.println("  9. Sort List by Alphabetical Order");
        System.out.println("  ================================");
        System.out.println(" 10. Change library credentials");
        System.out.println(" 11. Change personal information");
        System.out.println("  ================================");
        System.out.println("  0. Return to the Library\n");
    }

    public static void librarianMenu(Librarian l) {
        // Local variables for Librarian parameters
        int choice, age;
        long isbn, libraryId;
        String title, name;

        boolean running = true;

        while (running) {
            boolean finished = false;
            Item item;
            Client client;

            printLibrarianMenu(l);
            choice = getChoice(11);

            switch (choice) {
                case 0:     // Exit.
                    System.out.println("Logging out...");
                    running = false;
                    break;

                case 1:     // Search by item
                    System.out.print("Please print the Title of the Item you are looking for: ");
                    title = INPUT.nextLine();

                    item = library.searchItem(title);

                    if (item != null) {
                        System.out.println("Found an item type: " + item.getClass());
                        System.out.println(item + "\n");
                    }
                    else {
                        System.out.println("This title does not exist Library.");
                    }
                    break;

                case 2:      // Search by Book
                    System.out.print("Please print the Title of the Book you are looking for: ");
                    title = INPUT.nextLine();

                    item = library.searchBook(title);

                    if (item != null) {
                        System.out.println(item + "\n");
                    }
                    else {
                        System.out.println("This Book does not exist Library.");
                    }
                    break;

                case 3:     // Search book by ISBN
                    System.out.println("Please print the ISBN of the Book you are looking for: ");
                    isbn = getIsbn();

                    item = library.getBook(isbn);

                    if (item != null) {
                        System.out.println(item + "\n");
                    }
                    else {
                        System.out.println("This Book does not exist Library.");
                    }
                    break;

                case 4:     // Add new Item to Library
                    item = newItem();
                    library.addItem(item);
                    System.out.println("Added Item: " + item + " To the Library!");
                    break;

                case 5:     // Remove an Item from the Library
                    item = getItem();
                    if (item != null) {
                        System.out.println("Successfully removed Item: " + item + " from the Library!");
                        library.removeItem(item);
                    }
                    else {
                        System.out.println("Item cannot be found.");
                    }
                    break;

                case 6:     // Add a new Client to the
                    client = newClient();
                    library.addPerson(client);
                    System.out.println("Added Client: " + client + " To the Library!");
                    break;

                case 7:     // Remove a Client
                    client = getClient();

                    if (client != null) {
                        library.removePerson(client);
                        System.out.println("Removed Client: " + client + " from the Library!");
                    }
                    else {
                        System.out.println("Client cannot be found.");
                    }
                    break;

                case 8:     // Sort Book List by ISBN
                    System.out.println("Sorting the books by ISBN");
                    library.sortByISBN();
                    System.out.println("Books have been sorted by ISBN...");
                    break;

                case 9:     // Sort List Alphabetically
                    while (!finished) {
                        System.out.println("Which list would you like to sort alphabetically?");
                        System.out.println("  ================================");
                        System.out.println("  1. Book");
                        System.out.println("  2. Misc");
                        System.out.println("  0. Quit");
                        System.out.println("  ================================");

                        choice = getChoice(2);

                        switch (choice) {
                            case 0:     // Quit
                                finished = true;
                                break;

                            case 1:     // Sort the Book List Alphabetically
                                library.sortByAlphabetical(true);
                                System.out.println("Book list has been sorted alphbetcally. \n");
                                break;

                            case 2:     // Sort the Misc. List Alphabetically
                                library.sortByAlphabetical(false);
                                System.out.println("Misc. list has been sorted alphbetcally. \n");
                                break;
                        }
                    }
                    break;

                case 10:     // Change Library Credentials
                    String password;

                    while (!finished) {
                        System.out.println("What would you like to update on your library account?");
                        System.out.println("  ================================");
                        System.out.println("  1. Update Password");
                        System.out.println("  2. Update Library ID");
                        System.out.println("  0. Quit");
                        System.out.println("  ================================");

                        choice = getChoice(2);

                        switch (choice) {
                            case 0:     // Quit
                                finished = true;
                                break;

                            case 1:     // Update password by confirming old one and setting new one
                                System.out.println("Enter your old password: ");
                                password = INPUT.nextLine();
                                if (password.equals(l.getPassword())) {
                                    System.out.println("Enter the new updated password: ");
                                    password = INPUT.nextLine();
                                    l.setPassword(password);
                                    System.out.println("Updated your password...");
                                }
                                else {
                                    System.out.println("Incorrect password, terminating process.");
                                }
                                break;

                            case 2:     // Update id by confirming old one and setting new one
                                System.out.println("Enter your old library id: ");
                                libraryId = getLibraryId();
                                if (libraryId == l.getLibraryId()) {
                                    System.out.println("Enter the new updated library id: ");
                                    libraryId = getLibraryId();
                                    l.setLibraryId(libraryId);
                                    System.out.println("Updated your library id...");
                                }
                                else {
                                    System.out.println("Incorrect id, terminating process.");
                                }
                                break;
                        }
                    }
                    break;

                case 11:     // Change Personal Information
                    while (!finished) {
                        System.out.println("What would you like to change for your personal information?");
                        System.out.println("  ================================");
                        System.out.println("  1. First Name");
                        System.out.println("  2. Last Name");
                        System.out.println("  3. Age");
                        System.out.println("  0. Quit");
                        System.out.println("  ================================");

                        choice = getChoice(2);

                        switch (choice) {
                            case 0:     // Quit
                                finished = true;
                                break;

                            case 1:     // Change first name
                                System.out.println("Enter your updated first name: ");
                                name = INPUT.nextLine();    // assume valid name (anything works)
                                l.setFirstName(name);
                                System.out.println("Updated first name to: '" + name + "'");
                                break;

                            case 2:     // Change last name
                                System.out.println("Enter your updated last name: ");
                                name = INPUT.nextLine();    // assume valid name (anything works)
                                l.setLastName(name);
                                System.out.println("Updated last name to: '" + name + "'");
                                break;

                            case 3:     // Change age
                                System.out.println("Enter your new age: ");
                                age = getAge();
                                l.setAge(age);
                                System.out.println("Updated age to: '" + age + "'");
                                break;
                        }
                    }
                    break;
            }
        }
    }

    public static long getLibraryId() {
        // Helper method for getting a library id
        long libraryId;

        while (true) {
            System.out.print("Please enter your Library ID: ");
            try {
                libraryId = Long.parseLong(INPUT.nextLine());

                // Library ID's must be 14 digits long
                if (libraryId > 0 && Long.toString(libraryId).length() == ID_LENGTH) {
                    return libraryId;
                }
                System.out.println("Invalid ID, you have not entered 14 digits.\n");
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid ID, please enter an ID with only numbers.\n");
            }
        }
    }

    public static int getPin() {
        // Helper method for getting a pin
        int pin;
        while (true) {
            System.out.print("Please enter your pin: ");
            try {
                pin = Integer.parseInt(INPUT.nextLine());

                // Pin must be 4 digits long
                if (pin > 0 && Integer.toString(pin).length() == PIN_LENGTH) {
                    return pin;
                }
                System.out.println("Invalid pin, you have not entered 4 digits.\n");

            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid Pin format, please enter only numbers.\n");
            }
        }
    }


    public static int getChoice(int maxChoices) {
        // Helper method used to get a VALID choice from the user
        int choice;

        while (true) {
            System.out.print(">> ");
            try {
                choice = Integer.parseInt(INPUT.nextLine());
                // if choice within range, return that (validated)
                if (choice >= 0 && choice <= maxChoices) {
                    return choice;
                }
                System.out.println("Please enter a choice within the range provided.\n");

                // if user enters string / float, give error message
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid choice, please enter an integer within the list of options.\n");
            }
        }
    }

    public static long getIsbn() {
        // Helper method used to get a VALID ISBN from the user
        long isbn;
        while (true) {
            System.out.print("Please enter the ISBN of the Book: ");
            try {
                isbn = Long.parseLong(INPUT.nextLine());

                // ISBNs must be 13 digits long
                if (Long.toString(isbn).length() == 13) {
                    return isbn;
                }
                System.out.println("Invalid ISBN, you have not entered 13 digits.\n");
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid ISBN, please enter an ISBN with only numbers.\n");
            }
        }
    }

    public static int getAge() {
        // Helper method used to get a VALID age (>0) from the user
        int age;

        System.out.print("Enter the age of the Person: ");
        while (true) {
            try {
                age = Integer.parseInt(INPUT.nextLine());
                if (age > 0) {
                    return age;
                }
                System.out.println("Please enter a valid argument (no negative)!");
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid age, please enter an integer (whole number).\n");
            }
        }
    }

    public static Client getClient() {
        // Helper method used to get a Client given their library ID.
        long libraryId;
        System.out.println("Please enter the Client's ID:");
        libraryId = getLibraryId();
        return library.getClient(libraryId);
    }

    public static Client newClient() {
        // Helper method take instantiates a new Client to the Library.
        String firstName, lastName;
        int age, pin;
        long libraryId;

        System.out.print("Please enter the First Name of the Client: ");
        firstName = INPUT.nextLine();

        System.out.print("Please enter the Last Name of the Client: ");
        lastName = INPUT.nextLine();

        System.out.println("Please enter the age of the new Client: ");
        age = getAge();

        libraryId = getLibraryId();
        pin = getPin();

        return new Client(firstName, lastName, age, libraryId, pin);
    }

    public static Item getItem() {
        // Helper method used to get an Item given it's title.
        String title;
        Item item;

        System.out.print("Please print the Title of the Item you are looking for: ");
        title = INPUT.nextLine();

        item = library.searchItem(title);

        if (item != null) {
            return item;
        }
        item = library.searchBook(title);

        if (item != null) {
            return item;
        }

        System.out.println("Item does not exist.");
        return null;
    }

    public static Item newItem() {
        // Helper method take instantiates a new Item to the Library.
        String title, author, genre, bookType = "";
        int choice = 0, year, numOfPages;
        long isbn;
        double capacity, duration;
        Item item = null;

        System.out.println("What type of Item to add to the library?");
        System.out.println("  ================================");
        System.out.println("  1. Book");
        System.out.println("  2. Magazine");
        System.out.println("  3. DVD");
        System.out.println("  ================================");

        while (choice == 0) {
            choice = getChoice(3);
        }

        System.out.print("Please enter the Title of the Item: ");
        title = INPUT.nextLine();

        System.out.print("Please enter the Author of the Item: ");
        author = INPUT.nextLine();

        System.out.print("Please enter the publishing year for the Item: ");
        while (true) {
            try {
                year = Integer.parseInt(INPUT.nextLine());
                if (year > 0) {
                    break;
                }
                System.out.println("Please enter a valid argument!");
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid format, please enter an integer (whole number).\n");
            }
        }

        switch (choice) {
            case 1:     // New Book
                System.out.print("Please enter the type of Book (fiction or non-fiction): ");
                while (!(bookType.equals("fiction") | bookType.equals("non-fiction"))) {
                    bookType = INPUT.nextLine().toLowerCase();
                }

                System.out.print("Please enter the Genre of the Book:");
                genre = INPUT.nextLine();

                isbn = getIsbn();

                System.out.print("Enter the number of pages: ");
                while (true) {
                    try {
                        numOfPages = Integer.parseInt(INPUT.nextLine());
                        if (numOfPages > 0) {
                            break;
                        }
                        System.out.println("Please enter a valid argument (no negative)!");
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println("Invalid format, please enter an integer (whole number).\n");
                    }
                }
                item = new Book(title, author, year, bookType, genre, isbn, numOfPages);
                break;

            case 2:     // New Magazine
                System.out.print("Please enter the Genre of the Magazine: ");
                genre = INPUT.nextLine();

                System.out.print("Enter the number of pages: ");
                while (true) {
                    try {
                        numOfPages = Integer.parseInt(INPUT.nextLine());
                        if (numOfPages > 0) {
                            break;
                        }
                        System.out.println("Please enter a valid argument (no negative)!");
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println("Invalid format, please enter an integer (whole number).\n");
                    }
                }
                item = new Magazine(title, author, year, genre, numOfPages);
                break;

            case 3:     // New DVD
                System.out.print("Please enter the Capacity (mB) of the DVD: ");
                while (true) {
                    try {
                        capacity = Double.parseDouble(INPUT.nextLine());
                        if (capacity > 0) {
                            break;
                        }
                        System.out.println("Please enter a valid argument (no negative)!");
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println("Invalid format, please enter a real number.\n");
                    }
                }

                System.out.print("Please enter the Duration (mins) of the DVD:");
                while (true) {
                    try {
                        duration = Double.parseDouble(INPUT.nextLine());
                        if (duration > 0) {
                            break;
                        }
                        System.out.println("Please enter a valid argument (no negative)!");
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println("Invalid format, please enter a real number.\n");
                    }
                }
                item = new DVD(title, author, year, capacity, duration);
                break;
        }
        return item;
    }
}