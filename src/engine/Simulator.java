package engine;

import java.util.LinkedList;

public class Simulator {
	String estimationAlgorithm;
	// Reader reader;
	Estimator estimator;
	LinkedList<Frame> frames = new LinkedList();
	LinkedList<Tag> identifiedTags = new LinkedList();
	
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
		setEstimator(this.estimationAlgorithm);
		while (identifiedTags.size() < initialTagsNumber) {
			
			Frame currentFrame = new Frame(this.initialFrameSize);
			frames.add(currentFrame);
			estimator.calculateNextFrame(currentFrame);
		}
		
		
	}
	
	void setEstimator (String estimationAlgorithm) {
		if (estimationAlgorithm.equals("lower"))
			this.estimator = new LowBoundEstimator();
		else
			this.estimator = new EomLeeEstimator();
	}
	
	
}
