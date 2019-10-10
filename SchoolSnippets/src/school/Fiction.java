package school;

public class Fiction extends Book {

	public Fiction(String title) {
		super(title);
		setPrice();
	}

	@Override
	public void setPrice() {
		this.price = 24.99;
	}

}
