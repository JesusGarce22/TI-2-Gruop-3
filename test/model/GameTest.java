package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Game;

class GameTest {
	
	private Game play;
	
	public void setupScenary1() {
		play=null;
	}
	
	public void setupScenary2() {
		play = new Game(4,4);
	}
	
	@Test
	public void newGame() {
	  setupScenary2();
	  
	  //assert.equals(obj));
	}

}
