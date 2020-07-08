package sorting;

import gui.Rectangles;

public class RectanglesSort extends Thread {

	private Rectangles rect;
	private String typeOfSort;
	
	public RectanglesSort(Rectangles rect, String typeOfSort) {
		
		this.rect = rect;
		this.typeOfSort = typeOfSort;
		
	}
	
	@Override
	public void run() {
		
		if (this.typeOfSort.equals("Selection Sort")) SortingAlgorithms.selectionSort(rect, rect.getValues(), rect.getValuesBool());
		else if (this.typeOfSort.equals("Bubble Sort")) SortingAlgorithms.bubbleSort(rect, rect.getValues(), rect.getValuesBool());
		else if (this.typeOfSort.equals("Insertion Sort")) SortingAlgorithms.insertionSort(rect, rect.getValues(), rect.getValuesBool());
		else if (this.typeOfSort.equals("Quick Sort")) SortingAlgorithms.quickSort(rect, rect.getValues(), rect.getValuesBool());
		else if (this.typeOfSort.equals("Merge Sort")) SortingAlgorithms.mergeSort(rect, rect.getValues(), rect.getValuesBool());
		else if (this.typeOfSort.equals("Heap Sort")) SortingAlgorithms.heapSort(rect, rect.getValues(), rect.getValuesBool());
		else if (this.typeOfSort.equals("Bitonic Sort")) SortingAlgorithms.bitonicSort(rect, rect.getValues(), rect.getValuesBool());
		
	}
}
