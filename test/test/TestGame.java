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
		assertEquals(13, g.scoreForFrame(1));
	}
	
	@Test
	public void simpleFrameAfterSpare() {
		g.add(3);
		g.add(7);
		g.add(3);
		g.add(2);
		assertEquals(13, g.scoreForFrame(1));
		assertEquals(18, g.scoreForFrame(2));
		assertEquals(18, g.score());
	}
	
	@Test
	public void simpleStrike() {
		g.add(10);
		g.add(3);
		g.add(6);
		assertEquals(19, g.scoreForFrame(1));
		assertEquals(28, g.score());
	}
	
	@Test
	public void perfectGame() {
		
		for (int i=0; i < 12; i++)
			g.add(10);
		
		assertEquals(300, g.score());
	}	
	
	@Test
	public void endOfArray() {

		for (int i=0; i < 9; i++){
			g.add(0);
			g.add(0);
		}
		
		g.add(2);
		g.add(8); // 10th frame spare
		g.add(10); // strike in the last position
		
		assertEquals(20, g.score());
	}
	
	@Test
	public void sampleGame(){
		g.add(1); g.add(4);
		g.add(4); g.add(5);
		g.add(6); g.add(4);
		g.add(5); g.add(5); 
		g.add(10);
		g.add(0); g.add(1);
		g.add(7); g.add(3);
		g.add(6); g.add(4);
		g.add(10);          
		g.add(2); g.add(8); g.add(6);

		assertEquals(133, g.score());
	}
	
	@Test
	public void hearthBreak(){

		for (int i=0; i < 9; i++)
			g.add(10);
		
		g.add(10);
		g.add(10);
		g.add(9);
		
		assertEquals(299, g.score());
	}
	
	@Test
	public void tenthFrameSpare(){

		for (int i=0; i < 9; i++)
			g.add(10);
		
		g.add(9);
		g.add(1);
		g.add(1);
		
		assertEquals(270, g.score());
	}
}
