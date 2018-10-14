import java.util.*;
import java.sql.*;

public class Doctor {
	static Scanner sc = new Scanner(System.in);
	static int id;
	static int age;
	static int salary;
	static String faculty;
	static String name;

	// Method for adding doctors
	void addDoctor() {
		int x;
		System.out.println("Enter Number of Doctors you want to add : ");
		x = sc.nextInt();

		for (int i = 0, j = 1; i < x; i++, j++) {
			System.out.println("Enter Information of Doctor Number : " + j);

			System.out.println("Enter ID number : ");
			id = sc.nextInt();

			System.out.println("Enter Name of Doctor : ");
			name = sc.next();

			System.out.println("Enter age of Doctor : ");
			age = sc.nextInt();

			System.out.println("Enter salary of Doctor : ");
			salary = sc.nextInt();

			System.out.print("Enter Faculty of Doctor : ");
			faculty = sc.next();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
				// the mysql insert statement
				String query = "insert into doctor (Id,Name,Age,Salary,Faculty)" + " values (?, ?, ?, ?, ?)";

				// create the mysql insert preparedstatement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, id);
				preparedStmt.setString(2, name);
				preparedStmt.setInt(3, age);
				preparedStmt.setInt(4, salary);
				preparedStmt.setString(5, faculty);
				preparedStmt.execute();
			} catch (Exception e) {
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		}
		// con.close();
	}

	// Display doctors
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
				System.out.println("Information of doctor ");
				System.out.println("ID number : " + rs.getString(1));
				System.out.println("Doctor Name : " + rs.getString(2));
				System.out.println("Age : " + rs.getInt(3));
				System.out.println("Salary : " + rs.getInt(4));
				System.out.println("Faculty : " + rs.getString(5));
				i++;
			}
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

	}

	// Method for Searching doctors(Linear Search)
	void search() {
		System.out.println("Enter ID number of doctor : ");
		int id = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from doctor where Id = " + id);
			while (rs.next()) {
				// Displaying Records
				System.out.println(" ");
				System.out.println("Information of doctor ");
				System.out.println("ID number : " + rs.getString(1));
				System.out.println("Doctor Name : " + rs.getString(2));
				System.out.println("Age : " + rs.getInt(3));
				System.out.println("Salary : " + rs.getInt(4));
				System.out.println("Faculty : " + rs.getString(5));
			}
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

	}

	void update() {

	}

	public static void main(String[] args) {

		short choice;
		Doctor data = new Doctor();

		// Printing Menu
		do {
			System.out.println("1. Add doctor ");
			System.out.println("2. Display All doctors ");
			System.out.println("3. Search Doctor ");
			System.out.println("4. Exit ");
			System.out.println("Enter your choice :");
			choice = sc.nextShort();
			switch (choice) {
			case 1:
				data.addDoctor();
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

/*
 * String query = "update users set num_points = ? where first_name = ?";
 * PreparedStatement preparedStmt = conn.prepareStatement(query);
 * preparedStmt.setInt (1, 6000); preparedStmt.setString(2, "Fred");
 */
