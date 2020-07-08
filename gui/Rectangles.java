package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Rectangles extends JPanel {

	private static final String[] SORTING_ALGORITHMS = {"Selection Sort", "Bubble Sort", "Insertion Sort", "Quick Sort", "Merge Sort", "Heap Sort", "Bitonic Sort"};
	private static final int RECTANGLE_WIDTH = 8;
	private static final int RECTANGLE_MAX_HEIGHT = 500;
	
	private boolean isSorted;
	private int[] values;
	private boolean[] valuesBool;
	private JComboBox sortingAlgorithmList;
	
	protected Rectangles(int[] values, boolean[] valuesBool) {
		
		setValues(values, valuesBool);
		this.isSorted = false;
		
		this.setBackground(Color.BLACK);
		this.sortingAlgorithmList = new JComboBox(SORTING_ALGORITHMS);
		this.add(sortingAlgorithmList);
		
	}
	
	@Override
	public void paintComponent(Graphics graphic) {
		
		super.paintComponent(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		int x = 10; //Starting x coordinate
	
		if (this.isSorted) {
			
			for (int i = 0; i < this.values.length; i++) {
				
				if(this.valuesBool[i]) {
					graphic2D.setColor(Color.GREEN);
				}
				else graphic2D.setColor(Color.WHITE);
				
				graphic2D.fill3DRect(x, RECTANGLE_MAX_HEIGHT - this.values[i], RECTANGLE_WIDTH, this.values[i], false);
				x += 10;
				
			}
			
		} else {
			
			for (int i = 0; i < this.values.length; i++) {
				
				if(this.valuesBool[i]) {
					this.valuesBool[i] = false;
					graphic2D.setColor(Color.RED);
				}
				else graphic2D.setColor(Color.WHITE);
					
				graphic2D.fill3DRect(x, RECTANGLE_MAX_HEIGHT - this.values[i], RECTANGLE_WIDTH, this.values[i], false);
				x += 10;
				
			}
		}
	}
	
	public void paintSorted() {
		
		this.isSorted = true;
		this.valuesBool = new boolean[this.valuesBool.length];
		
		for (int i = 0; i < this.values.length; i++) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.valuesBool[i] = true;
			this.repaint();
			
		}
	}
	
	public String getOptionSelected() {
		
		return this.sortingAlgorithmList.getSelectedItem().toString();
		
	}
	
	public int[] getValues() {
		
		return this.values;
		
	}
	
	public boolean[] getValuesBool() {
		
		return this.valuesBool;
		
	}
	
	public boolean getIsSorted() {
		return this.isSorted;
	}
	
	public void setIsSorted(boolean isSorted) {
		this.isSorted = isSorted;
	}
	
	public void setValues(int[] values, boolean[] valuesBool) {
		
		this.values = Arrays.copyOf(values, values.length);
		this.valuesBool = valuesBool;
		this.isSorted = false;
		this.repaint();
		
	}
}
