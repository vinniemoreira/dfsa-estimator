package engine;

public class EomLeeEstimator extends Estimator {

	double factorB, factorY, threshold;
	
	public EomLeeEstimator() {
		// TODO Auto-generated constructor stub
		
		factorB = Double.POSITIVE_INFINITY;
		factorY = 2;
		threshold = 0.1;
	}
	
	@Override
	Frame calculateNextFrame(Frame frame) {
		// TODO Auto-generated method stub
		double n = 0;
		double prevFactorY = 0;
		while ((factorY - prevFactorY) > threshold) {
			prevFactor
			factorB = (frame.frameSize)/((prevFactorY*frame.collisionSlots)+frame.successfullSlots);
			factorY = 
		}
		
		
		
		
		Frame answer = new Frame(n); 
		return answer;
	}
	
	double calculateCompetingTags (Frame frame) {
		
		
		
		double answer = 0;
		return answer;
	}

}
