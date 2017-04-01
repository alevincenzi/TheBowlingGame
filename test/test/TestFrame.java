package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.Frame;

public class TestFrame {

	@Test
	public void scoreNoThrows() {
		Frame f = new Frame();
		assertEquals(0, f.getScore());
	}

	@Test
	public void addOneThrow() {
		Frame f = new Frame();
		f.add(5);
		assertEquals(5, f.getScore());
	}
}
