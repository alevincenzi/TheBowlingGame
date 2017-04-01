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

	@Test
	public void twoThrowsNoMark() {
		Game g = new Game();
		g.add(5);
		g.add(4);
		assertEquals(9, g.score());
	}

	@Test
	public void fourThrowsNoMark() {
		Game g = new Game();
		g.add(5);
		g.add(4);
		g.add(7);
		g.add(2);
		assertEquals(18, g.score());
		assertEquals(9,  g.scoreForFrame(1));
		assertEquals(18, g.scoreForFrame(2));
	}
}
