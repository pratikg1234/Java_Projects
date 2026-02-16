
public class InheritMain1 {
	public static void main(String[] args) {
		PermanentEmployee p1 = new PermanentEmployee();
		p1.setEmpNumber(7756);
		p1.setEmpName("Scott");
		p1.setAttendance(29);
		p1.setMonthlySalary(50000);
		p1.setIncomeTax(3000);
		p1.setPf(300);
		p1.setInsurance(600);
		
		
		System.out.println("************Now printing Permanent employee details*********");
		System.out.println(p1.getEmpNumber()+" "+p1.getEmpName()+" "+
		p1.getAttendance()+" "+p1.getMonthlySalary()+" "+p1.getIncomeTax()+" "+ p1.getPf()+" "+ p1.getInsurance());
		
		ContractEmployee c1 = new ContractEmployee();
		
		c1.setEmpNumber(7902);
		
		c1.setEmpName("Smith");
		
		c1.setAttendance(28);
		
		c1.setContractDuration(3);
		
		c1.setTds(1000);
		
		c1.setMonthlyPayRate(40000);
		
	 
		
		
		System.out.println("****** **now printing contract employee details******");
		
		System.out.println(c1.getEmpNumber()+" "+c1.getEmpName()+" "+c1.getAttendance()+
		
		""+c1.getMonthlyPayRate()+" "+c1.getTds()+" "+c1.getContractDuration());
		
		EmployeeService.callSalary(p1);
		EmployeeService.callSalary(c1);
	}
}
