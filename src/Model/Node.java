package Model;

public class Node
{
	// Valores
	private Snake snake;
	private Ladder ladder;
	private int position;
	private Player player;

	// Referencias

	private Node next;
	private Node prev;

	public Node(int position)
	{
		this.position = position;

	}


	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public String toString()
	{
		String msg;
		int loc = position+1;

		msg = "[" + loc + " " +  "]";

		return msg;
	}


	public Snake getSnake() {
		return snake;
	}


	public void setSnake(Snake snake) {
		this.snake = snake;
	}


	public Ladder getLadder() {
		return ladder;
	}


	public void setLadder(Ladder ladder) {
		this.ladder = ladder;
	}


	public int getPosition() {
		return position;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}




	
}
