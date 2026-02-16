
public class SalesMain1 {
	public static void main(String[] args) {
		Sales s1 = new Sales();
		Sales s2 = new Sales();
		Sales s3 = new Sales();
		s1.salesAchieved=10;
		s2.salesAchieved=20;
		s3.salesAchieved=30;
		Sales.totalSales = s1.salesAchieved+s2.salesAchieved+s3.salesAchieved;
		Sales.printTotalSales();
	}
}
