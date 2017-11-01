package engine;

public class LowBoundEstimator extends Estimator {
	
	public LowBoundEstimator () {}
	
	Frame calculateNextFrame (Frame frame) {
		Frame nextFrame;
		frame.execute(Math.ceil(frame.frameSize));
		
		double nextFrameSize = frame.collisionSlots * 2;
		double competingTags = Math.ceil(frame.successfullSlots + (2 * frame.collisionSlots));
		nextFrame = new Frame(nextFrameSize, competingTags);
		
		
		return nextFrame;
	}
	
	void calculateFactors (Frame frame) {}
}
