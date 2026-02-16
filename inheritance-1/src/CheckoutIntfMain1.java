
public class CheckoutIntfMain1 {
	public static void main(String[] args) {
//		Checkout c1 = new DebitCardCheckout();
//		c1.processPayment(1000);
//		c1 = new CreditCardCheckout();
//		c1.processPayment(2000);
//		c1 = new NetBankingCheckout();
//		c1.processPayment(3000);
		CheckoutService cs = new CheckoutService();
		cs.processPayment(1000);

	}
}
