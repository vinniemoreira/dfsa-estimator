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
	}
	
	public void execute (String algorithmName) {
		setEstimator (algorithmName);
		Frame currentFrame = new Frame(initialFrameSize);
		Tag tag = new Tag ();
		while (identifiedTagsNum < initialTagsNumber) {
			
			currentFrame.execute(tag);
			identifiedTagsNum =+ currentFrame.successfullSlots;
			currentFrame.competingTags = estimator.calculateCompetingTags(currentFrame);
			frames.add(currentFrame);
			currentFrame = estimator.calculateNextFrame(currentFrame);
		}
		
		
	}
	
	void setEstimator (String estimationAlgorithm) {
		if (estimationAlgorithm.equals("lower"))
			this.estimator = new LowBoundEstimator();
		else
			this.estimator = new EomLeeEstimator();
	}
	
	public void show () {
		for (Frame x : frames) {
			System.out.println("Success Slots " + x.successfullSlots);
			System.out.println("Collision Slots " + x.collisionSlots);
			System.out.println("SuccessSlots " + x.emptySlots);
			System.out.println("SuccessSlots " + x.competingTags);
		}
	}
	
	
}
