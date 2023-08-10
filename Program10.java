//********************************************************************
//
//Author:        Summer Davis
//
//Program #:     Ten
//
//File Name:     Program10.java
//
//Course:        ITSE 2321 Object-Oriented Programming
//
//Description:   Program10 leverages the HourlyEmployee subclass to accomplish the following:
//				 - Collect employee first and last name
//				 - Collect employee pay rate
//				 - Create new HourlyEmployee object
//				 - Collect weekly hours worked (x4) from user
//               - Print employee monthly report
//
//********************************************************************

// imports
import java.util.Scanner;

public class Program10 {
	
	// create Scanner to obtain input
	private Scanner input = new Scanner(System.in);
	
	//***************************************************************
	//
	//  Method:       main
	// 
	//  Description:  The main method of the program
	//
	//  Parameters:   String array
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public static void main(String[] args) {
		
		// create Program10 object in order to call non-static methods
		Program10 program10 = new Program10();
		
		// display developer info
		developerInfo();
		
		// collect first and last name
		String firstName = program10.getEmployeeFirstName();
		String lastName = program10.getEmployeeLastName();
		
		// collect pay rate
		double payRate = program10.getEmployeePayRate();
		
		// create new Hourly Employee Record
		HourlyEmployee hourlyEmployee = new HourlyEmployee(firstName, lastName, payRate);
		
		// set total hours worked
		program10.enterMonthlyHours(hourlyEmployee);
		
		// print employee report
		program10.printEmployeeReport(hourlyEmployee);
		
	}
	
	//***************************************************************
	//
	//  Method:       getEmployeeFirstName
	// 
	//  Description:  collects firstName input from user
	//
	//  Parameters:   None
	//
	//  Returns:      String 
	//
	//**************************************************************
	public String getEmployeeFirstName() {
		System.out.print("Enter employee first name: ");
		String firstName = input.next();
		return firstName;
	} // end of getEmployeeFirstName
	
	//***************************************************************
	//
	//  Method:       getEmployeeLastName
	// 
	//  Description:  collects lastName input from user
	//
	//  Parameters:   None
	//
	//  Returns:      String 
	//
	//**************************************************************
	public String getEmployeeLastName() {
		System.out.print("Enter employee last name: ");
		String lastName = input.next();
		return lastName;
	} // end of getEmployeeLastName
	
	//***************************************************************
	//
	//  Method:       getEmployeePayRate
	// 
	//  Description:  collects payRate input from user
	//
	//  Parameters:   None
	//
	//  Returns:      double
	//
	//**************************************************************
	public double getEmployeePayRate() {
		System.out.print("Hourly rate: $");
		double payRate = input.nextDouble();
		return payRate;
	} // end of getEmployeePayRate
	
	//***************************************************************
	//
	//  Method:       enterMonthlyHours
	// 
	//  Description:  collects & sets hours worked input from user
	//
	//  Parameters:   HourlyEmployee object
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public void enterMonthlyHours(HourlyEmployee hourlyEmployee) {
		// start by collecting week 1 hours
		int week = 1;
		// continue each week for 4 weeks
		while (week <= 4) {
			System.out.printf("Enter hours worked for Week #%d: ", week);
			++week;
			hourlyEmployee.setTotalHoursWorked(input.nextDouble());
		}
	} // end of enterMonthlyHours
	
	//***************************************************************
	//
	//  Method:       printEmployeeReport
	// 
	//  Description:  collects & prints employee monthly report
	//
	//  Parameters:   HourlyEmployee object
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public void printEmployeeReport(HourlyEmployee hourlyEmployee) {
		System.out.print(hourlyEmployee.toString());
	} // end of printEmployeeReport
	
	//***************************************************************
	//
	//  Method:       developerInfo
	// 
	//  Description:  The developer information method of the program
	//
	//  Parameters:   None
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public static void developerInfo()
	   {
	      System.out.println("Name:    Summer Davis");
	      System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
	      System.out.println("Program: Ten \n");
	   } // End of developerInfo
}
