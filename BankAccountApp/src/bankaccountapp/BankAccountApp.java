package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		/*Checking check1 = new Checking("Tom Wilson","365285628",2000);
		//check1.
		Savings sav1 = new Savings("Richie Rich","8595685956",1500);
		
		check1.showInfo();
		System.out.println("*************************************************");
		sav1.showInfo();
		sav1.compound();
		*/
	
		//Read a csv file and create accounts based on the data
		String file = "C:\\Users\\DELL NOTEBOOK\\eclipse-workspace\\BankAccountApp\\src\\utilities\\resources\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		//System.out.println("New Accounts created: ");
		for(String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String ssn =accountHolder[1];
			String accountType =accountHolder[2];
			double initDeposit = Double.parseDouble((accountHolder[3]));
			//System.out.println(name+" "+ssn+" "+accountType+" "+initDeposit);
			
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name,ssn,initDeposit));
			}
			else if(accountType.contentEquals("Checking"))
				accounts.add(new Checking(name,ssn,initDeposit));
			else
				System.out.println("Error reading the account type");
		}
		
		for(Account acc : accounts) {
			System.out.println("*********************************************************");
			acc.showInfo();
		}
	}

}
