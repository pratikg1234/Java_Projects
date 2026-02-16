
public class NetBankingCheckout implements Checkout{
	public void processPayment(double checkoutAmount) {
		double availableBal = 30000;
		System.out.println("Checkout Process Using NetBanking");
		System.out.println("The Available Balance: "+ availableBal);
		System.out.println("checkoutAmount: "+ checkoutAmount);
		System.out.println("After Deductions: "+ (availableBal-checkoutAmount));
	}

}
