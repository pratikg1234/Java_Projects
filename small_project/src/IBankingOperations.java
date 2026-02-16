
public interface IBankingOperations {
	public void withDraw(BankAccount bankAccount, int withDrawAmount)  throws AccountNotFoundException, InSufficientFundsException;
    public void deposit(BankAccount bankAccount,int depositAmount) throws AccountNotFoundException;
    public void showBalance(BankAccount bankAccount) throws AccountNotFoundException;
    public void transferFunds(BankAccount accountSource, BankAccount accountTarget,int transferAmount) throws AccountNotFoundException, InSufficientFundsException;
    
    
	
}
