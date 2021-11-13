package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Snake;

class SnakeTest {

	private Snake snake;
	
	public void setupScenary1() {
		snake = new Snake(2,12,"s",null);
	}
	
	@Test
	public void createSnakeTest() {
		setupScenary1();
		
		assertEquals(snake.getFirstPosition(),2);
		assertEquals(snake.getLastPosition(),12);
		assertEquals(snake.getId(),"s");
		assertEquals(snake.getPlayer(),null);
	}

}
