/*Author: Rivera, Ron Matthew R.
 * Customer Propoerties for Eatmore
 * 
 * */
package machineProblems;
public class Customer  {
	// customer properties
	public String customerName= "";
	public int hotdog = 0;
	public int soda = 0;
	public int popcorn = 0;
	public int queueTime = 1; // length of time from queueing to beginning of serve
	public int fullServiceTime = 0; // queue time x (serve Time x amount)
	public int hotdogServeTime = 0;
	public int sodaServeTime = 0;
	public int popcornServeTime = 0;	
	public int fullHotdogServeTime = 0;
	public int fullSodaServeTime = 0;
	public int fullpopcornServeTime = 0;
	public boolean hotdogIsBeingServe = false;
	public boolean sodaIsBeingServe = false;
	public boolean popcornIsBeingServe = false;
	public boolean isFullyServed = false;
	public boolean timeInQueue;
	
	Customer (String name,int pAmount,int sAmount, int hAmount)
	{
		customerName = name;
		hotdog = hAmount;
		soda = sAmount;
		popcorn = pAmount;
	}
	
	Customer()
	{
		
	}
	
	
	


}
