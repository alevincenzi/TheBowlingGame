package bowling;

public class Game {

	private int[] itsThrows = new int[21];
	private int itsCurrentThrow = 0;
	private int itsCurrentFrame = 1;
	private boolean firstThrow = true;
	
	public int score() {
		return scoreForFrame(currentFrame()-1);
	}

	public int currentFrame() {
		return itsCurrentFrame;
	}
	
	private void adjustCurrentFrame(){
		if (!firstThrow)
			itsCurrentFrame++;
		firstThrow = !firstThrow;
	}
		
	public void add(int pins) {
		itsThrows[itsCurrentThrow++] = pins;
		adjustCurrentFrame(); 
	}

	public int scoreForFrame(int frame) {
		
		int ball = 0;
		int score = 0;
		
		for (int currentFrame = 0; currentFrame < frame; currentFrame++){
			
			// Using local variables to avoid issues about the order
			// when evaluating itsThrows[ball++] + itsThrows[ball++];
			int firstThrow = itsThrows[ball++];
			int secondThrow = itsThrows[ball++];
			
			int frameScore = firstThrow + secondThrow;
			
			if (frameScore == 10)
				score += frameScore + itsThrows[ball];
			else
				score += frameScore; 
		}
		
		return score;
	}

}
