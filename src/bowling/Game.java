package bowling;

public class Game {

	private int ball = 0;
	private int firstThrow;
	private int secondThrow;

	private int[] itsThrows = new int[21];
	private int itsCurrentThrow = 0;
	private int itsCurrentFrame = 1;
	private boolean firstThrowInFrame = true;
	
	public int score() {
		return scoreForFrame(currentFrame()-1);
	}

	public int currentFrame() {
		return itsCurrentFrame;
	}
	
	private void adjustCurrentFrame(int pins){
		
		if (!firstThrowInFrame || (pins == 10))
			itsCurrentFrame++;
			
		firstThrowInFrame = !firstThrowInFrame;
		
		itsCurrentFrame = Math.min(11, itsCurrentFrame);
	}

	private int handleSecondThrow(){

		int score = 0;
		
		secondThrow = itsThrows[ball++];
	
		int frameScore = firstThrow + secondThrow;
	
		if (frameScore == 10)
			score += frameScore + itsThrows[ball];
		else
			score += frameScore;
		
		return score;
	}
	
	public void add(int pins) {
		itsThrows[itsCurrentThrow++] = pins;
		adjustCurrentFrame(pins); 
	}

	public int scoreForFrame(int theFrame) {
		
		ball = 0;
		int score = 0;
		
		for (int currentFrame = 0; currentFrame < theFrame; currentFrame++){
			
			firstThrow = itsThrows[ball++];
			
			if (firstThrow == 10)
				
				score += 10 + itsThrows[ball] + itsThrows[ball+1];
			
			else 

				score += handleSecondThrow();
		}
		
		return score;
	}

}
