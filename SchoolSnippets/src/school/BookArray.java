package school;

import java.util.*;

public class BookArray {

	public static void main(String[] args) {
		List<String> fT = new ArrayList<String>();
		fT.addAll(Arrays.asList("Harry", "Lord", "Percy", "Marvel", "DC"));
		List<String> nT = new ArrayList<String>();
		nT.addAll(Arrays.asList("National", "Geographic", "History", "Discovery", "Planet"));
		List<Fiction> fB = new ArrayList<Fiction>();
		List<NonFiction> nB = new ArrayList<NonFiction>();
		ArrayList<Book> book = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (i < 5) {
				fB.add(new Fiction(fT.get(i)));
				book.add(fB.get(i));
			} else {
				nB.add(new NonFiction(nT.get(i - 5)));
				book.add(nB.get(i - 5));
			}
		}
		book.forEach(b -> {
			if (b.getPrice() == 24.99) {
				System.out.println("Fiction Title: " + b.getTitle() + " Price: $" + b.getPrice());
			} else {
				System.out.println("Non Fiction Title: " + b.getTitle() + " Price: $" + b.getPrice());
			}
		});

	}

}
