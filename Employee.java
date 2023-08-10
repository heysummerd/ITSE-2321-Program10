//********************************************************************
//
//  Developer:            Instructor
//
//  Program #:            Ten
//
//  File Name:            Employee.java
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Instructor:           Fred Kumi 
//
//  Description:
//     Employee class.  Please do NOT modify this Class.  If you
//     do, you will not receive credit for Program 10.
//
//********************************************************************

/**
 * The Class Employee.
 */
public class Employee extends Object
{
   /** The first name. */
   private String firstName;
   
   /** The last name. */
   private String lastName;
   
   /** The pay rate. */
   private double payRate;

   /**
    * Instantiates a new employee.
    */
   public Employee()
   {
	  this.firstName = "";
	  this.lastName = "";
	  this.payRate = 0.0;
   }
   
   /**
    * Instantiates a new employee.
    *
    * @param firstName the first name
    * @param lastName the last name
    * @param payRate the pay rate
    * @param totalHours the hours worked
    */
   public Employee(String firstName, String lastName, double payRate)
   {
      if (payRate < 0.0) 
         throw new IllegalArgumentException("Pay rate must be > 0.0");
      else if (payRate < 7.25)
	      payRate = 7.25;
	  
      this.firstName = firstName;
      this.lastName = lastName;
      this.payRate = payRate;
   } // end constructor

   /**
    * Sets the first name.
    *
    * @param firstName the new first name
    */
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   /**
    * Sets the last name.
    *
    * @param lastName the last name
    * @return the last name
    */
    public void setLastName(String lastName)
   {
      this.lastName = lastName;
   } 

   /**
    * Gets the first name.
    *
    * @return the first name
    */
   public String getFirstName()
   {
      return firstName;
   }

   /**
    * Gets the last name.
    *
    * @return the last name
    */
   public String getLastName()
   {
      return lastName;
   } 

   /**
    * Sets the pay rate.
    *
    * @param payRate the new pay rate
    */
   public void setPayRate(double payRate)
   {
      if (payRate < 0.0) 
         throw new IllegalArgumentException("Pay rate must be >= 0.0");
      else if (payRate < 7.25)
	     this.payRate = 7.25;
      else
		 this.payRate = payRate;
   } 

   /**
    * Gets the pay rate.
    *
    * @return the pay rate
    */
   public double getPayRate()
   {
      return payRate;
   } 

   /**
    *  
    * Returns the String representation of an Employee object.
    *
    * @return the string
    */         
   @Override // indicates that this method overrides a superclass method
   public String toString()                                             
   {                                                                    
      return String.format("%s: %s %s%n%s: %.2f",
         "Employee", firstName, lastName,
         "Pay rate", payRate);
   }
} // End class Employee

