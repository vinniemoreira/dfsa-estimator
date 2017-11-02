package engine;

import java.util.*;

public class Simulator {
	public String algorithmName;
	public EomLeeEstimator estimator;
	LinkedList<Frame> frames;
	
	public int initialTagsNumber;
	public int incrementTagRate;
	public int maxTagsNumber;
	public int iterationsNumber;
	public int initialFrameSize;
	public int identifiedTagsNum;
	public int backlog;
	
	public int successSlots, collisionSlots, emptySlots;
	public double totalSlots;
	
	public Simulator(String algorithmName, int initialTagsNumber, int incrementTagRate, int maxTagsNumber,
			int iterationsNumber, int initialFrameSize) {
		// this.estimator = new LowBoundEstimator();
		this.algorithmName = algorithmName;
		frames = new LinkedList();
		
		if (algorithmName.equalsIgnoreCase("eom"))
			this.estimator = new EomLeeEstimator();
		else if (algorithmName.equalsIgnoreCase("lower"));
			this.estimator  = new EomLeeEstimator();
		
		this.initialTagsNumber = initialTagsNumber;
		this.incrementTagRate = incrementTagRate;
		this.maxTagsNumber = maxTagsNumber;
		this.iterationsNumber = iterationsNumber;
		this.initialFrameSize = initialFrameSize;
		this.identifiedTagsNum = 0;
		this.backlog = initialTagsNumber;
		
		successSlots = collisionSlots = emptySlots = 0;
		totalSlots = 0;
	}
	
	public void execute () {
		Frame currentFrame = new Frame(initialFrameSize);
		int nextFrameSize;
		 while (identifiedTagsNum < initialTagsNumber) {
			System.out.println("current backlog " + backlog);
			currentFrame.execute(backlog);
			identifiedTagsNum += currentFrame.successfullSlots;	
			nextFrameSize = estimator.calculateNextFrame(currentFrame);
			// currentFrame.competingTags = estimator.calculateCompetingTags(currentFrame);
			frames.add(currentFrame);
			backlog = initialTagsNumber - identifiedTagsNum;
			currentFrame = new Frame(nextFrameSize);
		}
		calculateUsedSlots(); 
		
		
	}
	
	void calculateUsedSlots () {
		for (Frame x : frames) {
			totalSlots += x.slots.length;
			emptySlots += x.emptySlots;
			successSlots += x.successfullSlots;
			collisionSlots += x.collisionSlots;
		}
	}
	
	public Estimator getEstimator() {
		return estimator;
	}

	public LinkedList<Frame> getFrames() {
		return frames;
	}

	public int getInitialTagsNumber() {
		return initialTagsNumber;
	}

	public int getIncrementTagRate() {
		return incrementTagRate;
	}

	public int getMaxTagsNumber() {
		return maxTagsNumber;
	}

	public int getIterationsNumber() {
		return iterationsNumber;
	}

	public int getInitialFrameSize() {
		return initialFrameSize;
	}

	public int getIdentifiedTagsNum() {
		return identifiedTagsNum;
	}

	public int getBacklog() {
		return backlog;
	}

	public int getSuccessSlots() {
		return successSlots;
	}

	public int getCollisionSlots() {
		return collisionSlots;
	}

	public int getEmptySlots() {
		return emptySlots;
	}

	public String toString () {
		
		String simulator = "Total slots " + totalSlots + "\nTotal successful slots " + successSlots +
				"\nTotal collision slots " + collisionSlots + 
				"\nTotal empty slots " + emptySlots;
		return simulator;
	}
	
	
}
