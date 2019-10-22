package withDB;

import java.sql.*;

public class ConnectDB {
	

	public static void main(String[] args) throws Exception {
		
		
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://C://Users//ronma//Documents//Database.accdb";
			
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * from Employee");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"
			                      +rs.getString(2)+"\t"
						          +rs.getString(3)+"\t"
						          +rs.getString(4)+"\t"
						          +rs.getString(5));
			}
			try {
				String ID = "id1";
				String FIRST = "first";
				String lname = "last";
				String car = "car";
				String years = "years";
				
				String query = "INSERT INTO Employee(ID, FIRST, LAST, CAR, YEARS) VALUES('"+ID+"' '"+FIRST+"' '"+lname+"' '"+car+"' '"+years+"' )";
				s.executeUpdate(query);
				
				
				System.out.print("SUCCESS");
				
			}
			catch (Exception e) {
				System.out.print("FAIL");
				
			}
		}					
		
}


