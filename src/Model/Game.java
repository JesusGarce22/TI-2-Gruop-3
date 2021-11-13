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
		
		
		for(int i = 0 ; i < filas ; i++)
		{
			if(i == 0) {
				current = printRow(last, true);
			} else if(i % 2 == 0) {
				current = printRow(current, true);
			} else if(i % 2 != 0) {
				current = printRow(current, false);
			}
		}
	}
	
	public Node printRow(Node current, boolean toggle) {
		String p = "";
		
		if(toggle) {
			for(int i = 0; i < columnas; i++) {
				p = p + current.toString();
				current = current.getPrev();
			}
		} else {
			for(int i = 0; i < columnas; i++) {
				p = current.toString() + p;
				current = current.getPrev();
			}
		}
		
		System.out.println(p);
		
		return current;
	}

	public void starGame(int numPlayers,String[] ids,int snake,int ladder) {
		Player[] players = new Player[numPlayers];

		for(int i=0;i<numPlayers;i++) {
			players[i] = new Player(1,ids[i]);
		}

		createSnake(snake);
		createLadder(ladder);
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

	//metodo del dado
	public int Throw() {
		int move=1+(int)(6*Math.random());
		return move;
	}

	public void createSnake(int snake) {

		//CONDICION DE PARADA
		if(snake==0) {
			return;
		}

		Snake aux = new Snake(0, 0, "A", null);
		organizarSnakes(aux);

		snake--;

		//llamado  recursivo
		createSnake(snake);
	}

	public void organizarSnakes(Snake snakes) {

		snakes.setFirstPosition(1+(int)(Math.random()*size)) ;
		snakes.setLastPosition(1+(int)(Math.random()*size)) ;

		//CONDICION DE PARADA
		if(snakes.getFirstPosition() != 1 && snakes.getFirstPosition()!= size && snakes.getLastPosition() != 1 && snakes.getLastPosition() != size && snakes.getLastPosition() != snakes.getFirstPosition()) {
			if(snakes.getFirstPosition() < snakes.getLastPosition()) {
				return;
			}
		}

		//LAMADO RECURSIVO
		organizarSnakes(snakes);

		Node current = origin;

		while(current.getNext() != null) {
			if(current.getPosition() == snakes.getFirstPosition()) {
				current.setSnake(snakes);
			}
			if(current.getPosition() == snakes.getLastPosition()) {
				current.setSnake(snakes);
			}
			current = current.getNext();
		}
	}

	public void createLadder(int ladder) {

		//CONDICION DE PARADA
		if(ladder==0) {
			return;
		}

		Ladder aux = new Ladder(0, 0, "E", null);
		organizarLadder(aux);

		ladder--;

		//llamado  recursivo
		createLadder(ladder);
	}

	private void organizarLadder(Ladder ladder) {

		ladder.setFirstPosition(1+(int)(Math.random()*size)) ;
		ladder.setLastPosition(1+(int)(Math.random()*size)) ;

		//CONDICION DE PARADA
		if(ladder.getFirstPosition() != 1 && ladder.getFirstPosition()!= size && ladder.getLastPosition() != 1 && ladder.getLastPosition() != size && ladder.getLastPosition() != ladder.getFirstPosition()) {
			if(ladder.getFirstPosition() < ladder.getLastPosition()) {
				return;
			}
		}

		//LAMADO RECURSIVO
		organizarLadder(ladder);

		Node current = origin;

		while(current.getNext() != null) {
			if(current.getPosition() == ladder.getFirstPosition()) {
				current.setLadder(ladder);
			}
			if(current.getPosition() == ladder.getLastPosition()) {
				current.setLadder(ladder);
			}
			current = current.getNext();
		}
		
	}
}

