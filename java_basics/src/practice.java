
public class practice {
	{
		System.out.println("From non static method");
	}
	static {
		System.out.println("From static method");
	}
	public static void main(String[] args) {
		new practice();
		System.out.println("In main method");
		
	}
}
