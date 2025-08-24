package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.Contact;

public class ContactTest {
	
	// Valid parameters to cut down on redundant code
	private String validContactID = "1001";
	private String validFirstName = "Anakin";
	private String validLastName = "Skywalker";
	private String validAddress = "300 Mustafar Place";
	private String validPhone = "1234567890";
	
	@Test
	void testValidContact() {
		Contact testContact = new Contact(validContactID, validFirstName, validLastName, validAddress, validPhone);
		
		assertEquals(validContactID, testContact.getContactID());
		assertEquals(validFirstName, testContact.getFirstName());
		assertEquals(validLastName, testContact.getLastName());
		assertEquals(validAddress, testContact.getAddress());
		assertEquals(validPhone, testContact.getPhone());
		
	}
	
	@Test
	void testInvalidContactID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Illegal Contact ID", validFirstName, validLastName, validAddress, validPhone);
		});		}
	
	@Test
	void testInvalidFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(validContactID, "Illegal First Name", validLastName, validAddress, validPhone);
		});		}
	
	@Test
	void testInvalidLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(validContactID, validFirstName, "Illegal Last Name", validAddress, validPhone);
		});		}
	
	@Test
	void testInvalidAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(validContactID, validFirstName, validLastName, "Illegal Address that is way too long", validPhone);
		});		}
	
	@Test
	void testInvalidPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(validContactID, validFirstName, validLastName, validAddress, "Illegal Phone Number");
		});		}
	
	// Test contact to cut down on redundant code
	Contact testContact = new Contact(validContactID, validFirstName, validLastName, validAddress, validPhone);
	
	@Test
	void testSetInvalidFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setFirstName("Illegal First Name");
		});		}
	
	@Test
	void testSetInvalidLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName("Illegal Last Name");
		});		}
	
	@Test
	void testSetInvalidAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setAddress("Illegal Address that is way too long");
		});		}
	
	@Test
	void testSetInvalidPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setPhone("Illegal Phone Number");
		});		}
	

    @Test
    void testSetFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContact.setFirstName(null);
        });
    }

    @Test
    void testSetLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContact.setLastName(null);
        });
    }

    @Test
    void testSetAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContact.setAddress(null);
        });
    }

    @Test
    void testSetPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhone(null);
        });
    }

}