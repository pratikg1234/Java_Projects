
public class DiscountedPrice {
	public void calculateDiscount(double actualPrice, double discountPercent) {
		double priceAfterDiscount = actualPrice - (actualPrice * (discountPercent/100));
		System.out.println("Actual Price : "+actualPrice);
		System.out.println("Discount Percent : "+ discountPercent);
		System.out.println("Price After Discount : "+ priceAfterDiscount);
	}
}
