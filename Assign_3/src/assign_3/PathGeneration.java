package assign_3;

import java.util.Random;

public class PathGeneration {
	
	private int[] path;
	
	public PathGeneration(int arrayLength) {	
		path = new int[arrayLength];
		for(int i=0; i<arrayLength-1; i++) {
			path[i] = i;
		}
	}
	
	public void setPath(int[] path) {
		for(int i=0; i<path.length; i++) {
			this.path[i] = path[i];
		}
	}
	
	public int[] getPath() {
		return this.path;
	}
	
	// To interchange 3 of the vertices in the path
	public void mutation(int[] path) {
		int firstR = (int) Math.floor(Math.random()*(path.length));  // first random index
		int secondR = (int) Math.floor(Math.random()*(path.length));  // second random index
		int thirdR = (int) Math.floor(Math.random()*(path.length));  // third random index
		while(secondR==firstR) {  // Make sure the second random number is not the same as the first random number
			secondR = (int) Math.floor(Math.random()*(path.length));
		}
		while(thirdR==firstR || thirdR==secondR) {  // Make sure the third random number is not the same as the first or second one
			thirdR = (int) Math.floor(Math.random()*(path.length));
		}
		
		int reArrange = new Random().nextInt(6); // Randomly pick a way to re-arrange
		int temp;
		switch(reArrange) {
		case 0:  // 1, 2, 3
			// No change
		case 1:  // 1, 3, 2
			temp = path[secondR];
			path[secondR] = path[thirdR];
			path[thirdR] = temp;
		case 2:  // 2, 1, 3
			temp = path[firstR];
			path[firstR] = path[secondR];
			path[secondR] = temp;
		case 3:  // 2, 3, 1
			temp = path[firstR];
			path[firstR] = path[secondR];
			path[secondR] = path[thirdR];
			path[thirdR] = temp;
		case 4:  // 3, 1, 2
			temp = path[firstR];
			path[firstR] = path[thirdR];
			path[thirdR] = path[secondR]; 
			path[secondR] = temp;
		case 5:  // 3, 2, 1
			temp = path[firstR];
			path[firstR] = path[thirdR];
			path[thirdR] = temp; 
		}
		this.setPath(path);
	}
	
	// This method shuffles an array using Fisher-Yates shuffle
	public void shuffle(int[] path) {
		int temp;
		int randomIndex;
		for(int i=0; i<path.length-1; i++) {
			int lastIndex = path.length-1;
			randomIndex = (int) Math.floor(Math.random()*(path.length));  // int from 0 to numVertices
			temp = path[randomIndex];
			path[randomIndex] = path[lastIndex-i];
			path[lastIndex-i] = temp;
		}
		this.setPath(path);
	}
	
	// This method prints all elements in the array
	public void print(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
}
