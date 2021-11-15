package Model;

public class Ladder {
	
	private int FirstPosition;
	private int LastPosition;
	private String id;
	private Player player;
	
	public Ladder(int firstPosition, int lastPosition, String id,Player lader) {
		FirstPosition = firstPosition;
		LastPosition = lastPosition;
		this.id = id;
		player = lader;
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
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player nextLadder) {
		this.player = nextLadder;
	}
	public void move(Player p) {
		if(this.getPlayer()==p && p.getPosition()==FirstPosition) {
			p.setPosition(LastPosition);
		}
	}
	
}
