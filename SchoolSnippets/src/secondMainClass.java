import java.util.Scanner;

public class secondMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = 0;
		for(int i = 1; i<=x; i++)
		{
			y+= i;
			if(i!=x)
				System.out.print(i + " + ");
			else
				System.out.print(i);
		}
		System.out.println(" = "+ y);

	}

}
