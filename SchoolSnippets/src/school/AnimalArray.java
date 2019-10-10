package school;

import java.util.*;
public class AnimalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		Animal animals[] = new Animal[5];
		animals[0] = new Dog();
		animals[1] = new Cat();
		animals[2] = new Cow();
		animals[3] = new Lion();
		animals[4] = new Snake();	
		
		
		//Randomly set size of animals
		for(int i = 0; i<animals.length; i++)
		{
			animals[i].setSize(rand.nextInt(20));
		}
		
		Arrays.sort(animals,Comparator.comparing(Animal::getSize));
		
		
		for (Animal animal : animals) {
			System.out.println(animal.getClass() + " " + animal.getSize());
		}
		
		System.out.println("\nNormal Loop");
		for(int i =0; i<5; i++)
			animals[i].speak();
		System.out.println("\nfor each Loop");
		for (Animal a : animals) {
			a.speak();
		}
		System.out.println("\nby Length");
		for(int i =0; i < animals.length;i++)
		{
			animals[i].speak();
		}
	}

}
