package engine;

public class LowBoundEstimator extends Estimator {
	
	public LowBoundEstimator () {}
	
	Frame calculateNextFrameSize (Frame frame) {
		Frame nextFrame;
		// implement
		
		int nextFrameSize = frame.collisionSlots * 2;
		nextFrame = new Frame(nextFrameSize);
		
		
		return nextFrame;
	}
}
