package assign_3;

import java.util.Scanner;

public class CalcDistance {

	public CalcDistance(){
		
	}
	
	public double getTotalDistance(double[][] matrix, int[] path) {
		double totalDistance = 0;
		for(int i=0; i<path.length-1; i++) {
			totalDistance = totalDistance + this.getDistance(matrix, path[i], path[i+1]);
		}
		return totalDistance;
	}
	
	public double getDistance(double[][] matrix, int index1, int index2) {
		return matrix[index1][index2];	
	}
}