public class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    // Constructors
    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    // Setter methods (optional, depending on your needs)
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // toString method to represent the object as a String
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    // Example usage
    public static void main(String[] args) {
        // Creating a contact
        Contact myContact = new Contact("John Doe", "123-456-7890", "john.doe@email.com");

        // Accessing contact information
        System.out.println("Name: " + myContact.getName());
        System.out.println("Phone Number: " + myContact.getPhoneNumber());
        System.out.println("Email Address: " + myContact.getEmailAddress());

        // Updating contact information (using setter methods)
        myContact.setPhoneNumber("987-654-3210");
        System.out.println("Updated Phone Number: " + myContact.getPhoneNumber());

        // Displaying the contact using toString method
        System.out.println("Contact Information: " + myContact);
    }
}
