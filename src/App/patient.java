package App;
import java.util.*;



import java.sql.*;
import java.sql.Date;

public class patient{
	
	private int patientid;
	private String patientname;
	private long phone_number;
	private String address;
	private String dateofbirth;
	private int age;
	private String sex;
	private String email;
	private int doctortype;
	private String dateofappointment;
	private String timeofappointment;
	
	private Connection con;
	JDBC jd=new JDBC();
	
	public int getPatientid() {
		return patientid;
	}


	public String getDateofappointment() {
		return dateofappointment;
	}


	public void setDateofappointment(String dateofappointment) {
		this.dateofappointment = dateofappointment;
	}


	public String getTimeofappointment() {
		return timeofappointment;
	}


	public void setTimeofappointment(String timeofappointment) {
		this.timeofappointment = timeofappointment;
	}


	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDiseasetype() {
		return doctortype;
	}

	public void setDiseasetype(int diseasetype) {
		this.doctortype = diseasetype;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public patient() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id :");
		this.patientid=sc.nextInt();
		System.out.println("Enter your name:");
		this.patientname=sc.next();
		System.out.println("Enter your mobile number");
		this.phone_number=sc.nextLong();
		System.out.println("Enter your Address:");
		this.address=sc.next();
		System.out.println("Enter your Date of Birth:");
		this.dateofbirth=sc.next();
		System.out.println("Enter your Age:");
		this.age=sc.nextInt();
		System.out.println("Enter your Sex:");
		this.sex=sc.next();
		System.out.println("Enter your Email:");
		this.email=sc.next();
		System.out.println("Select your Doctor Type:");
		Disease.getall();
		this.doctortype=sc.nextInt();
		
		if(this.doctortype<=6&&this.doctortype>=1)
		{
			Disease.Check(doctortype);
		}
		else
		{
			System.out.println("INVALID INPUT");
		}
		
		System.out.println("Enter Date for Appointment YYYY-MM-DD:");
		this.dateofappointment=sc.next();
		 Date dateValue = Date.valueOf(dateofappointment);
		System.out.println("Enter Time for Appointment HH:MM:SS :");
		this.timeofappointment=sc.next();
		java.sql.Time timeValue = java.sql.Time.valueOf(timeofappointment);
		try
		{
			con=JDBC.getcon();
			PreparedStatement ps1=con.prepareStatement("insert into Patient (id,patient_name,phoneNo,address,dateofbirth,age,sex,email,doctortype,dateofappointment,timeofappointment) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,patientid);
			ps1.setString(2, patientname);
			ps1.setLong(3,phone_number);
			ps1.setString(4, address);
			ps1.setString(5, dateofbirth);
			ps1.setInt(6, age);
			ps1.setString(7, sex);
			ps1.setString(8, email);
			ps1.setInt(9, doctortype);
			ps1.setDate(10, dateValue);
			ps1.setTime(11, timeValue);
			ps1.executeUpdate();
			Appoint p=new Appoint();
			p.query1(patientid,patientname,doctortype,dateofappointment,timeofappointment);
			
		}
		catch(Exception e)
		{
			System.out.println(e+"Error in patient class");
		}
	}

	

}