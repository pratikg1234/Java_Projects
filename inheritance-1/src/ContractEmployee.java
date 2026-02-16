
public class ContractEmployee extends Employee {
	private int contractDuration;
	private double monthlyPayRate;
	private double tds;
	
	public void calculateNetSalary() {
		double perdaySalary = monthlyPayRate/30;
		double grossSalary = perdaySalary* getAttendance();
		double netSalary = grossSalary - tds;
		System.out.println("Gross Salary: "+ grossSalary);
		System.out.println("Deductions: "+ tds);
		System.out.println("Net Salary : "+ netSalary);
	}
	public ContractEmployee() {
		
	}
	public ContractEmployee(int contractDuration, double monthlyPayRate, double tds) {
		this.contractDuration = contractDuration;
		this.monthlyPayRate = monthlyPayRate;
		this.tds = tds;
	}
	public int getContractDuration() {
		return contractDuration;
	}
	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}
	public double getMonthlyPayRate() {
		return monthlyPayRate;
	}
	public void setMonthlyPayRate(double monthlyPayRate) {
		this.monthlyPayRate = monthlyPayRate;
	}
	public double getTds() {
		return tds;
	}
	public void setTds(double tds) {
		this.tds = tds;
	}
	
}
