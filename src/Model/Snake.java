package Model;

public class Snake {

	private int FirstPosition;
	private int LastPosition;
	private String id;
	private Player player;
	
	public Snake(int firstPosition, int lastPosition, String id,Player p) {
		FirstPosition = firstPosition;
		LastPosition = lastPosition;
		this.id = id;
		player=p;
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
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void move(Player p) {
		if(this.getPlayer()==p && p.getPosition()==LastPosition) {
			p.setPosition(FirstPosition);
		}
	}
}
