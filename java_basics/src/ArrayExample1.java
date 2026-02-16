
public class ArrayExample1 {
	public static void main(String[] args) {
		intArray();
		doubleArray();
		stringArray();
	}
	public static void intArray() {
		int scores[]={10,20,30,40,50};
		for(int i=0;i<5;i++) {
			System.out.print(scores[i]+" ");
		}
		System.out.println();
	}
	public static void doubleArray() {
		double scores[] = {10.0,20.0,30.0,40.0,50.0};
//		scores[4]=(double)50;
		for(int i=0;i<5;i++) {
			System.out.print(scores[i]+" ");
		}
		System.out.println();
	}
	public static void stringArray() {
		String scores[] = {"reactjs","spring boot","java","angular","django"};
		for(int i=0;i<5;i++) {
			System.out.print(scores[i]+" ");
		}
	}
}
