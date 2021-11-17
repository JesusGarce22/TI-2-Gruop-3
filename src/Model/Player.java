package Model;

public class Player {
	
	private int position;
	private String character;
	private int numMovimientos;
	
	public Player(int position, String character,int n) {
		this.position = position;
		this.character = character;
		numMovimientos=n;
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
	
	public void tablePositions(Player p[],int n) {
		
		if(n==p.length) {
			return;
		}
		
		System.out.println("(Position) "+character+" "+position );
		
		n++;
		tablePositions(p, n);
	}

	public int getNumMovimientos() {
		return numMovimientos;
	}

	public void setNumMovimientos(int numMovimientos) {
		this.numMovimientos = numMovimientos;
	}

	public void win() {
		System.out.println(character+" has won with "+numMovimientos +" moves");
	}


}
