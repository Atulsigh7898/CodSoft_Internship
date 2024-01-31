import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook1 {
    private List<Contact> contacts;

    public AddressBook1() {
        this.contacts = new ArrayList<>();
    }

    // ... (other methods)

    // Method to save contacts to a file using serialization
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving contacts to file: " + e.getMessage());
        }
    }

    // Method to load contacts from a file using deserialization
    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            contacts = (List<Contact>) ois.readObject();
            System.out.println("Contacts loaded from file: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading contacts from file: " + e.getMessage());
        }
    }

    // Example usage
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        // Adding some contacts
        addressBook.addContact(new Contact("John Doe", "123-456-7890", "john.doe@email.com"));
        addressBook.addContact(new Contact("Jane Smith", "987-654-3210", "jane.smith@email.com"));

        // Saving contacts to a file
        // addressBook.saveToFile1("contacts.ser");

        // // Clearing contacts (simulating a new instance)
        // addressBook = new AddressBook();

        // // Loading contacts from a file
        // addressBook.loadFromFile1("contacts.ser");

        // Displaying all contacts after loading
        addressBook.displayAllContacts();
    }
}
