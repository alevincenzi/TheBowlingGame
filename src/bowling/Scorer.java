package bowling;

public class Scorer {

	private int   itsCurrentThrow = 0;
	private int[] itsThrows = new int[21];
	private int   ball;
	
	private boolean spare()
	{
		return nextTwoBallsForSpare() == 10;
	}

	private boolean strike()
	{
		return itsThrows[ball] == 10;
	}
	
	private int nextBallForSpare()
	{
		return itsThrows[ball+2];
	}
	
	private int nextTwoBallsForSpare() {
		return itsThrows[ball] + itsThrows[ball+1];
	}

	private int nextTwoBallsForStrike()
	{
		return itsThrows[ball+1] + itsThrows[ball+2];
	}
	
	public void addThrow(int pins)
	{
		itsThrows[itsCurrentThrow++] = pins;
	}
	
	public int scoreForFrame(int theFrame)
	{
		ball = 0;
		int score = 0;
		
		for (int currentFrame = 0; currentFrame < theFrame; currentFrame++)
		{
			if (strike())
			{
				score += 10 + nextTwoBallsForStrike();
				ball += 1;
			}
			else if (spare())
			{
				score += 10 + nextBallForSpare();
				ball += 2;
			}
			else
			{
				score += nextTwoBallsForSpare();
				ball += 2;
			}
		}
		return score;
	}
}
