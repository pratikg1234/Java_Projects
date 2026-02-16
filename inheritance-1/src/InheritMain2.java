
public class InheritMain2 {
	public static void main(String[] args) {
		Dog d = new Dog();
		Cat c = new Cat();
		AnimalService.callSound(d);
		AnimalService.callSound(c);
	}
}
