package Contact;
	
public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;

	/**  
	 * Validates contactID
	 * @param contactID
	 * @return bool
	 * 
	 */
	private Boolean validateContactID(String contactID) {
		if (contactID == null || contactID.length() > 10) {
				return false;
			}
		return true;
	}

	/**  
	 * Validates first name
	 * @param firstName
	 * @return bool
	 * 
	 */
	private Boolean validateFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			return false;
		}
		return true;
	}

	/**  
	 * Validates last name
	 * @param lastName
	 * @return bool
	 * 
	 */
	private Boolean validateLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			return false;
		}
		return true;
	}
	
	/**  
	 * Validates address
	 * @param address
	 * @return bool
	 * 
	 */
	private Boolean validateAddress(String address) {
		if (address == null || address.length() > 30) {
			return false;
		}
		return true;
	}

	/**  
	 * Validates phone number
	 * @param phone
	 * @return bool
	 * 
	 */
	private Boolean validatePhone(String phone) {
		if (phone == null || phone.length() != 10) {
			return false;
		}
		return true;
	}
	
	public Contact (String contactID, String firstName, String lastName, String address, String phone) {
		if (!this.validateContactID(contactID)) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		
		if (!this.validateFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		if (!this.validateLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		if (!this.validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		if (!this.validatePhone(phone)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		
	}
	
	// getters and setters
	// ContactID only has a getter, it is not updatable
	public String getContactID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		if (!validateFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		if (!validateFirstName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		if (!validatePhone(phone)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		if (!validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}

}