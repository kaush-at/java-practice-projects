import java.io.Console;
import java.util.Scanner;

public class CreateEmailAddress {

	public static void main(String[] args) {
		String company = "ABC Company";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("****************Welcome to  "+ company+"*********************");
		
		
		System.out.println("Enter your First name :");
		String firstName = sc.next();
		
		System.out.println("Enter your Last name :");
		String lastName = sc.next();
		
		System.out.println("Enter your working Department :");
		String department = sc.next();
		
		Email email = new Email(firstName,lastName,department, company);
		
		System.out.println("***Please Reset your password***");
		
		String pass ,pass2;
		while(true) {
			
			System.out.println("Enter your new password : ");
			pass = sc.next();
			System.out.println("Confirm your password");
			pass2 = sc.next();
			
			if(pass.equals(pass2)) {
				break;
				}
			System.out.println("Confirm password should be same as password");
		}
		
		email.changePassword(pass);
		System.out.println("Password has been reset as " + email.getPassword());
		
		System.out.println(email.showInfo());

	}

}
