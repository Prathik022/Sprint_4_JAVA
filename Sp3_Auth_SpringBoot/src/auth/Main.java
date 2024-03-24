package auth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){		
		menu();
	}
	
	
	public static void menu() {
		QueryExecutor obj = new QueryExecutor();
		Scanner input = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("Hello! Do you want to \n1. Login \n2. Register \n3. Delete \n4. Update \n5. Exit");
			try {
				choice = input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println(e);
				input.nextLine();
				System.out.println("Type only Numbers");
				choice = input.nextInt();
			}
			switch(choice) {
			case 1:{
				System.out.print("Enter Username : ");
				String userName = input.next();
				System.out.print("\nEnter Password : ");
				String password = input.next();
				boolean flag = obj.loginCheck(userName, password);
				break;
			}case 2:{
				System.out.print("Enter Username : ");
				String userName = input.next();
				System.out.print("\nEnter Password : ");
				String password = input.next();
				boolean flag = obj.registerUser(userName, password);
				break;
			}case 3:{
				System.out.print("Enter Username : ");
				String userName = input.next();
				System.out.print("\nEnter Password : ");
				String password = input.next();
				boolean flag = obj.deleteUser(userName,password);
				break;
			}case 4:{
				System.out.print("Enter Username : ");
				String userName = input.next();
				System.out.print("\nEnter Password : ");
				String password = input.next();
				System.out.print("\nEnter New Password :");
				String newPassword = input.next();
				boolean flag = obj.updateDetails(userName,password,newPassword);
				break;
			}case 5:{
				break;
			}default:{
				System.out.println("Give correct input");
				break;
			}
			}
		}while(choice != 5);
		input.close();
	}
}
