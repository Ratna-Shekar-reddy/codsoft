import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public void saveContactsToFile(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contacts);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Contacts saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readContactsFromFile(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            contacts = (List<Contact>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class AddressBook {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Save contacts to file");
            System.out.println("6. Read contacts from file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.next();
                    Contact contact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(contact);
                    break;
                case 2:
                    // Code to remove a contact
                    break;
                case 3:
                    // Code to search for a contact
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    addressBook.saveContactsToFile("contacts.txt");
                    break;
                case 6:
                    addressBook.readContactsFromFile("contacts.txt");
                    break;
                case 7:
                    System.out.println("Exiting the application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
