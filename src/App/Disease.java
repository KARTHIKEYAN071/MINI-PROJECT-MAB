package App;

import java.sql.*;

import App.JDBC;


public class Disease extends Abs {

	public static void getall() {
		try {
			Connection con=JDBC.getcon();
		PreparedStatement statement = con.prepareStatement("SELECT id,name,specialization,available FROM doctor");
        ResultSet resultSet = statement.executeQuery();
        System.out.println("------------------------------------------------------------");
        while (resultSet.next()) {
        	int id = resultSet.getInt(1);
            String name = resultSet.getString(2);

            String sp = resultSet.getString(3);
            int avail = resultSet.getInt(4);
            System.out.print(id+"-->"+"Doctor Name : "+name+"\n"+"Specilization--->"+sp+"\nAvailable Appointment--->"+avail+"\n");
            System.out.println("------------------------------------------------------------");
		}
		}
		catch(Exception e) {
			 System.out.println(e);
			
		}
	}
	public static void Update(int id) {
		
		String updateQuery = "UPDATE doctor SET Available = Available - 1 WHERE id = ?";
		 try {

			Connection con=JDBC.getcon();
		 PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
	     // Set parameters for the update query
	     preparedStatement.setInt(1, id);
	     // Execute the update query
	     preparedStatement.executeUpdate();
		 }
		 catch(Exception e) {
			 System.out.println("Balance not Updated!!! Try Again");
		 }
	}
public static void Update(String name) {
		
		String updateQuery = "UPDATE doctor SET Available = Available - 1 WHERE name = ?";
		 try {

			Connection con=JDBC.getcon();
		 PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
	     // Set parameters for the update query
	     preparedStatement.setString(1, name);
	     // Execute the update query
	     preparedStatement.executeUpdate();
		 }
		 catch(Exception e) {
			 System.out.println("Balance not Updated!!! Try Again");
		 }
	}
        public static void Check(int id) {
		
		String checkQuery = "select available from doctor WHERE id = ?";
		 try {

			Connection con=JDBC.getcon();
		 PreparedStatement preparedStatement = con.prepareStatement(checkQuery);
	     // Set parameters for the update query
	     preparedStatement.setInt(1, id);
	     // Execute the update query
	     int ava=0;
	     ResultSet rs=preparedStatement.executeQuery();
	     while(rs.next())
	     {
	    	 ava=rs.getInt(1);
	     }
	     if(ava>0)
	     {
	    	 Update(id);
	     }
	     else
	     {
	    	 System.out.println("--------------------------------------");
	    	 System.out.println("|      APPOINTMENT NOT AVAILABLE     |");
	    	 System.out.println("--------------------------------------");
	     }
		 }
		 catch(Exception e) {
			 System.out.println("Balance not Updated!!! Try Again");
		 }
	}
		@Override
		void showstatus(int id) {
			String checkQuery = "select available from doctor WHERE id = ?";
			 try {

				Connection con=JDBC.getcon();
			 PreparedStatement preparedStatement = con.prepareStatement(checkQuery);
		     // Set parameters for the update query
		     preparedStatement.setInt(1, id);
		     // Execute the update query
		     int ava=0;
		     ResultSet rs=preparedStatement.executeQuery();
		     while(rs.next())
		     {
		    	 ava=rs.getInt(1);
		     }
		     if(ava>0)
		     {
		    	 Update(id);
		     }
		     else
		     {
		    	 System.out.println("--------------------------------------");
		    	 System.out.println("|      APPOINTMENT NOT AVAILABLE     |");
		    	 System.out.println("--------------------------------------");
		     }
			 }
			 catch(Exception e) {
				 System.out.println("Balance not Updated!!! Try Again");
			 }
			
		}
		

}
