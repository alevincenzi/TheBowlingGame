package bowling;

public class Game {

	private int itsCurrentFrame = 1;
	private boolean firstThrowInFrame = true;
	private Scorer itsScorer = new Scorer();
	
	private void advanceFrame() {
		itsCurrentFrame = Math.min(11, itsCurrentFrame + 1);
	}
	
	private boolean adjustFrameForStrike(int pins) {
		
		if (pins == 10) {
			advanceFrame();
			return true;
		}
		
		return false;
	}
	
	private void adjustCurrentFrame(int pins){
		
		if (firstThrowInFrame) {
			if (adjustFrameForStrike(pins) == false)
				firstThrowInFrame = false; 
		} else {
			firstThrowInFrame = true;
			advanceFrame();
		}	
	}

	public int score() {
		return scoreForFrame(currentFrame()-1);
	}

	public int currentFrame() {
		return itsCurrentFrame;
	}
	
	public int scoreForFrame(int theFrame) {
		return itsScorer.scoreForFrame(theFrame);
	}

	public void add(int pins) {
		itsScorer.addThrow(pins);
		adjustCurrentFrame(pins); 
	}
}
