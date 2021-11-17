package Model;

import java.util.ArrayList;


public class Game
{
	private Node origin;
	private Node last;
	private Player[] players;
	
	private int filas;
	private int columnas;

	private int size;

	public Game(int filas, int columnas,int numPlayers)
	{
		this.filas = filas;
		this.columnas = columnas;
		size = filas*columnas;
		origin = createBoard(size);
		players = new Player[numPlayers];
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
	
	public void showBoardWithPlayers() {
	Node current = origin;
		
	if(current.getSnake()!=null || current.getLadder()!=null || current.getPlayer()!=null) {
		
		System.out.print(current.getSnake());
		}
	
		if(current.getNext() != null){
			return;
		}
		
		current = current.getNext();
		
		showBoardWithPlayers();
	}

	public void starGame(String[] ids,int snake,int ladder) {

		for(int i=0;i<players.length;i++) {
			players[i] = new Player(1,ids[i],0);
		}

		createSnake(snake);
		createLadder(ladder);
	}

	public void move(int n) {

		int move=Throw();

		players[n].setPosition(players[n].getPosition()+move);
		players[n].setNumMovimientos(players[n].getNumMovimientos()+1);
		System.out.println("The Player "+players[n].getCharacter()+" is in the position "+players[n].getPosition());
		
		Node current = origin;
	
		while(current.getNext() != null) {

			if(current.getPosition()==players[n].getPosition()) {
				current.setPlayer(players[n]);
			}
			if(current.getLadder() != null ) {
				current.getLadder().move(players[n]);
			}
			if(current.getSnake() != null ) {
				current.getSnake().move(players[n]);
			}
			if(players[n].getPosition()>=size) {
				players[n].win();
				System.exit(0);
				
			}
			
			current = current.getNext();
		}
		
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

		Snake aux = new Snake(0, 0, "S", null);
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
		Node current = origin;

		while(current.getNext() != null) {
			if(current.getPosition() == snakes.getFirstPosition() && current.getLadder()==null) {
				current.setSnake(snakes);
			}
			if(current.getPosition() == snakes.getLastPosition() && current.getLadder()==null) {
				current.setSnake(snakes);
			}
			current = current.getNext();
		}
		//LAMADO RECURSIVO
		organizarSnakes(snakes);


	}

	public void createLadder(int ladder) {

		//CONDICION DE PARADA
		if(ladder==0) {
			return;
		}

		Ladder aux = new Ladder(0, 0, "l", null);
		organizarLadder(aux);

		ladder--;

		//llamado  recursivo
		createLadder(ladder);
	}

	public void organizarLadder(Ladder ladder) {

		ladder.setFirstPosition(1+(int)(Math.random()*size)) ;
		ladder.setLastPosition(1+(int)(Math.random()*size)) ;

		//CONDICION DE PARADA
		if(ladder.getFirstPosition() != 1 && ladder.getFirstPosition()!= size && ladder.getLastPosition() != 1 && ladder.getLastPosition() != size && ladder.getLastPosition() != ladder.getFirstPosition()) {
			if(ladder.getFirstPosition() < ladder.getLastPosition()) {
				return;
			}
		}

			Node current = origin;

		while(current.getNext() != null) {
			if(current.getPosition() == ladder.getFirstPosition() && current.getSnake()==null) {
				current.setLadder(ladder);
			}
			if(current.getPosition() == ladder.getLastPosition() && current.getSnake()==null) {
				current.setLadder(ladder);
			}
			current = current.getNext();
		}
		
		//LAMADO RECURSIVO
		organizarLadder(ladder);
	
	}
	
	public void printTablePosition(int num) {
		Player pAux[]=getPlayers();
	
		pAux[num].tablePositions(pAux,num);
		
	}

	public Player[] getPlayers() {
		return players;
	}

}

