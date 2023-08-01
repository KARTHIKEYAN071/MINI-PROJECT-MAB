package App;
import java.util.*;
import java.sql.*;
public class Appoint {

	private int id;
	public void query1(int a,String b,int c,String d,String e)
	{
		
		Scanner s=new Scanner(System.in);
		try
		{
			String name="",spec="";
			JDBC jd=new JDBC();
			Connection con=jd.getcon();
			PreparedStatement ps2=con.prepareStatement("select name,specialization from doctor where id=?");
			ps2.setInt(1,c);
			ResultSet rs=ps2.executeQuery();
			while(rs.next())
			{
				name=rs.getString(1);
				spec=rs.getString(2);
			}
			PreparedStatement ps1=con.prepareStatement("insert into appointment(patientid,patientname,doctername,DateofAppointment,timeofAppointment,diseasetype) values(?,?,?,?,?,?)");
			ps1.setInt(1,a);
			ps1.setString(2,b);
			ps1.setString(3,name);
			ps1.setString(4,d);
			ps1.setString(5,e);
			ps1.setString(6, spec);
			ps1.executeUpdate();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}
