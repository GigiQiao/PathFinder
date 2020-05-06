package assign_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyGUI extends JFrame{
	
	JTextField pathText;
	JTextField curBestText;
	JTextField threadText;
	JTextField searchText;
	JTextField iterationText;
	String filePath;
	double currentBest;
	int threads;
	int searches;
	int iterations;
	
	public MyGUI() {
		JFrame frame = new JFrame();
		JPanel container = new JPanel(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new Graph();
		
		// Set the frame size
		frame.setSize(new Dimension(1400, 900));
		// Set a default close action
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Center the frame to middle of screen
		frame.setLocationRelativeTo(null);
		// Set a title
		frame.setTitle("TSP Solver");		
		// Set up panel1
		this.setupPanel(panel1, panel2);
		
		container.add(panel1,BorderLayout.NORTH);
		container.add(panel2,BorderLayout.CENTER);
		frame.add(container);
		frame.setVisible(true);
	}
	
	public void setupPanel(JPanel aPanel, JPanel panel2) {  		//Add components to the panel
		// Set label, button and text field
		JLabel filePath = new JLabel("File Path");
		JLabel currentBest = new JLabel("Current Best");
		JLabel threadNum = new JLabel("Number of Threads");
		JLabel searchNum = new JLabel("Number of Searches");
		JLabel iterationNum = new JLabel("Number of Iterations");
		JButton runSearch = new JButton("Run Search");
		runSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == runSearch) {
					updateInfo();
					Search s = new Search();
					String filePath = getFilePath();  // C:\BrockU\COSC2P05\Assign_3\berlin52.txt
					int iterations = getIterations();
					int searches = getSearches();				
					s.doSearch(filePath, searches, iterations);
					System.out.println("Current Best: " + s.getCurrentBest());
					panel2.repaint();
					TextArea text = new TextArea(50,30);
					text.setText("Current Best: " + s.getCurrentBest());
					panel2.add(text);
					
					curBestText.setText(Double.toString(s.getCurrentBest()));
				}
			}
		});
		pathText = new JTextField();
		pathText.setPreferredSize(new Dimension(200,20));
		curBestText = new JTextField();
		curBestText.setPreferredSize(new Dimension(100,20));
		threadText = new JTextField();
		threadText.setPreferredSize(new Dimension(100,20));
		searchText = new JTextField();
		searchText.setPreferredSize(new Dimension(100,20));
		iterationText = new JTextField();
		iterationText.setPreferredSize(new Dimension(100,20));
		aPanel.add(filePath);
		aPanel.add(pathText);
		aPanel.add(runSearch);
		aPanel.add(currentBest);
		aPanel.add(curBestText);
		aPanel.add(threadNum);
		aPanel.add(threadText);
		aPanel.add(searchNum);
		aPanel.add(searchText);
		aPanel.add(iterationNum);
		aPanel.add(iterationText);
	}
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public double getCurrentBest() {
		return currentBest;
	}

	public void setCurrentBest(double currentBest) {
		this.currentBest = currentBest;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public int getSearches() {
		return searches;
	}

	public void setSearches(int searches) {
		this.searches = searches;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	
	
	public void updateInfo() {
		this.setFilePath(pathText.getText());
		this.setThreads(Integer.valueOf(threadText.getText()));
		this.setSearches(Integer.valueOf(searchText.getText()));
		this.setIterations(Integer.valueOf(iterationText.getText()));
	}
	
	

	public static void main(String args[]) {
		MyGUI myGUI = new MyGUI();
		
	}
}
