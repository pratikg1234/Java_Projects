
public class SavingsAccount extends BankAccount{
	private int interestRate;

	public SavingsAccount(int actNumber, double actBalance, Customer customer, int interestRate) {
        super(actNumber, actBalance, customer);
        this.interestRate = interestRate;
    }

	public int getInterestRate() {
		return interestRate;
	}
	

}
