public class AccountNotFoundException extends Exception {
    private String accountNumber;
 
    public AccountNotFoundException(String accountNumber) {
        this.accountNumber = accountNumber;
    }
 
    @Override
    public String toString() {
        return "account not valid " + accountNumber;
    }
}