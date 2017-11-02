package engine;

public class EomLeeEstimator extends Estimator {

	double factorB, factorY, threshold, frameSize, competingTags;
	
	public EomLeeEstimator() {
		// TODO Auto-generated constructor stub
		
		factorB = Double.POSITIVE_INFINITY;
		factorY = 2;
		threshold = 0.01;
		frameSize = 0;
		competingTags = 0;
	}
	
	@Override
	public int calculateNextFrame(Frame frame) {
		System.out.println("Used eom lee method");
		
		double currentY = 0;
		double prevY = factorY;
		double currentB = factorB;
		 do {
			currentB = (frame.frameSize)/((prevY*frame.collisionSlots)+frame.successfullSlots);
			prevY = currentY;
			currentY = (1 - Math.pow(Math.E, -(1/currentB))/(currentB * (1 - (1 + (1/currentB)) * Math.pow(Math.E, -(1/currentB)))));
		} while ((currentY - prevY) > threshold);
		
		factorY = currentY;
		factorB = currentB;
		double frameSize = currentY * frame.collisionSlots;
		
		this.frameSize = frameSize;
		// newFrame = new Frame((int) (frameSize));
		return (int) Math.ceil(frameSize);
	}
	
	public int calculateCompetingTags (Frame frame) {
		int answer = 0;
		
		answer = (int) Math.ceil(this.frameSize/factorB);
		
		return answer;
	}

}
