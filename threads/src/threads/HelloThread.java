package threads;
//Here everytime
public class HelloThread extends Thread{
	public void run() {
		demo();
	}
	public void demo() {
		for(int i=1;i<=100;i++) {
			System.out.println("hello thread..."+i);
		}
	}
	public static void main(String[] args) {
		HelloThread t1 = new HelloThread();
		t1.start();
		for(int i=1;i<=100;i++) {
			System.out.println("main thread..."+i);
		}
	}
}
