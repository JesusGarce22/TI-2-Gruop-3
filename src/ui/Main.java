package ui;

import java.util.Scanner;

public class Main {
	public static Scanner sn= new Scanner(System.in);
	public static void mani(String[]args) {

		int option=menu();
		
		switch(option) {
		case 1:
			System.out.println("Please enter the information necesary for play");
			String dates=sn.nextLine();
			break;
		case 2:
			break;
		case 3:
			System.out.println("has successfully exited the game");
			break;
		}


	}

	public static int menu() {
		int menu=0;
		System.out.println("                         MAIN  MENU                                                        ");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("Enter (1) star game");
		System.out.println("Enter (2) show talbe punctuation game");
		System.out.println("Enter (3) for out the program.");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("Choose the option of your liking");
		menu=sn.nextInt();
		
		return menu;
	}
}
