
public class AnimalService {
	public static void callSound(Animal a) {
		if(a instanceof Dog) {//Animal behaves as Dog
			((Dog) a).bite();
		}
		else if(a instanceof Cat) {// Animal behaves as Cat
			((Cat) a).scratch();
		}
		a.sound();
		
	}
}
