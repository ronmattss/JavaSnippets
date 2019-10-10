package school;

public class Compute {
	static int a,b;

	public static void main(String[] args) {
		
		a = 100;
		b = 200;
		long c = 500;
		long d = 600;
		
		
		System.out.println("a + b = " + compute(a,b));
		System.out.println("a / b = " + compute(100.0f,20.0f));
		System.out.println("b - a = " + compute(c,d));
		compute();
	}
	
	 public static int compute (int a, int b)
	 {
		 return a+b;
	 }
	 
	 public static double compute (float a, float b)
	 {
		 return a/b;
	 }
	 
	 public static float compute (long a, long b)
	 {
		return  b - a;
		 
	 }
	 
	 public static void compute ()
	 {
		 System.out.println("a * b = " + a * b);
	 }
	 

	 

	 /*
	  * a + b = 300
	    a / b = 5.0
        b - a = 100.0
        a * b = 20000
	  */

}
