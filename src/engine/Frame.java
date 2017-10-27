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
	
	
	
	public Frame(int initialFrameSize) {
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

	Frame nextFrameSize (Estimator estimator) {
		Frame frame = estimator.calculateNextFrameSize(this);
		return frame;
		
	}
	
	void identifyTag () {
		for (int x : slots) {
			if (x == 1) {
				successfullSlots++;
			} else if (x == 0) {
				emptySlots++;
			} else {
				collisionSlots++;
			}
		}
	}
}
