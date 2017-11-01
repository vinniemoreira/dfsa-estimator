package engine;

public class EomLeeEstimator extends Estimator {

	double factorB, factorY, threshold, frameSize, competingTags;
	
	public EomLeeEstimator() {
		// TODO Auto-generated constructor stub
		
		factorB = Double.POSITIVE_INFINITY;
		factorY = 2;
		threshold = 0.5;
		frameSize = 0;
		competingTags = 0;
	}
	
	@Override
	Frame calculateNextFrame(Frame frame) {
		// TODO Auto-generated method stub
		Frame newFrame;
		double currentY = 0;
		double prevY = factorY;
		double currentB = factorB;
		while ((currentY - prevY) > threshold) {
			currentB = (frame.frameSize)/((prevY*frame.collisionSlots)+frame.successfullSlots);
			
			currentY = (1 - Math.pow(Math.E, -(1/currentB))/(currentB * (1 - (1+1/currentB) * Math.pow(Math.E, 1/currentB))));
		}
		
		factorY = currentY;
		factorB = currentB;
		double frameSize = currentY * frame.collisionSlots;
		
		this.frameSize = frameSize;
		newFrame = new Frame((int) frameSize);
		System.out.println("Used eom lee method");
		return newFrame;
	}
	
	int calculateCompetingTags (Frame frame) {
		int answer = 0;
		
		answer = (int) Math.ceil(this.frameSize/factorB);
		
		return answer;
	}

}
