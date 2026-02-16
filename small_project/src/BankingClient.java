
public class BankingClient {
	public static void main(String[] args) {
		Address address1 = new Address("Pune", 411001);
		Address address2 = new Address("Mumbai", 413021);
        Customer customer1 = new Customer("Pratik", 1, address1);
        Customer customer2 = new Customer("Pratik", 1, address2);
        
        SavingsAccount account1 = new SavingsAccount(123456, 5000.0, customer1, 5);
        SavingsAccount account2 = new SavingsAccount(123456, 3000.0, customer2, 5);

        IBankingOperations bankingOperations = new BankingOperationsImpl();
        
        System.out.println("Original Bank Balance Before Doing Any Transactions: ");
        System.out.println("In account 1 : "+account1.getActBalance());
        System.out.println("In account 2 : "+account2.getActBalance());
        try {
			bankingOperations.deposit(account1, 1000);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        try {
			bankingOperations.withDraw(account1, 2000);
		} catch (InSufficientFundsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        try {
			bankingOperations.showBalance(account1);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}//4000
        try {
			bankingOperations.transferFunds(account1, account2, 500);
		} catch (InSufficientFundsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        try {
			bankingOperations.showBalance(account2);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
