import java.util.*;

public class EntryPoint extends Doctor {
	Scanner sc = new Scanner(System.in);
	boolean isAuthValid = true;

	// Method for authenticating admin
	public void AuthenticateAdmin() {

		String UserName = "admin";
		String password = "admin123";
		String InputUName;
		String InputPass;

		System.out.println("Enter Username : ");
		InputUName = sc.nextLine();
		System.out.println("Enter Password : ");
		InputPass = sc.next();
		if (InputUName.equals(UserName) && InputPass.equals(password)) {
			System.out.println("Authenication Success");
		} else {
			System.err.println("Please enter valid username and password");
			isAuthValid = false;

		}
	}

	void displayOpt() {
		int i = 0;
		short ch;
		if (isAuthValid == true) {
			do {
				System.out.println("1. Manage Doctors ");
				System.out.println("2. Manage Nurses ");
				System.out.println("3. Manage Patients ");
				System.out.println("4. View Patients bill");
				System.out.println("5. Exit");
				System.out.println("Enter Choice : ");
				ch = sc.nextShort();
				System.out.println(ch);
			}while(i != 5);
			
			
		}else {
			System.out.println(" ");
			
		}
	}

	public static void main(String args[]) {
		EntryPoint data = new EntryPoint();
		data.AuthenticateAdmin();
		data.display();
	}

}
