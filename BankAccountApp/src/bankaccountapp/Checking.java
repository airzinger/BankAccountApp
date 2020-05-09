package bankaccountapp;

public class Checking extends Account {
	
	//List properties specific to checking account
	private long debitCardnumber;
	private int debitCardPIN;
	
	//Constructor to initialize checking account properties
	public Checking(String name,String ssn, double initDeposit) {
		super(name,ssn,initDeposit);
		accountNumber = "2"+accountNumber;	
		setDebitCard();
	}
	
	private void setDebitCard() {
		debitCardnumber = (long)((Math.random()*Math.pow(10, 12)));
		debitCardPIN = (int)((Math.random()*Math.pow(10, 4)));
	}

	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
	
	//List any method specific to the checking account
	public void showInfo() {
		System.out.println("Account type: Checking");
		super.showInfo();
		System.out.println("Checking account features: "
				+ "\n Debit card Number: "+debitCardnumber+
					"\n Debit card PIN: "+debitCardPIN+
					"\nRate: "+rate);
			
	}

}
