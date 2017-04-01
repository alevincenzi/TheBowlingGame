package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.Game;

public class TestGame {

	@Test
	public void oneThrow() {
		Game g = new Game();
		g.add(5);
		assertEquals(5, g.score());
	}

}
