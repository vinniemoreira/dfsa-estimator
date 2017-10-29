package engine;

public abstract class Estimator { 
	
	abstract Frame calculateNextFrame (Frame frame);
	abstract double calculateCompetingTags (Frame frame);
}
