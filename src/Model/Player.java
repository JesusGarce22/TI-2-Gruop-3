package Model;

public class Player {
	
	private int position;
	private String character;
	
	public Player(int position, String character) {
		this.position = position;
		this.character = character;
	} 

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
	
	public void boardPosition() {
		
		System.out.println(character+" "+position);
	}




}
