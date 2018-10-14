import java.sql.*;  
class DbCon{  
	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");   
			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from emp");  
			
			System.out.println("ID" + " " + "Name ");
			int i = 0;
			while(rs.next() && i != 4) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				i++;
			}
				con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}  
}  