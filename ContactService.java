package Contact;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ContactService {

    private static List<Contact> contactList = new ArrayList<>();
    private static int currID = 0;

    public static void clearList() {
        contactList.clear();
        currID = 0;
    }

    public static int sizeOfList() {
        return contactList.size();
    }

    /**
     * Adds a new contact to the contactList using a generated contactID
     * @param firstName
     * @param lastName
     * @param address
     * @param phone 
     */
    public static void addContact(String firstName, String lastName, String address, String phone) {
        String strID = Integer.toString(currID);
        Contact contact = new Contact(strID, firstName, lastName, address, phone);
        contactList.add(contact);
        currID++;
    }

    /**
     * Retrieves a contact from the list by ID
     * @param targetID
     * @return Contact
     * @throws NoSuchElementException if not found
     */
    public static Contact getContact(String targetID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(targetID)) {
                return contact;
            }
        }
        throw new NoSuchElementException("No matching contact found");
    }

    /**
     * Deletes a contact from contactList using the contactID
     * @param targetID
     */
    public static void deleteContactByID(String targetID) {
        try {
            Contact contact = getContact(targetID);
            contactList.remove(contact);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    

    /**
     * Updates a contact's first name using the contactID
     * @param targetID
     * @param firstName
     */
    public static void updateFirstNameByID(String targetID, String firstName) {
        try {
            Contact contact = getContact(targetID);
            contact.setFirstName(firstName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Updates a contact's last name using the contactID
     * @param targetID
     * @param lastName
     */
    public static void updateLastNameByID(String targetID, String lastName) {
        try {
            Contact contact = getContact(targetID);
            contact.setLastName(lastName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Updates a contact's address using the contactID
     * @param targetID
     * @param address
     */
    public static void updateAddressByID(String targetID, String address) {
        try {
            Contact contact = getContact(targetID);
            contact.setAddress(address);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Updates a contact's phone number using the contactID
     * @param targetID
     * @param phone
     */
    public static void updatePhoneByID(String targetID, String phone) {
        try {
            Contact contact = getContact(targetID);
            contact.setPhone(phone);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
