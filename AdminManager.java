
// Save this class as AdminManager

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class AdminManager {

	public static void operations() throws FileNotFoundException, ClassNotFoundException, IOException {

		String bookName;
		String author;
		String publicationDate;
		String totalPages;
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		ArrayList<BookData> list = new ArrayList<BookData>();
		File file = new File("BooksData.txt");// initializing file object and passing filename as argument
		ObjectOutputStream out = null;// initially writing the object as null
		ObjectInputStream in = null;
		ListIterator<BookData> iterator = null;
		File file1 = new File("User1.txt");
		User_Verification user_verification = new User_Verification();
		ArrayList<User_Verification> list1 = new ArrayList<User_Verification>();
		ObjectOutputStream out1 = null;
		ObjectInputStream in1 = null;
		ListIterator<User_Verification> iterator1 = null;
		char ch;
		do {
			System.out.println("Welcome to the admin page");
			System.out.println("0:View Book Details");
			System.out.println("1:Add books");
			System.out.println("2:Delete books");
			System.out.println("3:Search/Get book by bookname");
			System.out.println("4:View users information");
			System.out.println("Enter the option");
			int adminOption = scanner.nextInt();
			switch (adminOption) {
			case 0:
				System.out.println("View Book Details");
				System.out.println("*******Hi Admin! Welcome to the Library..********");
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<BookData>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				break;
			
			case 1:
				System.out.println("add books");

				System.out.println("Please Enter the no of books that you are going to add");
				int no_of_books = scanner.nextInt();
				for (int i = 0; i < no_of_books; i++) {
					System.out.println("Enter the name of the book");
					bookName = scanner1.nextLine();
					System.out.println("Enter the author of the book");
					author = scanner1.nextLine();
					System.out.println("Enter the publication date like yy-mm-dd");
					publicationDate = scanner1.nextLine();
					System.out.println("Enter the total pages of the book");
					totalPages = scanner1.nextLine();
                    // adding book object to list
					list.add(new BookData(bookName, author, totalPages, publicationDate));
					out = new ObjectOutputStream(new FileOutputStream(file));
					out.writeObject(list);// writes the object available in list into the file.
					out.close();

				}
				break;
			case 2:
				System.out.println("delete books");
				boolean found1 = false;
				System.out.println("Enter the Bookname to be removed");
				String book_delete = scanner1.nextLine();
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<BookData>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					BookData bookData = (BookData) iterator.next();
					if (bookData.bookName.equals(book_delete)) {
						iterator.remove();
						found1 = true;
					}
				}
				if (found1) {
					out = new ObjectOutputStream(new FileOutputStream(file));
					out.writeObject(list);
					out.close();
					System.out.println(book_delete + " is removed sucessfully");
				} else {
					System.out.println(book_delete + " is not in a library");

				}

				break;

			case 3:
				System.out.println("3:Search/Get book by bookname");
				boolean found = false;
				System.out.println("Enter the item to be searched");
				String book = scanner1.nextLine();
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<BookData>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					BookData bookData = (BookData) iterator.next();
					if (bookData.bookName.equals(book)) {
						System.out.println(bookData);
						found = true;
					}
				}
				if (found) {
					System.out.println(book + " is in library");
				} else {
					System.out.println(book + " is not in library");
				}
				break;

			case 4:
				System.out.println("view users information");

				in1 = new ObjectInputStream(new FileInputStream(file1));
				list1 = (ArrayList<User_Verification>) in1.readObject();
				in1.close();
				iterator1 = list1.listIterator();
				while (iterator1.hasNext()) {
					System.out.println(iterator1.next());

				}
				break;

			default:
				System.out.println("Enter the valid number");
				
			}
			System.out.println("do you wish to continue then press y if not press n");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

	}

}