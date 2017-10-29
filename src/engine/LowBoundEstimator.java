package engine;

public class LowBoundEstimator extends Estimator {
	
	public LowBoundEstimator () {}
	
	Frame calculateNextFrame (Frame frame) {
		Frame nextFrame;
		
		double nextFrameSize = frame.collisionSlots * 2;
		nextFrame = new Frame(nextFrameSize);
		
		
		return nextFrame;
	}
	
	double calculateCompetingTags (Frame frame) {
		double computingTags = Math.ceil(frame.successfullSlots + (2 * frame.collisionSlots));
		return computingTags;
	}
}
