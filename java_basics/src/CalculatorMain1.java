
public class CalculatorMain1 {
	public static void main(String[] args) {
		Calculator c1;//declaration
		c1= new Calculator();
		c1.x=10;
		c1.y=20;
		int res = c1.sum();
		c1.multiply();
		System.out.println("sum is : " + res);
		System.out.println();
	}
}
