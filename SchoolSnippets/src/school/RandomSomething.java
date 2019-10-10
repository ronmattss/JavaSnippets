package school;

import java.util.*;
public class RandomSomething {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double QZ,LE,EX,TP,CS,stand,FG;
		   char ans;
		   do
		   {
		   System.out.println("INPUT(lagyan) GRADES(grado) PLEASE(pakiusap) HEHEHEHEHEHEHE");
		   Scanner wew = new Scanner(System.in);
		   System.out.print("Quizzes/Assignments : ");
		   QZ = wew.nextDouble();
		   System.out.print("Laboratory Exercises: ");
		   LE = wew.nextDouble();
		   System.out.print("Exams               : ");
		   EX = wew.nextDouble();
		   System.out.print("Term Project/s      : ");
		   TP = wew.nextDouble();
		   System.out.print("Case Study          : ");
		   CS = wew.nextDouble();
		   stand = ( 0.1 * QZ ) + ( 0.2 * LE ) + ( 0.3 * EX) + ( 0.3 * TP ) + ( 0.1 * CS);
		   FG = 0;
		   System.out.printf("Class Standing      : %.2f", stand);
		   if( stand < 50 )
		   FG = 5.00;
		   else if( stand >= 50 && stand <= 59 )
		   FG = 4.00;
		   else if( stand >= 60 && stand <= 63 )
		   FG = 3.00;
		   else if( stand >= 64 && stand <= 67 )
		   FG = 2.75;
		   else if( stand >= 68 && stand <= 71 )
		   FG = 2.50;
		   else if( stand >= 72 && stand <= 75 )
		   FG = 2.25;
		   else if( stand >= 76 && stand <= 79 )
		   FG = 2.00;
		   else if( stand >= 80 && stand <= 83 )
		   FG = 1.75;
		   else if( stand >= 84 && stand <= 87 )
		   FG = 1.50;
		   else if( stand >= 88 && stand <= 91 )
		   FG = 1.25;
		   else if( stand >= 92 && stand <= 100 )
		   FG = 1.00;
		   System.out.printf("\nFinal Grade         : %.2f\n",FG);
		   System.out.print("Input again?(y/n)   : ");
		   ans = wew.next().charAt(0);
		   
		   }while( ans == 'y' || ans == 'Y');

	}

}
