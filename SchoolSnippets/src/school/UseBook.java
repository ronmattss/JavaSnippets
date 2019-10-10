package school;

public class UseBook {

	public static void main(String[] args) {
		Book firstBook = new Fiction("Transformers");
		Book secondBook = new NonFiction("Dictionary");

		System.out.println("Title: " + firstBook.getTitle() + " Price: " + firstBook.getPrice());
		System.out.println("Title: " + secondBook.getTitle() + " Price: " + secondBook.getPrice());
	}

}
