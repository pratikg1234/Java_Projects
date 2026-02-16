
abstract public class Employee {
	private int empNumber;
	private String empName;
	private int attendance;
	abstract public void calculateNetSalary();
	public Employee() {
		
	}
	public Employee(int empNumber, String empName, int attendance) {
		this.empNumber = empNumber;
		this.empName = empName;
		this.attendance = attendance;
	}
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	
}
