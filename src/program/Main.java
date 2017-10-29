package program;

import engine.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String estimationAlgorithm = args[0];
		int initialTagsNumber = Integer.parseInt(args[1]);
		int incrementTagRate = Integer.parseInt(args[2]);
		int maxTagsNumber = Integer.parseInt(args[3]); 
		int iterationsNumber = Integer.parseInt(args[4]);
		int initialFrameSize = Integer.parseInt(args[5]);
		LinkedList<Simulator> simulators = new LinkedList();
		
		double totalSlotsAvg, totalEmptySlots, totalSuccessSlots, totalCollisionSlots;
		totalSlotsAvg = totalEmptySlots = totalSuccessSlots = totalCollisionSlots = 0;
		
		for (int i = 0; i < iterationsNumber; i++) {
			Simulator simulator = new Simulator (initialTagsNumber, incrementTagRate, maxTagsNumber,
					iterationsNumber, initialFrameSize);
			simulator.execute();
			simulators.add(simulator);
			
		}
		
		for (Simulator x : simulators) {
			totalSlotsAvg += x.totalSlots;
			totalCollisionSlots += x.collisionSlots;
			totalEmptySlots += x.emptySlots;
		}
		
		totalSlotsAvg = Math.ceil(totalSlotsAvg/simulators.size());
		totalCollisionSlots = Math.ceil(totalCollisionSlots/simulators.size());
		totalEmptySlots = Math.ceil(totalEmptySlots/simulators.size());
		
		System.out.println("total slots avg " + totalSlotsAvg + "\ncollision slots avg " + totalCollisionSlots + 
		"\nempty slots avg " + totalEmptySlots);
		
		
		
		

	}

}
