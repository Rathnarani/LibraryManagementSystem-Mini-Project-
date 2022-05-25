
// Save this class as BookData

import java.io.Serializable;

public class BookData implements Serializable {// using serializable here for writing an object to file
	String bookName;
	String author;
	String publicationDate;
	String totalPages;

	public BookData(String bookName, String author, String publicationDate, String totalPages) {
		// super();
		this.bookName = bookName;
		this.author = author;
		this.publicationDate = publicationDate;
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "BookData [bookName=" + bookName + ", author=" + author + ", publicationDate=" + publicationDate
				+ ", totalPages=" + totalPages + "]";
	}

}

