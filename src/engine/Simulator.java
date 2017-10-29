package engine;

import java.util.*;

public class Simulator {
	
	Estimator estimator;
	LinkedList<Frame> frames;
	LinkedList<Tag> identifiedTags;
	
	int initialTagsNumber;
	int incrementTagRate;
	int maxTagsNumber;
	int iterationsNumber;
	int initialFrameSize, identifiedTagsNum;
	int backlog;
	
	int successSlots, collisionSlots, emptySlots;
	
	public Simulator(int initialTagsNumber, int incrementTagRate, int maxTagsNumber,
			int iterationsNumber, int initialFrameSize) {
		
		frames = new LinkedList();
		identifiedTags = new LinkedList();
		
		this.initialTagsNumber = initialTagsNumber;
		this.incrementTagRate = incrementTagRate;
		this.maxTagsNumber = maxTagsNumber;
		this.iterationsNumber = iterationsNumber;
		this.initialFrameSize = initialFrameSize;
		this.identifiedTagsNum = 0;
		this.backlog = initialTagsNumber; 
	}
	
	public void execute (String algorithmName) {
		setEstimator (algorithmName);
		Frame currentFrame = new Frame(initialFrameSize);
		// Tag tag = new Tag ();
		 while (identifiedTagsNum < initialTagsNumber) {
		//	for (int i = 0; i < 10; i++) {
			currentFrame.execute(backlog);
			identifiedTagsNum += currentFrame.successfullSlots;
			// System.out.println("Total identified tags " + identifiedTagsNum);
			currentFrame.competingTags = estimator.calculateCompetingTags(currentFrame);
			// System.out.println("Success slots in current frame " + currentFrame.successfullSlots);
			frames.add(currentFrame);
			backlog = initialTagsNumber - identifiedTagsNum;
			currentFrame = estimator.calculateNextFrame(currentFrame);
		}
		
		
	}
	
	void setEstimator (String estimationAlgorithm) {
		if (estimationAlgorithm.equals("lower"))
			this.estimator = new LowBoundEstimator();
		else if (estimationAlgorithm.equals("eom"))
			this.estimator = new EomLeeEstimator();
	}
	
	public void show () {
		int totalSlots, totalEmptySlots, totalSuccessSlots, totalCollisionSlots;
		totalSlots = totalEmptySlots = totalSuccessSlots = totalCollisionSlots = 0;
		for (Frame x : frames) {
			totalSlots += x.slots.length;
			totalEmptySlots += x.emptySlots;
			totalSuccessSlots += x.successfullSlots;
			totalCollisionSlots += x.collisionSlots;
		}
		System.out.println("Total slots " + totalSlots + "\nTotal successful slots " + totalSuccessSlots + "\nTotal collision slots " + totalCollisionSlots + 
				"\nTotal empty slots " + totalEmptySlots);
	}
	
	
}
