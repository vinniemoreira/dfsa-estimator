package engine;

public abstract class Estimator { 
	
	public abstract int calculateNextFrame (Frame frame);
	public abstract int calculateCompetingTags (Frame frame);
}
