package assign_3;

import java.util.Scanner;

public class Search {

	private double currentBest = 0;
	
	public Search() {
		
	}
	
	public void doSearch(String filePath, int searches, int iterations) {
		ReadFile aFile = new ReadFile();  
		aFile.setFileData(filePath);
		Matrix m = new Matrix();
		m.setMatrix(aFile.getFileData());
		PathGeneration p = new PathGeneration(aFile.getElements());
		CalcDistance c = new CalcDistance();
		double currentDistance;
		double newDistance;
		int[] currentPath;
		int[] mutated;
		int[] temp = new int[p.getPath().length];
		currentBest = c.getTotalDistance(m.getMatrix(), p.getPath());
		System.out.println("Original: " + currentBest);
		for(int i=0; i<searches; i++) {
			p.shuffle(p.getPath());
			currentPath = p.getPath();
			currentDistance = c.getTotalDistance(m.getMatrix(), currentPath);
			for(int j=0; j<iterations; j++) {
				for(int a=0; a<p.getPath().length; a++) {   // copy the array before mutation
					temp[a] = p.getPath()[a];
				}
				p.mutation(p.getPath());
				mutated = p.getPath();
				newDistance = c.getTotalDistance(m.getMatrix(), mutated);
				if(newDistance < currentDistance) {
					currentDistance = newDistance;
					p.setPath(mutated);
				}else {
					p.setPath(temp);
				}
			}
			if(currentDistance < currentBest) {
				this.setCurrentBest(currentDistance);
			}
		}
	}
	
	
	
	public void setCurrentBest(double currentBest) {
		this.currentBest = currentBest;
	}
	
	public double getCurrentBest() {
		return this.currentBest;
	}
	
}