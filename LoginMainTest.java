import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Save this class as LoginMainTest  

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class LoginMainTest {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		char aaoption, bboption, opion;

		Admin_Verification admin_verification = new Admin_Verification();
		User_Verification user_verification = new User_Verification();
		LoginMainTest loginmaintest = new LoginMainTest();
		do {

			System.out.println("*********************************");
			System.out.println("*****Library management system*****");
			System.out.println("*********************************");
			System.out.println("A:Admin");
			System.out.println("B:User");
			System.out.println("Enter the option");
			Scanner scanner = new Scanner(System.in);
			char option = scanner.next().charAt(0);

			switch (option) {
			case 'A':
				do {

					System.out.println("---1.SIGNUP----");
					System.out.println("---2.LOGIN----");
					int choice = scanner.nextInt();
					File file = new File("User.txt");
					ArrayList<Admin_Verification> list = new ArrayList<Admin_Verification>();
					ObjectOutputStream out = null;
					ListIterator<Admin_Verification> iterator = null;
					switch (choice) {

					case 1:
						System.out.println("----------signup------------");
						System.out.println("Enter the Details");
						System.out.println("Enter the Mobile number");
						String mobilenumber = scanner.next();
						System.out.println("Enter the username");
						String username = scanner.next();
						if (Username_Validation.userNameValidation(username)) {
							System.out.println("valid username");
							System.out.println("Enter the Password");
							String password = scanner.next();
							if (Password_Validation.passWordValidation(password)) {
								System.out.println("valid password");
								System.out.println("Enter the confirmpassword");
								String confirmpassword = scanner.next();
								if (password.equals(confirmpassword)) {
									list.add(new Admin_Verification(username, password, confirmpassword, mobilenumber));
									out = new ObjectOutputStream(new FileOutputStream(file));
									out.writeObject(list);
									out.close();
									System.out.println("Access Granted!you can login and go ahead");
								} else
									System.out.println("password doesnot match");
							} else
								System.out.println("password should be strong");
						} else
							System.out.println("enter the username again");
						break;
					case 2:
						System.out.println("------Login---------");
						System.out.println("enter the username");
						String username1 = scanner.next();
						System.out.println("enter the password");
						String Password1 = scanner.next();
						do {
							ObjectInputStream in = null;

							in = new ObjectInputStream(new FileInputStream(file));

							list = (ArrayList<Admin_Verification>) in.readObject();

							in.close();

							iterator = list.listIterator();
							while (iterator.hasNext()) {
								admin_verification = (Admin_Verification) iterator.next();
							}
							if (username1.equals(admin_verification.username)
									&& Password1.equals(admin_verification.password)) {
								System.out.println("Login Success");
								if (admin_verification.equals(admin_verification)) {
									AdminManager.operations();
								}

							}
							break;
						} while (admin_verification != null);
					}
					System.out.println("do you wish to continue then press y if not press n");
					aaoption = scanner.next().charAt(0);
				} while (aaoption == 'Y' || aaoption == 'y');
				break;
			case 'B':
				do {

					System.out.println("---1.SIGNUP----");
					System.out.println("---2.LOGIN----");
					int choice = scanner.nextInt();
					File file = new File("User1.txt");
					ArrayList<User_Verification> list = new ArrayList<User_Verification>();
					ObjectOutputStream out = null;
					ListIterator<User_Verification> iterator = null;
					switch (choice) {

					case 1:
						System.out.println("----------signup------------");
						System.out.println("Enter the Details");
						System.out.println("Enter the Mobile number");
						String mobilenumber = scanner.next();
						System.out.println("Enter the username");
						String username = scanner.next();
						if (Username_Validation.userNameValidation(username)) {
							System.out.println("valid username");
							System.out.println("Enter the Password");
							String password = scanner.next();
							if (Password_Validation.passWordValidation(password)) {
								System.out.println("valid password");
								System.out.println("Enter the confirmpassword");
								String confirmpassword = scanner.next();
								if (password.equals(confirmpassword)) {
									list.add(new User_Verification(username, password, confirmpassword, mobilenumber));

									out = new ObjectOutputStream(new FileOutputStream(file));

									out.writeObject(list);

									out.close();

									System.out.println("Access Granted!you can login and go ahead");
								} else
									System.out.println("password doesnot match");
							} else
								System.out.println("password should be strong");
						} else
							System.out.println("enter the username again");
						break;
					case 2:
						System.out.println("------Login---------");
						System.out.println("enter the username");
						String username1 = scanner.next();
						System.out.println("enter the password");
						String Password1 = scanner.next();
						do {
							ObjectInputStream in = null;

							in = new ObjectInputStream(new FileInputStream(file));

							list = (ArrayList<User_Verification>) in.readObject();

							in.close();

							iterator = list.listIterator();
							while (iterator.hasNext()) {
								user_verification = (User_Verification) iterator.next();
							}
							if (username1.equals(user_verification.username)
									&& Password1.equals(user_verification.password)) {
								System.out.println("Login Success");
								if (user_verification.equals(user_verification)) {
									UserManager.operations();
								}

							}
							break;
						} while (user_verification != null);
					}
					System.out.println("do you wish to continue then press y if not press n");
					bboption = scanner.next().charAt(0);
				} while (bboption == 'Y' || bboption == 'y');

			}
			System.out.println("do you wish to continue then press y if not press n");
			opion = scanner.next().charAt(0);
		} while (opion == 'Y' || opion == 'y');
	}

}
