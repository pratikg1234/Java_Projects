package threads;

public class SampleThread implements Runnable{
	public void run() {
		demo();
	}
	public void demo() {
		for(int i=1;i<=100;i++) {
			System.out.println("hello thread..."+i);
		}
		
	}
	public static void main(String[] args) {
		SampleThread t1 = new SampleThread();
		Thread x = new Thread(t1);
		x.start();
		for(int i=1;i<=100;i++) {
			System.out.println("main thread..."+i);
		}
	}
}
