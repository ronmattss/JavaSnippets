package school;

public abstract class Book {
	private String title;
	double price;

	Book(String title) {
		setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public abstract void setPrice();

}
