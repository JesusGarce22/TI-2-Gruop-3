package Model;

public class Snake {

	private int FirstPosition;
	private int LastPosition;
	private String id;
	private Player nextSnake;
	public Snake(int firstPosition, int lastPosition, String id) {
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
	public Player getNextSnake() {
		return nextSnake;
	}
	public void setNextSnake(Player nextSnake) {
		this.nextSnake = nextSnake;
	}
	
}
