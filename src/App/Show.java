package App;
import java.util.*;
import java.sql.*;
public class Show extends JDBC {

	Show()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=s.nextInt();
		JDBC jd=new JDBC();
		Connection con=jd.getcon();
		try
		{
			
			PreparedStatement ps1=con.prepareStatement("select * from appointment where patientid=?");
			ps1.setInt(1,id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				System.out.println("-------------------------------------------");
				System.out.println("|         YOUR APPOINTMENT DETAILS        |");
				System.out.println("-------------------------------------------");
				System.out.print("APPOINTMENT ID\t\t-->\t"+rs.getInt(1)+"\n-------------------------------------------\nPATIENT NAME\t\t-->\t"+rs.getString(3)+"\n-------------------------------------------\nDOCTER NAME\t\t-->\t"+rs.getString(4)+"\n-------------------------------------------\nDATE OF APPOINTMENT\t-->\t"+rs.getString(5)+"\n-------------------------------------------\nTIME OF APPOINTMENT\t-->\t"+rs.getString(6)+"\n-------------------------------------------\nAPPOINTMENT FOR\t\t-->\t"+rs.getString(7)+"\n-------------------------------------------\nSTATUS\t\t\t-->\t"+rs.getString(8));
			}
			System.out.println();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
