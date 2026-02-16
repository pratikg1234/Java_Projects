
public class ArrayExample4 {
	public static void main(String[] args) {
//		bankaccountArray();
//		circleArray();
		printCustomerNames();
	}
	public static void bankaccountArray() {
//		BankAccount b1[] = new BankAccount[3];

//		b1[0] = new  BankAccount();
//		b1[1] = new BankAccount();
//		b1[2] = new BankAccount();
		
		//declare & initialization array of object
		BankAccount b1[]= {
				new BankAccount(),
				new BankAccount(),
				new BankAccount()
		};
		
		b1[0].actBalance =12000.00;
		b1[0].customerName = "Pratik";
		
		b1[1].actBalance =15000.00;
		b1[1].customerName = "raghu";
		
		b1[2].actBalance =20000.00;
		b1[2].customerName = "akhil";
		
//		b1[0].deposit(1000);
//		b1[1].deposit(2000);
//		b1[2].deposit(3000);
//		
//		b1[0].withdraw(10000);
//		b1[1].withdraw(100);
//		b1[2].withdraw(600);
		BankAccount temp = b1[0];
		for(int i=0;i<3;i++) {
			if(b1[i].actBalance < temp.actBalance) {
				temp= b1[i];
			}
		}
		System.out.println("The account balance who has min balance is : "+ temp.customerName);

		
	}
	public static void circleArray() {
		Circle c1[]= {
				new Circle(),
				new Circle(),
				new Circle()
		};
		
		System.out.println(c1[0].area(100));
		System.out.println(c1[1].area(200));
		System.out.println(c1[2].area(300));
	}
	
	public static void printCustomerNames() {
//		BankAccount b1[]= new BankAccount[3];
		BankAccount b1[]= {
				new BankAccount(),
				new BankAccount(),
				new BankAccount()
		};
		b1[0].actBalance =12000.00;
		b1[0].customerName = "Pratik";
		
		b1[1].actBalance =15000.00;
		b1[1].customerName = "raghu";
		
		b1[2].actBalance =20000.00;
		b1[2].customerName = "akhil";
		for(BankAccount ba : b1) {
			System.out.println(ba.customerName);
		}
	}
}
