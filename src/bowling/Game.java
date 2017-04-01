package bowling;

public class Game {

	private int itsScore = 0;
	private int[] itsThrows = new int[21];
	private int itsCurrentThrow = 0;
	
	public int score() {
		return itsScore;
	}

	public void add(int pins) {
		itsThrows[itsCurrentThrow++] = pins;
		itsScore += pins;
	}

	public int scoreForFrame(int frame) {
		
		int ball = 0;
		int score = 0;
		
		for (int currentFrame = 0; currentFrame < frame; currentFrame++){
			
			// Using local variables to avoid issues about the order
			// when evaluating itsThrows[ball++] + itsThrows[ball++];
			int firstThrow = itsThrows[ball++];
			int secondThrow = itsThrows[ball++];
			
			score += firstThrow + secondThrow;
		}
		
		return score;
	}

}
