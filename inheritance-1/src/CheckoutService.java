
public class CheckoutService {
	Checkout ch = new CreditCardCheckout();
	public void processPayment(double checkoutAmount) {
		ch.processPayment(checkoutAmount);
	}
}
