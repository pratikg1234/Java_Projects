
public class ArrayExample3 {
	public static void main(String[] args) {
		intArray();
		doubleArray();
		stringArray();
	}
	public static void intArray() {
		int scores[];
		scores = new int[5];
		for(int i=0;i<5;i++) {
			System.out.print(scores[i]+" ");
		}
		System.out.println();
	}
	public static void doubleArray() {
		double scores[];
		scores = new double[5];
		for(int i=0;i<5;i++) {
			System.out.print(scores[i]+" ");
		}
		System.out.println();
	}
	public static void stringArray() {
		String scores[];
		scores = new String[5];
		for(int i=0;i<5;i++) {
			System.out.print(scores[i]+" ");
		}
	}
}
