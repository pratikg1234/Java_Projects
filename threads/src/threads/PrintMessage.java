package threads;

class PrintingThread extends Thread{
	PrintMessage pm;
	String msg;
	
	public void run() {
		pm.print(msg);
	}
	public PrintingThread() {
		
	}
	
	public PrintingThread(PrintMessage pm, String msg) {
		this.pm=pm;
		this.msg=msg;
	}
}
public class PrintMessage {
 synchronized public void print(String msg) {
		System.out.print("[");
		try{
			Thread.sleep(500);
		}
		catch(InterruptedException e) {
			
		}
		System.out.println(msg + "]");
	}
}
