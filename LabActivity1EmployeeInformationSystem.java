import java.util.Scanner ;

public class Main {
	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in)	;
	//Create an instance of Scanner object
	System.out.print( "Enter your first name: ");
	String Name = scanner.nextLine();
	//Printing name
	
	System.out.print("Enter your last name: ");
	String LastName = scanner.nextLine();
	//Printing last name
	
	System.out.print("Enter your age: ");
	int Age = scanner.nextInt();
	//Printing Age
	
	System.out.print("Enter hours worked: ");
	float HoursWorked = scanner.nextFloat();
	//Printing Hours
	
	System.out.print("Enter hourly wage: ");
	float Wage = scanner.nextFloat();
	//Printing Hourly Wage
	
	System.out.println("\nEmployee Information \n---------------------");
	
	System.out.println("Full Name   : " + Name +" "+ LastName);
	System.out.println("Age        : " + Age + " years old");
	System.out.println("Daily Salary: " + HoursWorked * Wage);
	//Output
	}
}