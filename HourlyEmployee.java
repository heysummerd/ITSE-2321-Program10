//********************************************************************
//
//Author:        Summer Davis
//
//Program #:     Ten
//
//File Name:     HourlyEmployee.java
//
//Course:        ITSE 2321 Object-Oriented Programming
//
//Description:  HourlyEmployee is a subclass of Employee 
//				This class will manage 3 private instance variables for each object
//				- totalHoursWorked
//				- totalRegularHoursWorked
//				- totalOvertimeHoursWorked
//				Its superclass (Employee) will manage 3 additional private instance 
//				variables for each object
//				- firstName
//				- lastName
//				- payRate
//				** Constructor included for all instance variables
//				** setter included for setHoursWorked
//				** getter included for
//				- totalRegularHoursWorked
//				- totalOvertimeHoursWorked
//				- monthlyRegularPay
//				- monthlyOvertimePay
//
//				Includes methods
//				- calculateMonthlyGrossPay
//			    - calculateMonthlyTaxes
//				- toString (provides a string representation of the object)
//
//********************************************************************

// imports
import java.util.Scanner;

public class HourlyEmployee extends Employee {
	// create Scanner to obtain input
	Scanner input = new Scanner(System.in);
	
	// initialize instance variables
	private double totalHoursWorked = 0;
	private double totalRegularHoursWorked = 0;
	private double totalOvertimeHoursWorked = 0;
	
	//***************************************************************
	//
	//  Method:       HourlyEmployee
	// 
	//  Description:  The constructor of the class
	//				  - intakes firstName, lastName, payRate
	//				  - passes these to superclass constructor
	//
	//  Parameters:   String, String, double
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public HourlyEmployee(String firstName, String lastName, double payRate) {
		// call superclass constructor
		super(firstName, lastName, payRate);	
	} // end of constructor
	
	//***************************************************************
	//
	//  Method:       setTotalHoursWorked
	// 
	//  Description:  The setter for totalHoursWorked instance variable
	//
	//  Parameters:   double
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public void setTotalHoursWorked(double hoursWorked) {
		// validate that hoursWorked is not negative
		if (hoursWorked < 0) {
			throw new IllegalArgumentException("hours worked must be > 0.0");
		}
		// check for overtime
		else if (hoursWorked > 40) {
			this.totalRegularHoursWorked += 40;
			this.totalOvertimeHoursWorked += (hoursWorked - 40);
			this.totalHoursWorked += hoursWorked;
		}
		else {
			this.totalRegularHoursWorked  += hoursWorked;
			this.totalHoursWorked += hoursWorked;
		}
	} // end of setTotalHoursWorked
	
	//***************************************************************
	//
	//  Method:       getTotalRegularHoursWorked
	// 
	//  Description:  The getter for totalRegularHoursWorked instance variable
	//
	//  Parameters:   N/A
	//
	//  Returns:      double 
	//
	//**************************************************************	
	public double getTotalRegularHoursWorked() {
		return totalRegularHoursWorked;
	} // end of getTotalRegularHoursWorked
	
	//***************************************************************
	//
	//  Method:       getTotalOvertimeHoursWorked
	// 
	//  Description:  The getter for totalOvertimeHoursWorked instance variable
	//
	//  Parameters:   N/A
	//
	//  Returns:      double 
	//
	//**************************************************************	
	public double getTotalOvertimeHoursWorked() {
		return totalOvertimeHoursWorked;
	} // end of getTotalOvertimeHoursWorked
	
	//***************************************************************
	//
	//  Method:       getMonthlyRegularPay
	// 
	//  Description:  The getter for monthlyRegularPay instance variable
	//				  - accesses payRate from superclass
	//
	//  Parameters:   N/A
	//
	//  Returns:      double 
	//
	//**************************************************************
	public double getMonthlyRegularPay() {
		return super.getPayRate() * totalRegularHoursWorked;
	} // end of getMonthlyRegularPay
	
	
	//***************************************************************
	//
	//  Method:       getMonthlyOvertimePay
	// 
	//  Description:  The getter for monthlyOvertimePay instance variable
	//			      - accesses payRate from superclass
	//
	//  Parameters:   N/A
	//
	//  Returns:      double
	//
	//**************************************************************
	public double getMonthlyOvertimePay() {
		return super.getPayRate() * 1.5 * totalOvertimeHoursWorked;
	} // end of getMonthlyOvertimePay
	
	//***************************************************************
	//
	//  Method:       calculateMonthlyGrossPay
	// 
	//  Description:  calculates the sum of monthlyRegularPay and monthlyOvertimePay
	//
	//  Parameters:   N/A
	//
	//  Returns:      double
	//
	//**************************************************************
	public double calculateMonthlyGrossPay() {
		return this.getMonthlyRegularPay() + this.getMonthlyOvertimePay();
	} // end of calculateMonthlyGrossPay
	
	//***************************************************************
	//
	//  Method:       calculateMonthlyTaxes
	// 
	//  Description:  calculates the taxRate based on gross pay tier and
	//	              uses the taxRate to calculate the monthlyTaxes
	//
	//  Parameters:   N/A
	//
	//  Returns:      double
	//
	//**************************************************************
	public double calculateMonthlyTaxes() {
		double taxRate;
		if (this.calculateMonthlyGrossPay() > 15_000) {
			taxRate = 0.36;
		}
		else if (this.calculateMonthlyGrossPay() > 10_000) {
			taxRate = 0.31;
		}
		else if (this.calculateMonthlyGrossPay() > 8_000) {
			taxRate = 0.28;
		}
		else if (this.calculateMonthlyGrossPay() > 4_500) {
			taxRate = 0.22;
		}
		else if (this.calculateMonthlyGrossPay() > 2_500) {
			taxRate = 0.15;
		}
		else if (this.calculateMonthlyGrossPay() > 1_200) {
			taxRate = 0.10;
		}
		else {
			taxRate = 0;
		}
		
		return this.calculateMonthlyGrossPay() * taxRate;
	} // end of calculateMonthlyTaxes
	
	//***************************************************************
	//
	//  Method:       toString
	// 
	//  Description:  provides a String representation of the account object
	//				  - overrides the original superclass method
	//
	//  Parameters:   N/A
	//
	//  Returns:      String
	//
	//**************************************************************
	@Override // this method overrides the Employee superclass method
	public String toString()                                             
	{                                                                    
	   return String.format("%-30s            %s %s%n"  // Employee Name
	   					  + "%-30s           $%.2f%n"   // Pay rate
	   					  + "%-30s            %.2f%n"   // Regular Hours
	   					  + "%-30s            %.2f%n"   // Overtime Hours
	   					  + "%-30s           $%,.02f%n" // Regular Pay
	   					  + "%-30s           $%,.02f%n" // Overtime Pay
	   					  + "%-30s           $%,.02f%n" // Gross Pay
	   					  + "%-30s           $%,.02f%n" // Taxes
	   					  + "%-30s           $%,.02f%n",// Net Pay
	      "Employee:", super.getFirstName(), super.getLastName(),
	      "Pay rate:", super.getPayRate(),
	      "Total regular hours worked:", totalRegularHoursWorked,
	      "Total overtime hours worked:", totalOvertimeHoursWorked,
	      "Monthly regular pay:", this.getMonthlyRegularPay(),
	      "Monthly overtime pay:", this.getMonthlyOvertimePay(),
	      "Monthly gross pay:", this.calculateMonthlyGrossPay(),
	      "Monthly taxes:", this.calculateMonthlyTaxes(),
	      "Monthly net pay:", this.calculateMonthlyGrossPay() - this.calculateMonthlyTaxes());
	   } // end of toString
	
}
