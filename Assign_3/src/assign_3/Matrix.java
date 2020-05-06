package assign_3;

import java.util.Scanner;

public class Matrix {
	private double[][] matrix;
	
	public Matrix () {
		
	}
	
	public void setMatrix(double[][] fileData) {
		matrix = new double[fileData.length][fileData.length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				double x1 = fileData[i][0];
				double y1 = fileData[i][1];
				double x2 = fileData[j][0];
				double y2 = fileData[j][1];
				matrix[i][j] = Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
			}
		}
	}
	
	
	
	public double[][] getMatrix(){
		return this.matrix;
	}
	
	
	// Print all elements in the matrix
	public void printMatrix() {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}
