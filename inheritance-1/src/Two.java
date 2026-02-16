
public class Two extends One{
	String msg2;
	public Two() {
		System.out.println("Two() constructor...");
	}
	public Two(String msg1,String msg2) {
		super(msg1);
		this.msg2=msg2;
		System.out.println("msg2="+msg2);
	}
}
