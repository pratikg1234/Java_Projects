public class NetSalaryCalculator {
	double actualSalary = 15000.00;
	double incomeTaxPercent = 3.0;//in percentage
	double pf = 200;
	double insurance = 500;
	public void calculateTakeHomeSalary() {
		double incomeTax = actualSalary - (actualSalary - (incomeTaxPercent/100));
		double deductions = incomeTax + pf + insurance;
		double takeHomeSalary = actualSalary - deductions;
		System.out.println("Actual Salary : "+ actualSalary);
		System.out.println("Deductions : "+ deductions);
		System.out.println("Take Home Salary : "+ takeHomeSalary);
	}
}
