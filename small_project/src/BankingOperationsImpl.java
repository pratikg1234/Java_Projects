
public class BankingOperationsImpl implements IBankingOperations{
	public void withDraw(BankAccount bankAccount, int withDrawAmount) throws AccountNotFoundException, InSufficientFundsException {
		  if (bankAccount.getActBalance() < withDrawAmount) {
			  throw new InSufficientFundsException(withDrawAmount);
	       }
		  if (bankAccount == null || bankAccount.getActNumber() != 123456) {
			  throw new AccountNotFoundException(String.valueOf(bankAccount.getActNumber()));
	        }
		bankAccount.setActBalance(bankAccount.getActBalance() - withDrawAmount);
        System.out.println("withdraw successful & withdrawal amount is : "+withDrawAmount);
	}
	public void deposit(BankAccount bankAccount,int depositAmount) throws AccountNotFoundException{
		if (bankAccount == null || bankAccount.getActNumber() != 123456) {
			throw new AccountNotFoundException(String.valueOf(bankAccount.getActNumber()));
        }
		bankAccount.setActBalance(bankAccount.getActBalance() + depositAmount);
        System.out.println("deposit successful & deposited amount is : "+depositAmount);
	}
    public void showBalance(BankAccount bankAccount) throws AccountNotFoundException{
    	if (bankAccount == null || bankAccount.getActNumber() != 123456) {
    		throw new AccountNotFoundException(String.valueOf(bankAccount.getActNumber()));
        }
    	System.out.println("Remaining Balance After Transactions : " + bankAccount.getActBalance());
    }
    public void transferFunds(BankAccount accountSource, BankAccount accountTarget,int transferAmount) throws AccountNotFoundException, InSufficientFundsException {
    	if (accountSource == null || accountSource.getActNumber() != 123456) {
    		throw new AccountNotFoundException(String.valueOf(accountSource.getActNumber()));
        }
    	
    	if (accountTarget == null || accountTarget.getActNumber() != 123457) {
    		throw new AccountNotFoundException(String.valueOf(accountTarget.getActNumber()));
        }
    	
    	if (accountSource.getActBalance() < transferAmount) {
    		throw new InSufficientFundsException(transferAmount);
    	}
    	accountSource.setActBalance(accountSource.getActBalance() - transferAmount);
        accountTarget.setActBalance(accountTarget.getActBalance() + transferAmount);
        System.out.println("Transfer successful");
    }
}
