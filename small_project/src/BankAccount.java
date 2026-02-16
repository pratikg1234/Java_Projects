
abstract public class BankAccount {
	private int actNumber;  
    private double actBalance;
    private Customer customer;
    public BankAccount() {
    	
    }
	public BankAccount(int actNumber, double actBalance, Customer customer) {
		super();
		this.actNumber = actNumber;
		this.actBalance = actBalance;
		this.customer = customer;
	}
	public int getActNumber() {
		return actNumber;
	}
	
	public double getActBalance() {
		return actBalance;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setActBalance(double actBalance) {
        this.actBalance = actBalance;
    }
    
}
