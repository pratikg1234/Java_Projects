
public class BankAccount {
	int actNumber;
	String customerName;
	double actBalance;
	public void withdraw(double howMuch) {
		if(actBalance< howMuch) {
			System.out.println("You cant withdraw as balance is low...");
		}
		else {
			System.out.println("Hello, "+customerName);
			System.out.println("Available balance before withdraw: "+ actBalance);
			actBalance-= howMuch;
			System.out.println("Available balance after withdraw: "+actBalance);
		}
		
	}
	public void deposit(double howMuch) {
		actBalance+=howMuch;
		System.out.println("After deposit: "+ actBalance);
	}
}
