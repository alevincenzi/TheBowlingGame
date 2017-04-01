package bowling;

public class Game {

	private int ball = 0;

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

	private int twoBallsInFrame() {
		return itsThrows[ball] + itsThrows[ball+1];
	}

	private int nextBallForSpare() {
		return itsThrows[ball+2];
	}

	private boolean spare() {
		return (itsThrows[ball] + itsThrows[ball+1]) == 10;
	}

	private boolean strike() {
		return itsThrows[ball] == 10;
	}
	
	private int nextTwoBallsForStrike() {
		return itsThrows[ball+1] + itsThrows[ball+2];
	}

	public void add(int pins) {
		itsThrows[itsCurrentThrow++] = pins;
		adjustCurrentFrame(pins); 
	}

	public int scoreForFrame(int theFrame) {
		
		ball = 0;
		int score = 0;
		
		for (int currentFrame = 0; currentFrame < theFrame; currentFrame++){
			
			if (strike()){
				score += 10 + nextTwoBallsForStrike();
				ball += 1;
			}
			else if (spare()) {
				score += 10 + nextBallForSpare();
				ball += 2;
			}
			else {
				score += twoBallsInFrame();
				ball += 2;
			}
		}
		
		return score;
	}

}
