package program;

import engine.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String estimationAlgorithm = args[0];
		int initialTagsNumber = Integer.parseInt(args[1]);
		int incrementTagRate = Integer.parseInt(args[2]);
		int maxTagsNumber = Integer.parseInt(args[3]); 
		int iterationsNumber = Integer.parseInt(args[4]);
		int initialFrameSize = Integer.parseInt(args[5]);
		
		
		Simulator simulator = new Simulator (initialTagsNumber, incrementTagRate,
				maxTagsNumber, iterationsNumber, initialFrameSize);
		
		simulator.execute(estimationAlgorithm);
		simulator.show();
		
		

	}

}
