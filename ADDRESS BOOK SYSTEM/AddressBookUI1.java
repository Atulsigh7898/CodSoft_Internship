import java.util.Scanner;

public class AddressBookUI1 {
    private static AddressBook addressBook = new AddressBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    editContact();
                    break;
                case 5:
                    displayAllContacts();
                    break;
                case 6:
                    System.out.println("Exiting Address Book System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nAddress Book System Menu:");
        System.out.println("1. Add a contact");
        System.out.println("2. Remove a contact");
        System.out.println("3. Search for a contact");
        System.out.println("4. Edit a contact");
        System.out.println("5. Display all contacts");
        System.out.println("6. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice (1-6): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number (1-6): ");
            scanner.next(); // consume invalid input
        }
        return scanner.nextInt();
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.next();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        addressBook.addContact(newContact);
        System.out.println("Contact added successfully!");
    }

    private static void removeContact() {
        System.out.print("Enter the name of the contact to remove: ");
        String nameToRemove = scanner.next();
        Contact contactToRemove = addressBook.searchContactByName(nameToRemove);

        if (contactToRemove != null) {
            addressBook.removeContact(contactToRemove);
            System.out.println("Contact removed successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void searchContact() {
        System.out.print("Enter the name of the contact to search: ");
        String nameToSearch = scanner.next();
        Contact foundContact = addressBook.searchContactByName(nameToSearch);

        if (foundContact != null) {
            System.out.println("Contact found: " + foundContact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void editContact() {
        System.out.print("Enter the name of the contact to edit: ");
        String nameToEdit = scanner.next();
        Contact contactToEdit = addressBook.searchContactByName(nameToEdit);

        if (contactToEdit != null) {
            System.out.println("Current contact information: " + contactToEdit);
            System.out.print("Enter new phone number (press Enter to keep current): ");
            String newPhoneNumber = scanner.nextLine().trim();
            if (!newPhoneNumber.isEmpty()) {
                contactToEdit.setPhoneNumber(newPhoneNumber);
            }

            System.out.print("Enter new email address (press Enter to keep current): ");
            String newEmailAddress = scanner.nextLine().trim();
            if (!newEmailAddress.isEmpty()) {
                contactToEdit.setEmailAddress(newEmailAddress);
            }

            System.out.println("Contact edited successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void displayAllContacts() {
        addressBook.displayAllContacts();
    }
}
