package engine;

public abstract class Estimator { 
	
	abstract Frame calculateNextFrame (Frame frame);
	abstract int calculateCompetingTags (Frame frame);
}
