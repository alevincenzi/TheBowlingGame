package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bowling.Game;

public class TestGame {

	private Game g;
	
	@Before
	public void setUp() throws Exception {
		g = new Game();
	}

	@After
	public void tearDown() throws Exception {
		// Nothing to do ...
	}
	
	@Test
	public void oneThrow() {
		g.add(5);
		assertEquals(5, g.score());
	}

	@Test
	public void twoThrowsNoMark() {
		g.add(5);
		g.add(4);
		assertEquals(9, g.score());
	}

	@Test
	public void fourThrowsNoMark() {
		g.add(5);
		g.add(4);
		g.add(7);
		g.add(2);
		assertEquals(18, g.score());
		assertEquals(9,  g.scoreForFrame(1));
		assertEquals(18, g.scoreForFrame(2));
	}
	
	@Test
	public void simpleSpare() {
		g.add(3);
		g.add(7);
		g.add(3);
		assertEquals(13,  g.scoreForFrame(1));
	}
}
