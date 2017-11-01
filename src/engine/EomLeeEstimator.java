package engine;

public class EomLeeEstimator extends Estimator {

	double factorB, factorY, threshold;
	
	public EomLeeEstimator() {
		// TODO Auto-generated constructor stub
		
		factorB = Double.POSITIVE_INFINITY;
		factorY = 2;
		threshold = 0.1;
	}
	
	Frame calculateNextFrame(Frame frame) {
		Frame nextFrame;
		calculateFactors(frame);
		
		
		double competingTags, nextFrameSize;
		nextFrameSize = factorY * frame.collisionSlots;
		competingTags = nextFrameSize/factorB;
		
		nextFrame = new Frame (nextFrameSize, competingTags);
		return nextFrame;
	}
	
	void calculateFactors (Frame frame) {
		double currentB = 0;
		double prevB = factorB;
		double currentY = 0;
		double prevY = factorY;
		while ((currentY - prevY) > threshold){
			currentB = (frame.frameSize)/((prevY*frame.collisionSlots)+frame.successfullSlots);
			currentY = (1 - Math.pow(Math.E, -(1/currentB))/(currentB * (1 - (1+1/currentB) * Math.pow(Math.E, -(1/currentB)))));
			prevB = currentB;
			prevY = currentY;
		}
		
		factorB = currentB;
		factorY = currentY;
	}
}
