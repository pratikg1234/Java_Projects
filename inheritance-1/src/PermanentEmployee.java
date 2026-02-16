
public class PermanentEmployee extends Employee{
	private int monthlySalary;
	private double incomeTax;
	private double pf;
	private double insurance;
	public void calculateNetSalary() {
		double perdaySalary = monthlySalary/30;
		double grossSalary = perdaySalary* getAttendance();
		double deductions = incomeTax + pf + insurance;
		double netSalary = grossSalary - deductions;
		
		System.out.println("Gross Salary: "+ grossSalary);
		System.out.println("Deductions: "+ deductions);
		System.out.println("Net Salary : "+ netSalary);
	}
	public PermanentEmployee() {

	}
	public PermanentEmployee(int monthlySalary, double incomeTax, double pf, double insurance) {
		super();
		this.monthlySalary = monthlySalary;
		this.incomeTax = incomeTax;
		this.pf = pf;
		this.insurance = insurance;
	}
	public int getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public double getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}
	public double getPf() {
		return pf;
	}
	public void setPf(double pf) {
		this.pf = pf;
	}
	public double getInsurance() {
		return insurance;
	}
	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	
}
