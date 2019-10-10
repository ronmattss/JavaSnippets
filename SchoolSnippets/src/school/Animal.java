package school;

public abstract class Animal {
	
	private String name;
	private int size;
	
	public Animal()
	{
		
	}
	public Animal(int size, String name)
	{
		this.setSize(size);
		this.setName(name);
	}
//	public abstract void speak();
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	  public abstract void speak();

	

}
