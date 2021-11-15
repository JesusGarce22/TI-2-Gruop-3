package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Player;
import Model.Snake;

class SnakeTest {

	private Snake snake;
	
	public void setupScenary1() {
		snake = new Snake(2,12,"s",null);
	}
	
	public void setupScenary2() {
		
		snake = new Snake(5,20,"i",null);
	}
	
	@Test
	public void createSnakeTest() {
		setupScenary1();
		
		assertEquals(snake.getFirstPosition(),2);
		assertEquals(snake.getLastPosition(),12);
		assertEquals(snake.getId(),"s");
		assertEquals(snake.getPlayer(),null);
	}
	
	@Test
	public void dowhForTheSnake() {
		setupScenary2();
		Player p = new Player(20,"+");
		
		snake.setPlayer(p);
		snake.move(p);
		assertEquals(p.getPosition(),5);
	}

}
