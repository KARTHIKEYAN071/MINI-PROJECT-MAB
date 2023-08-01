package App;
import java.util.*;

public class Main {
	
	public static void main(String [] args)
	{
		int option=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Medical Appointment Booking...>>");
		while(true)
		{
			System.out.println("Enter 1--->New Appointment\nEnter 2---> See Appointment Status\nEnter 3--->Exit The Application");
			option=sc.nextInt()	;
			if(option==1)
			{
				System.out.println("<---------Enter your Details-------->");
				patient s=new patient();
				System.out.println("--------------------------------------");
				System.out.println("|   APPOINTMENT ADDED SUCCESSFULLY.  |");
				System.out.println("--------------------------------------");
				System.out.println();
			}
			else if(option==2)
			{
				Show sh=new Show();
				System.out.println("-------------------------------------------");
				System.out.println();
			}
			else if(option==3)
			{
				System.out.print("<-----Thank You For Visting----->");
				System.exit(0);
			}
			else 
			{
				System.out.println("<------Invalid input------>");
			}
			
		}
	}
	

}