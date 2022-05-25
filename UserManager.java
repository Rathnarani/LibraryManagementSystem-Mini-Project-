
// Save this class as UserManager

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class UserManager {

	public static void operations() throws FileNotFoundException, IOException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		// Verification verification = new Verification();
		Scanner scanner1 = new Scanner(System.in);
		ArrayList<BookData> list = new ArrayList<BookData>();
		File file = new File("BooksData.txt");
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
			System.out.println("Welcome to User page");
			System.out.println("1:View books Details");
			System.out.println("2:Search books");
			System.out.println("3:Borrow books");
			System.out.println("4:Return books");
			System.out.println("Enter the option");
			int userOption = scanner.nextInt();
			switch (userOption) {
			case 1:
				System.out.println("1:View Book Details");
				System.out.println("*******Hi User! Welcome to the Library********");
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<BookData>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				break;

			case 2:
				System.out.println("2:Search books");
				boolean found = false;
				System.out.println("Enter the book to be searched");
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

			case 3:
				System.out.println("3:Borrow books");
				boolean found1 = false;
				System.out.println("Enter the book to be borrowed");
				String book1 = scanner1.nextLine();
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<BookData>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					BookData bookData = (BookData) iterator.next();
					if (bookData.bookName.equals(book1)) {
						System.out.println(bookData);
						found1 = true;
					}
				}
				if (found1) {
					System.out.println(book1 + " is borrowed successfully");
				} else {
					System.out.println(book1 + " is not in library");
				}
				break;

			case 4:
				System.out.println("4:Return books");
				
				
				boolean found2 = false;
				System.out.println("Enter the Bookname to be returned");
				String return_book = scanner1.nextLine();
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<BookData>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					BookData bookData = (BookData) iterator.next();
					if (bookData.bookName.equals(return_book)) {
						found2 = true;
					}
				}
				if (found2) {
					out = new ObjectOutputStream(new FileOutputStream(file));
					out.writeObject(list);
					out.close();
					System.out.println(return_book + " is returned sucessfully");
				} else {
					System.out.println(return_book + " is not in your list");

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
