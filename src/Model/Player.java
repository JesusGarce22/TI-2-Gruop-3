package Model;

public class Player {
	
	private int position;
	private String character;
	private Player next;
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Player getNext() {
		return next;
	}

	public void setNext(Player next) {
		this.next = next;
	}

	public Player(int position, String character) {
		this.position = position;
		this.character = character;
	} 
	
	
}
