import java.util.Random;

public class Email {

	private String firstName;
	private String lastName;
	private String department;
	private String company;
	private String email;
	private String password;
	private String alternateEmail;
	private int mailboxCapacity = 500;

	private int passwordLength = 10;

	// constructor to recieve the first name and last name
	public Email(String firstName, String lastName, String department, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.company = company;
		this.password = generatePassword2(passwordLength);

		System.out.println("your temperory password is " + password);  			
		createEmail();
	}

	// create email
	public String createEmail() {

		email = this.firstName.toLowerCase() + "." 
				+ this.lastName.toLowerCase() + "@"
				+ this.department.toLowerCase() + "." 
				+ this.company.toLowerCase().replace(" ", "") + ".com";

		return email;

	}

	// generate random passwords - method1
	private String generatePassword() {

		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";

		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * passwordSet.length());
			salt.append(passwordSet.charAt(index));
		}
		String saltStr = salt.toString();

		return saltStr;

	}

	// generate random password method2
	private String generatePassword2(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[] passwordArr = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			passwordArr[i] = passwordSet.charAt(rand);
		}

		return new String(passwordArr);

	}

	// get the full name
	public String getFullName() {
		String fName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
		String lName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);

		return fName + " " + lName;
	}

	// set mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// setting up Alternate Email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// change password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}

	// get the mailbox capacity
	public int getMailBoxCapacity() {
		return this.mailboxCapacity;
	}
	
	// get the Alternate Email
	public String getAlternateEmail() {
		return this.alternateEmail;
	}
	
	// get the password
	public String getPassword() {
		return password;
	}
	
	// get the emai
	public String getEmail() {
		return email;
	}

	public String showInfo() {
		return "Email created for '"+getFullName()+"' as '"+ getEmail() +"' with capacty "+getMailBoxCapacity()+"mb";
	}


}
