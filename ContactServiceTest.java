package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import Contact.Contact;
import Contact.ContactService;

public class ContactServiceTest {
	
	// Valid parameters to reduce redundancy
	private final String validFirstName = "Anakin";
	private final String validLastName = "Skywalker";
	private final String validAddress = "300 Mustafar Place";
	private final String validPhone = "1234567890";
	
	@AfterEach
	void teardown() {
	    ContactService.clearList();
	}
	
	@Test
	void testAddContact() {
		ContactService.addContact(validFirstName, validLastName, validAddress, validPhone);
		
		assertEquals(1, ContactService.sizeOfList());
		Contact contact = ContactService.getContact("0");
		assertEquals("0", contact.getContactID());
		assertEquals(validFirstName, contact.getFirstName());
		assertEquals(validLastName, contact.getLastName());
		assertEquals(validAddress, contact.getAddress());
		assertEquals(validPhone, contact.getPhone());
	}
	
	@Test
	void testDeleteContact() {
		ContactService.addContact(validFirstName, validLastName, validAddress, validPhone);
		ContactService.addContact(validFirstName, validLastName, validAddress, validPhone);
		
		ContactService.deleteContactByID("1");
		
		// Ensure the task was deleted
        Assertions.assertThrows(
            NoSuchElementException.class,
            () -> ContactService.getContact("1")
        );
	}
	
	@Test
	void testUpdateFirstName() {
		String updatedFirstName = "Obi-Wan";
		ContactService.addContact(validFirstName, validLastName, validAddress, validPhone);
		ContactService.updateFirstNameByID("0", updatedFirstName);
		
		assertEquals(updatedFirstName, ContactService.getContact("0").getFirstName());
	}
	
	@Test
	void testUpdateLastName() {
		String updatedLastName = "Kenobi";
		ContactService.addContact(validFirstName, validLastName, validAddress, validPhone);
		ContactService.updateLastNameByID("0", updatedLastName);
		
		assertEquals(updatedLastName, ContactService.getContact("0").getLastName());
	}
	
	@Test
	void testUpdateAddress() {
		String updatedAddress = "123 Coruscant Way";
		ContactService.addContact(validFirstName, validLastName, validAddress, validPhone);
		ContactService.updateAddressByID("0", updatedAddress);
		
		assertEquals(updatedAddress, ContactService.getContact("0").getAddress());
	}
	
	@Test
	void testUpdatePhone() {
		String updatedPhone = "0987654321";
		ContactService.addContact(validFirstName, validLastName, validAddress, validPhone);
		ContactService.updatePhoneByID("0", updatedPhone);
		
		assertEquals(updatedPhone, ContactService.getContact("0").getPhone());
	}
}
