package engine;

import java.util.*;

public class Simulator {
	
	Estimator estimator;
	LinkedList<Frame> frames;
	// LinkedList<Tag> identifiedTags;
	
	int initialTagsNumber;
	int incrementTagRate;
	int maxTagsNumber;
	int iterationsNumber;
	int initialFrameSize;
	int identifiedTagsNum;
	int backlog;
	
	public int successSlots, collisionSlots, emptySlots;
	public double totalSlots;
	
	public Simulator () {
		this.estimator = new LowBoundEstimator();
		this.frames = new LinkedList();
		this.initialTagsNumber = 100;
		this.incrementTagRate = 100;
		this.maxTagsNumber = 1000;
		this.iterationsNumber = 1000;
		this.initialFrameSize = 64;
		this.identifiedTagsNum = 0;
		this.backlog = initialTagsNumber;
	}
	
	public Simulator(int initialTagsNumber, int incrementTagRate, int maxTagsNumber,
			int iterationsNumber, int initialFrameSize) {
		this.estimator = new LowBoundEstimator();
		frames = new LinkedList();
		// identifiedTags = new LinkedList();
		
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
		// Tag tag = new Tag ();
		 while (identifiedTagsNum < initialTagsNumber) {
			currentFrame.execute(backlog);
			identifiedTagsNum += currentFrame.successfullSlots;	
			currentFrame.competingTags = estimator.calculateCompetingTags(currentFrame);
			frames.add(currentFrame);
			backlog = initialTagsNumber - identifiedTagsNum;
			currentFrame = estimator.calculateNextFrame(currentFrame);
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
