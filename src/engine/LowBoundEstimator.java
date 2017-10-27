package engine;

public class LowBoundEstimator extends Estimator {
	
	public LowBoundEstimator () {}
	
	Frame calculateNextFrame (Frame frame) {
		Frame nextFrame;
		
		int nextFrameSize = frame.collisionSlots * 2;
		nextFrame = new Frame(nextFrameSize);
		
		
		return nextFrame;
	}
}
