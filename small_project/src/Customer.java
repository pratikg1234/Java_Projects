
public class Customer {
	private String customerName;
    private int customerNumber;
    private Address customerAddress;
	public Customer(String customerName, int customerNumber, Address customerAddress) {
		super();
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.customerAddress = customerAddress;
	}
	public String getCustomerName() {
		return customerName;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	public Address getCustomerAddress() {
		return customerAddress;
	}
	
    
}
