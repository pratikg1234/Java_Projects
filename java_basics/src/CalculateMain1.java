public class CalculateMain1 {
	public static void main(String[] args) {
		Calculate c1 = new Calculate();
		c1.add(10, 20);
		c1.add((short)10, (short)20);
		c1.add((byte)10, (byte)20);
		c1.add(10L, 20L);
	}
}
