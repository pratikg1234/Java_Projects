
public class CreditCardCheckout implements Checkout {

	public void processPayment(double checkoutAmount) {
		double availableBal = 20000;
		System.out.println("Checkout Process Using Credit Card");
		System.out.println("The Available Balance: "+ availableBal);
		System.out.println("checkoutAmount: "+ checkoutAmount);
		System.out.println("After Deductions: "+ (availableBal-checkoutAmount));
	}
}
