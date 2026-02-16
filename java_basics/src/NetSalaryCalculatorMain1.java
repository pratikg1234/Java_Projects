
public class NetSalaryCalculatorMain1 {
public static void main(String[] args) {
	NetSalaryCalculator x = new NetSalaryCalculator();
	x.calculateTakeHomeSalary();
	x=null;//nullyfying an object
	x.calculateTakeHomeSalary();
}
}
