package assign_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	private double[][] fileData;
	private int elements;
	
	public ReadFile() {
		
	}
	
	public void setFileData(String filePath) {
		try {
			File file = new File(filePath);
			Scanner scan = new Scanner(file);
			elements = scan.nextInt();
			fileData = new double[elements][2];
			while(scan.hasNext()) {
				int index = scan.nextInt()-1;          // the vertex number
				fileData[index][0] = scan.nextDouble();  // x coordinate
				fileData[index][1] = scan.nextDouble();  // y coordinate
			}
			scan.close();
		}catch(FileNotFoundException f) {  // the path to the file is wrong
			f.printStackTrace();
		}
	}
	
	public double[][] getFileData(){
		return this.fileData;
	}
	
	public int getElements() {
		return this.elements;
	}
	
	public void printData() {
		for(int i=0; i<fileData.length; i++) {
			for(int j=0; j<fileData[i].length; j++) {
				System.out.print(fileData[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}
