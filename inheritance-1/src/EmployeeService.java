
public class EmployeeService {
	public static void callSalary(Employee e) {
		if(e instanceof PermanentEmployee) {
			System.out.println("Printing salary details of Permanent Employee...");
		}
		else if(e instanceof ContractEmployee) {
			System.out.println("Printing slalry details of Contract Employee..");
		}
		e.calculateNetSalary();
	}
}
