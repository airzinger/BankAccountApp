package bankaccountapp;

public abstract class Account implements IBaseRate {
	
	//List common properties for savings and checking account
	private String name;
	private String ssn;
	private double balance;
	protected String accountNumber;
	private static int index=10000;
	protected double rate;
	
	//Constructor to set our base properties and initialize the account
	public Account(String name,String ssn, double initDeposit) {
		this.name=name;
		this.ssn=ssn;
		this.balance=initDeposit;
		System.out.println();
		
		//Set Account number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
		public abstract void setRate();
	
	//List common methods -transactions
		public void compound() {
			double accruedInterest = balance * rate/100;
			System.out.println("Your accrued interest on the balance amount is "+accruedInterest);
			balance+=accruedInterest;
			printBalance();
		}
		
		
		public void deposit(double amount) {
			balance+=amount;
			System.out.println("Depositing amount "+amount);
			printBalance();
		}
		
		public void withdraw(double amount) {
			System.out.println("Withdrawing amount "+amount);
			balance-=amount;
		}
		
		public void transfer(String destAccount, double amount) {
			balance-=amount;
			System.out.println("Amount successfully transferred to "+destAccount+" account ");
		}
		
		public void printBalance() {
			System.out.println("Your balance is now "+balance);
		}

	private String setAccountNumber() {
		String lastTwoOfssn = ssn.substring(ssn.length()-2, ssn.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfssn + uniqueID + randomNumber;
	}
	
	public void showInfo() {
		System.out.println("Name is: "+name+" SSN: "+ssn+" Balance: "+balance+" Account Number: "+accountNumber); 
	}

}
