
public class SuperChild extends SuperParent{
	int x=10;
	void m1() {
		System.out.println("Inside m1() method of SuperChild");
	}
	void m2() {
		System.out.println("Inside m2() method of SuperChild");
		System.out.println("value of x declared in parent class is : "+super.x);
		System.out.println("Value of x declared in Child Class is : "+x);
		System.out.println("Now calling m1() of super class");
		super.m1();
		System.out.println("Now calling m1() of child class");
		m1();
	}
}
