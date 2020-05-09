package bankaccountapp;

public class Savings extends Account {

	//List properties specific to savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	//Constructor to initialize savings account properties
		public Savings(String name,String ssn, double initDeposit) {
			super(name,ssn,initDeposit);
			accountNumber = "1"+accountNumber;
			setSafetyDepositBox();
		}
		
		@Override
		public void setRate() {
			rate = getBaseRate() -.25 ;
		}
		
		private void setSafetyDepositBox() {
			safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
			safetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
		}
		
	//List any method specific to the savings account
		public void showInfo() {
			System.out.println("Account type: Savings");
			super.showInfo();
			System.out.println("Your Savings account features: ");
			System.out.println("Safety deposit Box ID: "+safetyDepositBoxID+
								"\nSafety deposit Box Key: "+safetyDepositBoxKey+
								"\nRate: "+rate);
		}

		
}
