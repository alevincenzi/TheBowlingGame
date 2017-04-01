package bowling;

public class Game {

	private int itsCurrentFrame = 1;
	private boolean firstThrowInFrame = true;
	private Scorer itsScorer = new Scorer();
	
	private void adjustCurrentFrame(int pins){
		
		if (!firstThrowInFrame || (pins == 10))
			itsCurrentFrame++;
			
		firstThrowInFrame = !firstThrowInFrame;
		
		itsCurrentFrame = Math.min(11, itsCurrentFrame);
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
