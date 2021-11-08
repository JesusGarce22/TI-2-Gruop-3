package Model;

import java.util.ArrayList;

public class Game
{
	private Node origin;
	private Node last;
	
	private int filas;
	private int columnas;
	
	private int size;
	
	public Game(int filas, int columnas)
	{
		this.filas = filas;
		this.columnas = columnas;
		size = filas*columnas;
		origin = createBoard(size);
	}
	
	public Node createBoard(int size)
	{
		Node first = new Node(0);
		
		Node current = first;
		
		for(int i = 1; i < size; i++)
		{
			Node next = new Node(i);
			
			current.setNext(next);
			next.setPrev(current);
			
			current = current.getNext();
		}
		last = current;
		
		return first;
	}
	
	
	public void printBoard()
	{
		Node current = last;
		
		System.out.print(current.toString());
		for(int i = size-1 ; i > 0 ; i--)
		{
			current = current.getPrev();
			if(i % columnas == 0)
			{
				System.out.println();
				System.out.print(current.toString());
			}
			else
			{
				System.out.print(current.toString());
			}
		}
	}
	
	public void starGame(int numPlayers,String[] ids) {
		Player[] players = new Player[numPlayers];
		
		for(int i=0;i<numPlayers;i++) {
			players[i] = new Player(1,ids[i]);
		}
		
		int contador=0;
		avanzar(players,contador);
		
		//condicion de parada
		
		if(players[contador]!=null && players[contador].getPosition()>=size) {
			System.out.println(players[contador].getCharacter()+" is the winner");
			winner(true);
			return;
		}
		
		//accion recursiva
		
	}
	
	private void avanzar(Player[] players,int n) {
		
		if(n==players.length) {
		
			return;
		}
		int move=Throw();
		
		players[n].setPosition(players[n].getPosition()+move);
		
		n++;

		avanzar(players,n);
	}

	public int Throw() {
		int move=1+(int)(6*Math.random());
		return move;
	}
	
	public void simulatorGame(Player[] players,int n) {
		
		if(players[n]!=null && players[n].getPosition()>=size) {
			System.out.println(players[n].getCharacter()+" is the winner");
			return;
		}
		
		int move=(int)(Math.random()*6+1);;
		
		players[n].setPosition(players[n].getPosition()+move);
		
		n++;
		if(n==players.length) {
			n=0;
		}
		simulatorGame(players,n);
	}
	
	public boolean winner(boolean n) {
		return n;
	}
}

