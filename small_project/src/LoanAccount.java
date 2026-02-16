
public class LoanAccount extends BankAccount{
	private int actualLoanAmount;
    private int paidLoanAmount;
	public LoanAccount(int actualLoanAmount, int paidLoanAmount) {
		super();
		this.actualLoanAmount = actualLoanAmount;
		this.paidLoanAmount = paidLoanAmount;
	}
	public int getActualLoanAmount() {
		return actualLoanAmount;
	}
	public int getPaidLoanAmount() {
		return paidLoanAmount;
	}
	

}
