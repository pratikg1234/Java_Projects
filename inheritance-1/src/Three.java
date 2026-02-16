
public class Three extends Two{
	String msg3;
	public Three() {
		super();
	}
	public Three(String msg1, String msg2, String msg3) {
		super(msg1,msg2);
		this.msg3=msg3;
		System.out.println("msg3="+msg3);
	}
}
