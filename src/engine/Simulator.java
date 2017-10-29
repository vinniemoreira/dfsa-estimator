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
			System.out.println("Total identified tags " + identifiedTagsNum);
			currentFrame.competingTags = estimator.calculateCompetingTags(currentFrame);
			System.out.println("Success slots in current frame " + currentFrame.successfullSlots);
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
		for (Frame x : frames) {
			System.out.println("Success Slots " + x.successfullSlots);
			System.out.println("Collision Slots " + x.collisionSlots);
			System.out.println("SuccessSlots " + x.emptySlots);
			System.out.println("Total competing Tags " + x.competingTags);
			System.out.println("Total used slots " + x.successfullSlots + collisionSlots + emptySlots);
			System.out.println("Frame size " + x.frameSize + "\n");
		}
	}
	
	
}
