package engine;

public class LowBoundEstimator extends Estimator {
	
	public LowBoundEstimator () {}
	
	Frame calculateNextFrame (Frame frame) {
		Frame nextFrame;
		
		int nextFrameSize = frame.collisionSlots * 2;
		nextFrame = new Frame(nextFrameSize);
		
		System.out.println("Used lower method");
		return nextFrame;
	}
	
	int calculateCompetingTags (Frame frame) {
		int competingTags = frame.successfullSlots + (2 * frame.collisionSlots);
		return competingTags;
	}
}
