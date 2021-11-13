package ui;

import java.util.Scanner;

import Model.Game;

public class Main {
	public static Scanner sn= new Scanner(System.in);
	public static void main(String[]args) {

		int option=menu();
		
		switch(option) {
		case 1:
			String[] prices= new String[5];
			System.out.println("Please enter the information necesary for play");
			String dates=sn.nextLine();
			
			String[] parts = dates.split(" ");

			int fila=Integer.parseInt(parts[0]);
			int columna=Integer.parseInt(parts[1]);
			int snakes=Integer.parseInt(parts[2]);
			int ladders=Integer.parseInt(parts[3]);
			String idPlayers=parts[4];
			
			String[] ids = idPlayers.split("");
			int numPlayers=ids.length;
			
			Game n =new Game(fila,columna);
			
			n.starGame(numPlayers, ids,snakes,ladders);
			
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
		sn.nextLine();
		
		return menu;
	}
	

}
