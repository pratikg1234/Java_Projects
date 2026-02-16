
public class WelcomeChild extends Welcome{
	public void greet(String msg) {
		System.out.println("Hello "+msg);
	}
	public static void main(String[] args) {
		WelcomeChild w1 = new WelcomeChild();
		w1.greet("Pratik");
		w1.showFullName("Pratik", "Gaikwad");
	}
}
