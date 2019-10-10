package school;

public class Vehicle {
	
	private int wheels;
	private int milesPerGallon;
	
	
	Vehicle(int w,int g)
	{
		setWheels(w);
		setMilesPerGallon(g);
	}
	public void setWheels(int w)
	{
		wheels = w;
	}
	
	public void setMilesPerGallon(int g)
	{
		milesPerGallon = g;
	}
	
	public int getWheels() {
		return wheels;
	}
	
	public int getMilesPerGallon() {
		return milesPerGallon;
	}
	
	public String toString()
	{
		return Integer.toString(getWheels()) + " " +Integer.toString(getMilesPerGallon());
	}

}



