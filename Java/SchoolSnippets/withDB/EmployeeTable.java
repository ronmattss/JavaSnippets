package withDB;

import java.sql.*;

public class EmployeeTable {
 
    public static void main(String[] args) {
 
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try 
        	{
            	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        	}
        
        catch(ClassNotFoundException cnfex) 
        	{	 
	            System.out.println("Problem in loading");
	            cnfex.printStackTrace();
        	}
 
        try 
        	{
	            String msAccDB = "C:\\Users\\ronma\\Documents\\Database1.accdb"; 
	            String dbURL = "jdbc:ucanaccess://" + msAccDB; 
	 
	            connection = DriverManager.getConnection(dbURL); 
	 
	            statement = connection.createStatement();
	 
	            resultSet = statement.executeQuery("SELECT * FROM Table1");
	            
	 
	            System.out.println("ID\tFirst Name\tLast Name\tCarNumber\tBirthdate");
	            
	         //   String id = "23";
	            String fname = "Iron";
	            String lname = "Man";
	            String car = "Titan";
	            String bdyy = "16/02/1990";
	            
	            String sql = "INSERT INTO Table1"+ "(First_Name,Last_Name,Car_Number,Bday) "
	    	            +"VALUES ('"+fname+"', '"+lname+"', '"+car+"', '"+bdyy+"')";
	            
	            statement.executeUpdate(sql);
	            while(resultSet.next()) 
		            {
		                System.out.print("\n"+resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+ 
		                        resultSet.getString(3)+"\t\t" +
		                        resultSet.getString(4)+"\t" + resultSet.getString(5));
		            }
        	}
        
        catch(SQLException sqlex)
	        {
	            sqlex.printStackTrace();
	        }
        
        finally 
	        {
	
	            try 
		            {
		                if(null != connection) 
			                {		            
			                    resultSet.close();
			                    statement.close();
			                    connection.close();
			                }
		            }
	            catch (SQLException sqlex) 
		            {
		                sqlex.printStackTrace();
		            }
	        }
    }
}
