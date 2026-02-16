
public class DebitCardCheckout implements Checkout{
	public void processPayment(double checkoutAmount) {
		double availableBal = 10000;
		System.out.println("Checkout Process Using Debit Card");
		System.out.println("The Available Balance: "+ availableBal);
		System.out.println("checkoutAmount: "+ checkoutAmount);
		System.out.println("After Deductions: "+ (availableBal-checkoutAmount));
	}

}
