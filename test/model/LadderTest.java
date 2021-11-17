package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LadderTest {

private Ladder ladder;
	
	public void setupScenary1() {
		ladder = new Ladder(4,19,"l",null);
	}
	
	public void setupScenary2() {
		
		ladder = new Ladder(6,15,"i",null);
	}
	
	@Test
	public void createLadder() {
		setupScenary1();
		
		assertEquals(ladder.getFirstPosition(),4);
		assertEquals(ladder.getLastPosition(),19);
		assertEquals(ladder.getId(),"l");
		assertEquals(ladder.getPlayer(),null);
	}
	
	@Test
	public void upForTheLadder() {
		setupScenary2();
		Player p = new Player(6,"+",0);
		
		ladder.setPlayer(p);
		ladder.move(p);
		assertEquals(p.getPosition(),15);
	}

}
