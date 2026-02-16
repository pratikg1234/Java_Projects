
public class BankAccountMain1 {
public static void main(String[] args) {
	BankAccount b1 = new BankAccount();
	b1.customerName = "Pratik";
	b1.actBalance=1000;
	b1.actNumber=111;
	b1.withdraw(100.00);
	b1.deposit(200.00);
}
}
