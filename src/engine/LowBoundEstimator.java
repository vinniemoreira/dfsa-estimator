package engine;

public class LowBoundEstimator extends Estimator {
	
	public LowBoundEstimator () {}
	
	public int calculateNextFrame (Frame frame) {
		
		int nextFrameSize = frame.collisionSlots * 2;
	
		return nextFrameSize;
	}
	
	public int calculateCompetingTags (Frame frame) {
		int competingTags = frame.successfullSlots + (2 * frame.collisionSlots);
		return competingTags;
	}
}
