package engine;

public class Simulator {
	String estimationAlgorithm;
	int initialTagsNumber;
	int incrementTagRate;
	int maxTagsNumber;
	int iterationsNumber;
	int initialFrameSize;
	
	public Simulator(String estimationAlgorithm, int initialTagsNumber, int incrementTagRate, int maxTagsNumber,
			int iterationsNumber, int initialFrameSize) {
		
		this.estimationAlgorithm = estimationAlgorithm;
		this.initialTagsNumber = initialTagsNumber;
		this.incrementTagRate = incrementTagRate;
		this.maxTagsNumber = maxTagsNumber;
		this.iterationsNumber = iterationsNumber;
		this.initialFrameSize = initialFrameSize;
	}
	
	void execute () {
		
		// implement
	}
	
	
}
