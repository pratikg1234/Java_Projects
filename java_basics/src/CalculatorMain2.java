public class CalculatorMain2 {
	public static void main(String[] args) {
		Calculator c2,c3;
		c2= new Calculator();
		c2.x=100;
		c2.y=200;
		c2.multiply();
		int res1 = c2.sum();
		System.out.println("The sum is : "+ res1);
		
		c3= new Calculator();
		c3.x=15;
		c3.y=25;
		c3.multiply();
		int res2 = c3.sum();
		System.out.println("The sum is from c3 reference : "+ res2);
	}
	
	
}
