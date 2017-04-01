package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.Frame;

public class TestFrame {

	@Test
	public void ScoreNoThrows() {
		Frame f = new Frame();
		assertEquals(0, f.getScore());
	}

}
