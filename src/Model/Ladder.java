package Model;

public class Ladder {
	
	private int FirstPosition;
	private int LastPosition;
	private String id;
	private Player nextLadder;
	public Ladder(int firstPosition, int lastPosition, String id) {
		super();
		FirstPosition = firstPosition;
		LastPosition = lastPosition;
		this.id = id;
	}
	public int getFirstPosition() {
		return FirstPosition;
	}
	public void setFirstPosition(int firstPosition) {
		FirstPosition = firstPosition;
	}
	public int getLastPosition() {
		return LastPosition;
	}
	public void setLastPosition(int lastPosition) {
		LastPosition = lastPosition;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Player getNextLadder() {
		return nextLadder;
	}
	public void setNextLadder(Player nextLadder) {
		this.nextLadder = nextLadder;
	}
	
	
}
