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
		
		System.out.print("Enter hourly wage: ");
		float Wage = scanner.nextFloat();
		
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
		
		double NetAnnualSalary = AnnualSalary - AnnualSalary*0.32 - 1500;
		
		System.out.println("Net Annual salary:        Php " + Deci.format(NetAnnualSalary));
		
		
		}
	}