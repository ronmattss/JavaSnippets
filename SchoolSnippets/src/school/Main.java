package school;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Employee employee = new Employee();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Employee name: ");
		employee.setName(sc.next());
		System.out.print("Enter Employee number: ");
		employee.setNum(sc.nextInt());
		System.out.print("Enter Employee type (casual or permanent): ");
		employee.setType(sc.next());
		sc.close();
		System.out.println("Employee information:");
		System.out.println(" Name: "+employee.getName()+"\n Number: "+ employee.getNum()+"\n Type: "+ employee.getType());

		
	}
	

}
