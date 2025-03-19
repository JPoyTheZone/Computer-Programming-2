import java.util.Scanner;
import java.text.DecimalFormat; 

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//Step1 importing and setting up the scanner
		
		System.out.print("Enter your first name: ");
		String firstName = scanner.nextLine();
		
		System.out.print("Enter your last name: ");
		String lastName = scanner.nextLine();
		
		System.out.print("Enter your age: ");
		int Age = scanner.nextInt();
		
		System.out.print("Enter hours worked: ");
		float Hours = scanner.nextFloat();
		
		//Unrecognized/Invalid Inputs for "Hours Worked"
		if (Hours>24){
			System.out.println("\"Number of hours worked cannot exceed 24 hours\"");
			System.exit(0);
		} 
		else if(Hours<1){
			System.out.println("\"Wrong input on daily work hours \"");
			System.exit(0);
		}
		
		
		System.out.print("Enter hourly wage: ");
		float Wage = scanner.nextFloat();
		
		//RoleCode Match/Case 		
		System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern) : ");
		int RoleCode = scanner.nextInt();
		String Position = "";
		
		switch(RoleCode){
			case 1:
			Position = "Manager";
			break;
			case 2:
			Position = "Supervisor";
			break;
			case 3:
			Position = "Staff";
			break;
			case 4:
			 Position = "Intern";
			 break;
			}

		//Prompts ^
		
		String fullName = firstName + " " + lastName;
		

		int Age2Retire = Math.abs(65 - Age);
		
		float DailySalary = Math.round(Hours * Wage);
		float WeeklySalary = Math.round(Hours * Wage * 5);
		float MonthlySalary = WeeklySalary * 4;
		float AnnualSalary = MonthlySalary * 12;
		//Declaration of extra variables
		
		
		DecimalFormat Deci = new DecimalFormat("0.00");
		//Formatter. Useful later
		
		System.out.println("\nEmployee Information");
		System.out.println("---------------------------------");
		
		System.out.println("Fullname:   " + lastName +", " + firstName);
		
		System.out.println("Age:                "+ Math.abs(Age) +" years old");
		
		System.out.println("Age to retirement: " + Age2Retire+" years");
		
		System.out.println("Daily salary:         Php " + Deci.format(DailySalary));
		
		System.out.println("Weekly salary:        Php " + Deci.format(WeeklySalary));
		
		System.out.println("Monthly salary:        Php " + Deci.format(MonthlySalary));
		
		System.out.println("Gross Annual salary:       Php "+ Deci.format(AnnualSalary));
		
		//net Annual Salary computation
		
		double NetAnnualSalary ;
		
		if (AnnualSalary > 250000){
		NetAnnualSalary = AnnualSalary*(1-0.32) - 1500;
		}
		
		else{
		NetAnnualSalary = AnnualSalary -1500;
		}
		
		
		System.out.println("Net Annual salary:        Php " + Deci.format(NetAnnualSalary));

		
		
		}
	}