package egger.software.at_mockito;

public class Library {
	private Database db;
	public Library(Database db) {
		this.db = db;
	}

	public void registerBook(Book book) {
		int id = db.nextId();
		db.insert("BOOK", id, book.getTitle());
	}

	public Book findBookById(int id) {
		String title = db.select("BOOK", id);
		return new Book(title);
	}

}
