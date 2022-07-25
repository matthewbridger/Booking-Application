

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

public void  makeConnection()  {
	    	try {
	    		Class.forName("");
	    		String url ="";
	    		connection = DriverManager.getConnection(url, "", "" );
	    		  statement = connection.createStatement();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    		  
	    }
public String getEmail(String userID) {
String email = "";
 
 
try {
makeConnection();
 resultSet = statement.executeQuery("select Email from patients where UserID ='"+userID+"'"); 
while (resultSet.next()) {
	email = resultSet.getString("Email");
}
} catch (Exception e) {
e.printStackTrace();
}
 return email;
}

public String checkBooking(String booking) {
	String BID = "";
	String DocID = "";
	String TheDate = "";
	String TheTime = "";
	String output = " ";
	
	try {
		makeConnection();
		resultSet = statement.executeQuery("select * from booking where TheDate='"+booking+"'"); 
		while (resultSet.next()) {
			// How many result came back, if more than 0, save in SESSION
			 BID = resultSet.getString("BID");
			 DocID = resultSet.getString("DocID");
			 TheDate = resultSet.getString("TheDate");
			 TheTime = resultSet.getString("TheTime");
			  output = BID + " " + DocID + " " + TheDate + " " + TheTime;
			  
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return output;
}
	
public String checkLogin(Patient patient) {
		String loggedInUser = "";
		
		try {
			makeConnection();
			resultSet = statement.executeQuery("select * from logindetails where UserID='"+patient.getUserId()+"' and PassID='"+patient.getUniqueId()+"' and Psswrd='"+patient.getPassword()+"'"); 
			while (resultSet.next()) {
				// How many result came back, if more than 0, save in SESSION
				loggedInUser = resultSet.getString("UserID");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loggedInUser;
	}
	
public boolean registerUser(Patient patient) {
		
		try {
			makeConnection();
			return statement.execute("insert into logindetails (UserID, Psswrd, PassID, AssignedDoctor) values ('"+patient.getUserId()+"', '"+patient.getPassword()+"', '"+patient.getUniqueId()+"', '"+patient.getDoctorName()+"' )");
			//return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

public boolean CheckUniqueId(String unique) {
	
	String id = "";
	try {
		makeConnection();
		resultSet = statement.executeQuery("select * from logindetails where PassID='"+unique+"'"); 
		while (resultSet.next()) {
			id = resultSet.getString("PassID");
			if(id.length() > 0) {
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
	

}

public boolean ChangeCurrentDoctor(Patient patient){
			try {
				makeConnection();
			return statement.execute(" update Logindetails set AssignedDoctor = '"+patient.getDoctorName()+"' where UserID = '"+patient.getUserId()+"' ");
			//return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
}
	
	
	public void testConnection() {
		try {
			makeConnection();
			resultSet = statement.executeQuery("select * from booking; ");
			
			while (resultSet.next())
				System.out.println(resultSet.getString("BID") + " - " + resultSet.getString("TheDate") + " - " + resultSet.getString("TheTime"));
				System.out.println("Connected Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		}
	
}
