package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import sorting.RectanglesSort;
import sorting.SortingAlgorithms;

public class SortingVisualizer extends JPanel {
	
	public static final int NUMBER_OF_RECTANGLES = 128;
	
	private Rectangles rectTopLeft;
	private Rectangles rectTopRight;
	private Rectangles rectBottomLeft;
	private Rectangles rectBottomRight;
	
	public SortingVisualizer(){
		
		this.setBackground(Color.BLACK);
		int[] values = randomNumbers(NUMBER_OF_RECTANGLES);
	
		this.rectTopLeft     = new Rectangles(values, new boolean[NUMBER_OF_RECTANGLES]);
		this.rectTopRight    = new Rectangles(values, new boolean[NUMBER_OF_RECTANGLES]);
		this.rectBottomLeft  = new Rectangles(values, new boolean[NUMBER_OF_RECTANGLES]);
		this.rectBottomRight = new Rectangles(values, new boolean[NUMBER_OF_RECTANGLES]);
		
		JButton sort = new JButton("SORT!");
		JButton newArray = new JButton("New Data.");
		
		sort.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				sort();
			}
		});
		
		newArray.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				int[] values = randomNumbers(NUMBER_OF_RECTANGLES);
				
				rectTopLeft.setValues(values, new boolean[NUMBER_OF_RECTANGLES]);
				rectTopRight.setValues(values, new boolean[NUMBER_OF_RECTANGLES]);
				rectBottomLeft.setValues(values, new boolean[NUMBER_OF_RECTANGLES]);
				rectBottomRight.setValues(values, new boolean[NUMBER_OF_RECTANGLES]);
				
			}
		});
		
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 1500;
		gbc.ipady = 500;
		this.add(rectTopLeft, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(rectTopRight, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		this.add(sort, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(newArray, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 1500;
		gbc.ipady = 500;
		this.add(rectBottomLeft, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(rectBottomRight, gbc);
		
		JFrame frame = new JFrame();
		frame.setTitle("Sorting Visualizer");
		frame.add(this);		
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void sort() {
		
		String sTopLeft     = this.rectTopLeft.getOptionSelected();
		String sTopRight    = this.rectTopRight.getOptionSelected();
		String sBottomLeft  = this.rectBottomLeft.getOptionSelected();
		String sBottomRight = this.rectBottomRight.getOptionSelected();
		
		Thread t1 = new RectanglesSort(this.rectTopLeft    , sTopLeft);
		Thread t2 = new RectanglesSort(this.rectTopRight   , sTopRight);
		Thread t3 = new RectanglesSort(this.rectBottomLeft , sBottomLeft);
		Thread t4 = new RectanglesSort(this.rectBottomRight, sBottomRight);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	
	private int[] randomNumbers(int size) {
		
		int[] randomNumbers = new int[size];
		Random rand = new Random();
		
		for (int i = 0; i < size; i++) {
			
			randomNumbers[i] = rand.nextInt(451) + 50;
			
		}
		
		return randomNumbers;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		new SortingVisualizer();

		
	}
	
	
}
