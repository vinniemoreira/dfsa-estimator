package engine;

import java.util.ArrayList;

public class Frame {
	int initialFrameSize;
	int [] slots;
	ArrayList<Tag> identifiedTags;
	int successfullSlots;
	int collisionSlots;
	int emptySlots;
	int competingTags;
	int backlog;
	
	
	
	public Frame(int initialFrameSize, Tag[] identifiedTags) {
		super();
		this.initialFrameSize = initialFrameSize;
		this.slots = new int [initialFrameSize];
		this.identifiedTags = new ArrayList();
		this.successfullSlots = 0;
		this.collisionSlots = 0;
		this.emptySlots = 0;
		this.competingTags = 0;
		this.backlog = 0;
	}

	double nextFrameSize (Estimator estimator) {
		double res = estimator.calculateNextFrameSize(this);
		return res;
		
	}
	
	void identifyTag () {
		// implement
	}
}
