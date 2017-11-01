package engine;

import java.util.*;

public class Simulator {
	
	Estimator estimator;
	LinkedList<Frame> frames;
	
	// LinkedList<Tag> identifiedTags;
	
	double initialTagsNumber;
	double incrementTagRate;
	double maxTagsNumber;
	double iterationsNumber;
	double initialFrameSize;
	double identifiedTagsNum;
	double backlog;
	
	public double successSlots, collisionSlots, emptySlots;
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
	
	public Simulator(String algorithmName, double initialTagsNumber, double incrementTagRate, double maxTagsNumber,
			double iterationsNumber, double initialFrameSize) {
		// this.estimator = new LowBoundEstimator();
		
		if (algorithmName.equals("lower"))
			this.estimator = new LowBoundEstimator();
		else
			this.estimator = new EomLeeEstimator();
			
		
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
		Frame frame = new Frame(initialFrameSize, initialTagsNumber);
		Frame nextFrame;
		// Tag tag = new Tag ();
		 while (identifiedTagsNum < initialTagsNumber) {
			frame.execute(initialTagsNumber);
			identifiedTagsNum += frame.successfullSlots;	
			frames.add(frame);
			backlog = initialTagsNumber - identifiedTagsNum;
			nextFrame = estimator.calculateNextFrame(frame);
			frame = nextFrame;
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

	public double getInitialTagsNumber() {
		return initialTagsNumber;
	}

	public double getIncrementTagRate() {
		return incrementTagRate;
	}

	public double getMaxTagsNumber() {
		return maxTagsNumber;
	}

	public double getIterationsNumber() {
		return iterationsNumber;
	}

	public double getInitialFrameSize() {
		return initialFrameSize;
	}

	public double getIdentifiedTagsNum() {
		return identifiedTagsNum;
	}

	public double getBacklog() {
		return backlog;
	}

	public double getSuccessSlots() {
		return successSlots;
	}

	public double getCollisionSlots() {
		return collisionSlots;
	}

	public double getEmptySlots() {
		return emptySlots;
	}

	public String toString () {
		
		String simulator = "Total slots " + totalSlots + "\nTotal successful slots " + successSlots +
				"\nTotal collision slots " + collisionSlots + 
				"\nTotal empty slots " + emptySlots;
		return simulator;
	}
	
	
}
