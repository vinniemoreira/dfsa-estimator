package engine;

import java.util.LinkedList;

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
		Tag tag = new Tag ();
		 while (identifiedTagsNum < initialTagsNumber) {
		//	for (int i = 0; i < 10; i++) {
			currentFrame.execute(backlog, tag);
			identifiedTagsNum += currentFrame.successfullSlots;
			backlog = currentFrame.collisionSlots;
			System.out.println(identifiedTagsNum);
			currentFrame.competingTags = estimator.calculateCompetingTags(currentFrame);
			System.out.println(currentFrame.successfullSlots);
			frames.add(currentFrame);
			Frame temp = currentFrame;
			currentFrame = estimator.calculateNextFrame(temp);
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
