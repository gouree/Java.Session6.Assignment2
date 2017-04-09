/*
 * 1. Create a class BankAtm with following properties and methodsProperties:

atmId;
bankName;
location;
balance
Methods:
withdraw(double amt)
deposit(double amt)
The withdraw method should check the available balance in the ATM before
deducing the amount from the balance. If the balance is less than 10000 the
withdrawal should not be allowed and a user defined exception
BankATMException should be thrown. The withdrawal should also not be allowed
if the amount to be withdrawn is greater than balance.
Create a user defined exception class BankATMException class that will be
created whenever withdrawal is done for balance less than 10000.
Create an application Bank having 3 BankAtm objects. Every time withdraw
method is called on the BankAtm object the balance should be subtracted.
Generating BankATMException whenever withdrawal is done for balance less
than 10000.
 */


//Created an exception class bankATMException which displays error message whenever exception occurs
class bankATMException extends Exception
{
	bankATMException(String s)
	{  
		  super(s);
	}
}

//bankATM class
public class BankAtm

{
	String atmId,bankName,location;
	double balance;
	
	public static void main(String args[])
	{
		
		//create 3 objects and pass the balance to parameterized constructor
		BankAtm b1= new BankAtm(20000);
		BankAtm b2= new BankAtm(10000);
		BankAtm b3= new BankAtm(40000); 
		
		//try and catch blocks for statements which might cause erorrs
		try
		{
		System.out.println("Object 1");
		System.out.println("*********");
		
		//operations on object 1
		b1.withdraw(5000);
		b1.deposit(10000);
		
		//operations on object 1
		System.out.println("Object 2");
		System.out.println("*********");
		b2.deposit(15000);
		b2.deposit(5000);
		b2.withdraw(10000);
		
		
		//operations on object 1
		System.out.println("Object 3");
		System.out.println("*********");
		b1.withdraw(50000);
		
		
		}
		
		catch(Exception e)
		{
			System.out.println("Exception occured " +e);
		}
			
	}
	
	//parameterized constructor
	BankAtm(double val)
	{
		balance=val;
	}
	
	
	/* withdraw method which will allow withdrawal only if amount <= balance
	 * also if balance < 10000 withdrawal is not allowed
	 * withdrawal method throws exception 
	 */
	void withdraw(double amt) throws bankATMException 
	{
		
			System.out.println("Balance before withdrawal --->"+balance);
			if(balance<10000||amt>balance)
			{
				
				System.out.println("throwing exception");
				amt=0;
				throw new bankATMException("Cannot withdraw the amount");
			}
			else
			{
				balance= balance-amt;
			}
			
			System.out.println("Balance after withdrawal --->"+balance);
			System.out.println("amount withdrawn --->"+amt);
			
					
	}
	
	
	//deposit method to deposit amount 
	void deposit(double amt)
	{
		System.out.println("Balance before deposit --->"+balance);
		balance=balance+amt;
		System.out.println("Balance after deposit --->"+balance);
	}
}



