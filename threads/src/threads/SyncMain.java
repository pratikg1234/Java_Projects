package threads;

public class SyncMain {
	public static void main(String[] args) {
		PrintMessage pm = new PrintMessage();
		PrintingThread x =new PrintingThread(pm,"Hello");
		PrintingThread y =new PrintingThread(pm,"Hi");
		x.start();
		y.start();
	}
}
