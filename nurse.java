import java.util.*;
import java.sql.*;

public class nurse {
 	
	static Scanner sc = new Scanner(System.in);
	static int id;
	static int age;
	static int salary;
	static String faculty;
	static String name;

	// Method for adding records 
	void addNurse() {
		int x;
		System.out.println("Enter Number of Nurses you want to add : ");
		x = sc.nextInt();

		for (int i = 0, j = 1; i < x; i++, j++) {
			System.out.println("Enter Information of Nurse Number : " + j);

			System.out.println("Enter ID number : ");
			id = sc.nextInt();

			System.out.println("Enter Name of Nurse : ");
			name = sc.next();

			System.out.println("Enter salary of Nurse : ");
			salary = sc.nextInt();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
				// the mysql insert statement
				String query = "insert into nurses (Id,Name,Salary)" + " values (?, ?,?)";

				// create the mysql insert preparedstatement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, id);
				preparedStmt.setString(2, name);
				preparedStmt.setInt(3, salary);
				preparedStmt.execute();
			} catch (Exception e) {
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		}
	

	// Method for searching nurses 
	void search(){
		System.out.println("Enter Id of nurse : ");
		int temp = sc.nextInt();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
				Statement stmt = con.createStatement();
				String query = "select * from nurse where Id = " + id;
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					// Displaying Records
					System.out.println(" ");
					System.out.println("Information of Nurse :");
					System.out.println("ID number : " + rs.getString(1));
					System.out.println("Nurse Name : " + rs.getString(2));
					System.out.println("Salary : " + rs.getInt(3));
			} catch (Exception e) {
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		
	}
	//Method for fetching records and displaying records from nurse database 
	
	void display() {
		int j;
		System.out.println("Enter Number of records you want to check");
		j = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from doctor where Id");
			int i = 0;
			while (rs.next() && i < j) {
				// Displaying Records
				System.out.println(" ");
				System.out.println("Information of Nurse :");
				System.out.println("ID number : " + rs.getString(1));
				System.out.println("Nurse Name : " + rs.getString(2));
				System.out.println("Salary : " + rs.getInt(3));	
				i++;
			}
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

	}


	public static void main(String[] args) {	
		
		nurse data = new nurse();
		short choice;
		do {
			System.out.println("1. Add Nurse ");
			System.out.println("2. Display Nurses ");
			System.out.println("3. Search Nurse ");
			System.out.println("4. Exit ");
			System.out.println("Enter your choice :");
			choice = sc.nextShort();
			switch (choice) {
			case 1:
				data.addNurse();
				break;
			case 2:
				data.display();
				break;
			case 3:
				data.search();
				break;
			case 4:
				System.out.println("Good Bye");
				break;
			default:
				System.out.println("Invalid Input ");

			}

		} while (choice != 4); 
	}	

}
