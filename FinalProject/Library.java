import java.io.*;
import java.util.*;

public class Library {
    private ArrayList<Book> bookList;
    private ArrayList<Person> people;
    private ArrayList<Item> misc;

    /**
     * Constructor method which initializes the different lists for the Library object.
     */
    public Library() {
        bookList = new ArrayList<>();
        people = new ArrayList<>();
        misc = new ArrayList<>();
    }

    /**
     * Loads the item list from the given file.
     *
     * @param filename name of file to load information from
     * @return whether loading of the file was successful
     */
    public boolean loadItemList(String filename) {
        Item item;
        String title, author, itemType, bookType, genre;
        long isbn;
        int year, numOfPages;
        double capacity, duration;
        boolean success = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String content = reader.readLine();
            while(content != null) {

                // For the line, break it up by commas
                Scanner contentReader = new Scanner(content).useDelimiter(",");

                // common attribute all Items have
                title = contentReader.next();
                author = contentReader.next();
                year = Integer.parseInt(contentReader.next());
                itemType = contentReader.next();

                // Item; Book
                if (itemType.equals("Book")) {
                    // add the attributes specific to Book
                    bookType = contentReader.next();
                    genre = contentReader.next();
                    isbn = Long.parseLong(contentReader.next());
                    numOfPages = Integer.parseInt(contentReader.next());
                    item = new Book(title, author, year, bookType, genre, isbn, numOfPages);
                }

                else if (itemType.equals("Magazine")) {
                    // add the attributes specific to the Magazine
                    genre = contentReader.next();
                    numOfPages = Integer.parseInt(contentReader.next());
                    item = new Magazine(title, author, year, genre, numOfPages);
                }
                else { // for better use; use IOE if incorrect file; but not-learnt
                    // add the attributes specific to the DVD
                    capacity = Double.parseDouble(contentReader.next());
                    duration = Double.parseDouble(contentReader.next());
                    item = new DVD(title, author, year, capacity, duration);
                }

                // add item to the appropriate item list
                if (item instanceof Book) {
                    bookList.add((Book) item);
                }
                else {
                    misc.add(item);
                }
                content = reader.readLine();
                success = true;
            }
        }
        catch (IOException ioe) {
            System.out.println("Problem reading file.");
        }
        return success;
    }

    /**
     * Saves the item list from the given file. Differentiates between Books and Miscellaneous items.
     *
     * @param filename name of file to load information from
     * @param saveBookList whether to save book list
     * @return whether saving of the file of Items was successful
     */
    public boolean saveItemList(String filename, boolean saveBookList) {
        boolean success = false;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));

            // If book list, save all books
            if (saveBookList) {
                for (Book book : bookList) {
                    writer.write(book.getTitle() + "," + book.getAuthor() + ","
                            + book.getYear() + ",Book," + book.getBookType() + "," + book.getGenre() + ","
                            + book.getIsbn() + "," + book.getNumOfPages());
                    writer.write("\n");
                }
            }
            // save all misc items.
            else {
                for (Item item : misc) {
                    writer.write(item.getTitle() + "," + item.getAuthor() + "," + item.getYear() + ",");

                    if (item instanceof Magazine) {
                        writer.write("Magazine," + ((Magazine) item).getGenre() + "," + ((Magazine) item).getNumOfPages());
                    }

                    else {
                        writer.write("DVD," + ((DVD) item).getCapacity()+ "," + ((DVD) item).getDuration());
                    }
                    writer.write("\n");
                }
            }
            success = true;
            writer.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return success;
    }

    /**
     * Loads the people list from the given file.
     *
     * @param filename name of file to load information from
     * @return whether loading of the file was successful
     */
    public boolean loadPeopleList(String filename) {
        // local variables for instantiating new Person Object
        Person person;
        String firstName, lastName, password, personType;
        long libraryId;
        int age, pin, numOfCheckout;
        boolean success = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String content = reader.readLine();
            while(content != null) {

                // For the line, break it up by commas
                Scanner contentReader = new Scanner(content).useDelimiter(",");

                // common attribute all person have
                lastName = contentReader.next();
                firstName = contentReader.next();
                age = Integer.parseInt(contentReader.next());
                personType = contentReader.next();

                // check person type
                if (personType.equals("Client")) {

                    // add the attributes specific to the Client
                    libraryId = Long.parseLong(contentReader.next());
                    pin = Integer.parseInt(contentReader.next());
                    numOfCheckout = Integer.parseInt(contentReader.next());
                    person = new Client(firstName, lastName, age, libraryId, pin);

                    // local item variables
                    Item item;
                    String title, author, itemType, bookType, genre;
                    long isbn;
                    int year, numOfPages;
                    double capacity, duration;

                    // checkout items
                    for (int i = 0; i < numOfCheckout; i++) {

                        // common attribute all Items have
                        title = contentReader.next();
                        author = contentReader.next();
                        year = Integer.parseInt(contentReader.next());
                        itemType = contentReader.next();

                        // Item; Book
                        if (itemType.equals("Book")) {

                            // add the attributes specific to Book
                            bookType = contentReader.next();
                            genre = contentReader.next();
                            isbn = Long.parseLong(contentReader.next());
                            numOfPages = Integer.parseInt(contentReader.next());
                            item = new Book(title, author, year, bookType, genre, isbn, numOfPages);
                        }

                        else if (itemType.equals("Magazine")) {
                            // add the attributes specific to Magazine
                            genre = contentReader.next();
                            numOfPages = Integer.parseInt(contentReader.next());
                            item = new Magazine(title, author, year, genre, numOfPages);
                        }
                        else {
                            // add the attributes specific to DVD
                            capacity = Double.parseDouble(contentReader.next());
                            duration = Double.parseDouble(contentReader.next());
                            item = new DVD(title, author, year, capacity, duration);
                        }
                        // add checkout item to the client
                        ((Client) person).checkout(item);
                    }
                }
                else {
                    // add the attributes specific to Librarian
                    libraryId = Long.parseLong(contentReader.next());
                    password = contentReader.next();
                    person = new Librarian(firstName, lastName, age, libraryId, password);
                }
                people.add(person);
                content = reader.readLine();
            }
            success = true;
        }
        catch (IOException ioe) {
            System.out.println("Problem reading file.");
        }
        return success;
    }

    /**
     * Saves the people list from the given file. Differentiates between Clients and Librarians.
     *
     * @param filename name of file to load information from
     * @param saveClientList whether to save client list
     * @return whether saving of the file of Items was successful
     */
    public boolean savePeopleList(String filename, boolean saveClientList) {
        boolean success = false;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));

            for (Person person : people) {
                if (saveClientList) {
                    if (person instanceof Client) {
                        writer.write(person.getFirstName() + "," + person.getLastName() + "," + person.getAge() + ",");
                        writer.write(((Client) person).getLibraryId() + "," + ((Client) person).getPin() + ",");

                        // items for checkout
                        writer.write(((Client) person).getCheckout().size() +",");
                        for (Item item : ((Client) person).getCheckout()) {
                            writer.write(item.getAuthor() + "," + item.getTitle() + "," + item.getYear() + ",");
                            if (item instanceof Book) {
                                writer.write(",Book," + ((Book) item).getBookType() + "," + ((Book) item).getGenre() + ","
                                        + ((Book) item).getIsbn() + "," + ((Book) item).getNumOfPages());
                            }
                            else if (item instanceof Magazine) {
                                writer.write("Magazine," + ((Magazine) item).getGenre() + "," + ((Magazine) item).getNumOfPages());
                            }
                            else {
                                writer.write("DVD," + ((DVD) item).getCapacity()+ "," + ((DVD) item).getDuration());
                            }
                        }
                        writer.write("\n");
                    }
                }
                else {
                    if (person instanceof Librarian) {
                        writer.write(person.getFirstName() + "," + person.getLastName() + "," + person.getAge() + ",");
                        writer.write("Librarian," + ((Librarian) person).getLibraryId() + "," + ((Librarian) person).getPassword());
                        writer.write("\n");
                    }
                }
            }
            success = true;
            writer.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return success;
    }

    /**
     * Returns the book object, given the isbn of the book; or null if not found.
     *
     * @param isbn book isbn
     * @return Book object or null
     */
    public Book getBook(long isbn) {
        for (Book book : bookList) {
            if (book.getIsbn() == isbn) {
                return book;
            }
        }
        return null;
    }

    /**
     * Linear searches the book based on the title of the book, given a title.
     *
     * @param title the title of the book
     * @return Book object or null if not found
     */
    public Book searchBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Linear searches the item based on the title of the item, given a title.
     *
     * @param title the title of the item
     * @return Item object or null if not found
     */
    public Item searchItem(String title){
        for (Item item : misc) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Linear searches the Client based on the library id of the Client.
     *
     * @param libraryId the client's library id
     * @return Client object or null if not found
     */
    public Client getClient(long libraryId) {
        for (Person person : people) {
            // if the person is a client, compare id's
            if (person instanceof Client) {
                if (((Client) person).getLibraryId() == libraryId) {
                    return (Client) person;
                }
            }
        }
        return null;
    }

    /**
     * Linear searches the Librarian based on the give library id of the Librarian.
     *
     * @param libraryId the librarian's library id
     * @return Librarian object or null if not found
     */
    public Librarian getLibrarian(long libraryId) {
        for (Person person : people) {
            // if the person is a librarian, compare id's
            if (person instanceof Librarian) {
                if (((Librarian) person).getLibraryId() == libraryId) {
                    return (Librarian) person;
                }
            }
        }
        return null;
    }

    /**
     * Prints the Book's details given the Isbn; or error message if Book not found.
     *
     * @param isbn isbn of the book
     */
    public void printBook(long isbn) {
        Book book = getBook(isbn);
        if (book != null) {
            System.out.println(book);
        }
        else {
            System.out.println("Book with ISBN: " + isbn + ", does not exist.");
        }
    }

    /**
     * Prints the Client's details given their library id; or error message if Client not found.
     *
     * @param libraryId client's library id
     */
    public void printClient(long libraryId) {
        Client client = getClient(libraryId);
        if (client != null) {
            System.out.println(client);
        }
        else {
            System.out.println("Client with ID: " + libraryId + ", does not exist.");
        }
    }

    /**
     * Prints the all the items in the Item List; Books or Misc list.
     *
     * @param isBookList whether to print the book list
     */
    public void listAllItems(boolean isBookList) {
        if (isBookList) {
            System.out.println("List of all books:");
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
        else {
            System.out.println("List of all items:");
            for (Item item : misc) {
                System.out.println(item);
            }
        }
        System.out.println();
    }

    /**
     * Prints all the Clients enrolled in at the Library.
     */
    public void listAllClients() {
        System.out.println("List of all Clients:");
        for (Person person : people) {
            if (person instanceof Client) {
                System.out.println(person);
            }
        }
        System.out.println();
    }

    /**
     * Adds an item to the Item List; checks if it's a Book or a Misc. Item and appends to appropriate list.
     *
     * @param item item to be added to the Library
     */
    public void addItem(Item item) {
        if (item instanceof Book) {
            bookList.add((Book) item);
            System.out.println("Added Book: " + item.getTitle() + " to the book list.");
        }
        else {
            misc.add(item);
            System.out.println("Added Item: " + item.getTitle() + " to the miscellaneous list.");
        }
    }

    /**
     * Removes the item specified from the appropriate list (Book or Misc.).
     *
     * @param item item to be removed
     */
    public void removeItem(Item item) {
        if (item instanceof Book) {
            bookList.remove((Book) item);
            System.out.println("Removed Book: " + item.getTitle() + " to the book list.");
        }
        else {
            misc.remove(item);
            System.out.println("Removed Item: " + item.getTitle() + " to the miscillanous list.");
        }
    }

    /**
     * Adds the person to the People list at the Library.
     *
     * @param person the new person added
     */
    public void addPerson(Person person) {
        people.add(person);
    }

    /**
     * Removes the person from the People list at the Library.
     *
     * @param person the person removed
     */
    public void removePerson(Person person) {
        people.remove(person);
    }

    /**
     * Checkouts the intended item to the Client. Removes it from the library.
     *
     * @param client client checking out the item
     * @param item item to be checked out
     */
    public void checkout(Client client, Item item) {
        client.checkout(item);
        System.out.println("Person: " + client.getFirstName() + " " + client.getLastName() + " Checked-out Item: " + item.getTitle());
        removeItem(item);
    }

    /**
     * Checks in the item from the Client. Adds it back to the Library.
     *
     * @param client client checking in the item
     * @param item item to be checked in
     */
    public void checkin(Client client, Item item) {
        client.checkin(item);
        System.out.println("Person: " + client.getFirstName() + " " + client.getLastName() + " Checked-in Item: " + item.getTitle());
        addItem(item);
    }

    /**
     * Sort the Book list by ISBN. Utilizes insertion sort to do so.
     */
    public void sortByISBN() {
        // insertion sort; arraylist modification
        int j;
        for (int i = 1; i < bookList.size(); i++) {
            Book temp = bookList.get(i);
            j = i;
            while (j > 0 && bookList.get(j - 1).getIsbn() > temp.getIsbn()) {
                bookList.set(j, bookList.get(j - 1));
                j--;
            }
            bookList.set(j, temp);
        }
    }

    /**
     * Sorts the Book or Misc. list alphabetically using the built-in comparable interface and Collections sort.
     *
     * @param isBookList whether to sort the book list
     */
    public void sortByAlphabetical(boolean isBookList) {
        if (isBookList) {
            Collections.sort(bookList);
        }
        else {
            Collections.sort(misc);
        }
    }
}