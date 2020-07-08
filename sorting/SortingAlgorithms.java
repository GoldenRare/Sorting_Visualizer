package sorting;

import java.util.Arrays;

import gui.Rectangles;

public class SortingAlgorithms {

	private SortingAlgorithms() {
		
	}
	
	//Time Complexity : O(n^2)
	//Space Complexity: O(1)
	//Technically supposed to find the min before swapping
	public static void selectionSort(Rectangles rect, int[] arr, boolean[] arrBool) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				
				if (arr[j] < arr[i]) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					arrBool[i] = arrBool[j] = true;
					rect.repaint();
					
				}
			}
		}
		
		rect.paintSorted();
		
	}
	
	//Time Complexity : O(n^2)
	//Space Complexity: O(1)
	public static void bubbleSort(Rectangles rect, int[] arr, boolean[] arrBool) {
		
		boolean isSorted = false;
		boolean wasSwapped = false;
		
		while (!isSorted) {
			
			for (int i = 0; i < arr.length - 1; i++) {
				
				if (arr[i + 1] < arr[i]) {
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					arrBool[i] = arrBool[i + 1] = true;
					rect.repaint();
					wasSwapped = true;
				}
			}
			
			isSorted = (wasSwapped) ? false : true;
			wasSwapped = false;
		}
		rect.paintSorted();
	}
	
	//Time Complexity : O(n^2)
	//Space Complexity: O(1)
	public static void insertionSort(Rectangles rect, int[] arr, boolean[] arrBool) {
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				
				if (arr[j] < arr[j - 1]) {
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					
					arrBool[j] = arrBool[j - 1] = true;
					rect.repaint();
					
				}
			}
		}
		rect.paintSorted();
	}
	
	//Time Complexity : O(n^2)
	//Space Complexity: O(1) - Iterative version of Quick Sort
	public static void quickSort(Rectangles rect, int[] arr, boolean[] arrBool) {
		
		int start, end;
		int[] stack = new int[arr.length];
		int pop = -1;
		
		stack[++pop] = 0;
		stack[++pop] = arr.length - 1;
		
		while (pop >= 0) {
			
			end   = stack[pop--];
			start = stack[pop--];
			
			int pivotIndex = partition(rect, arr, arrBool, start, end);
			
			if ((pivotIndex - 1) > start) {
				
				stack[++pop] = start;
				stack[++pop] = pivotIndex - 1;
				
			}
			
			if ((pivotIndex + 1) < end) {
				
				stack[++pop] = pivotIndex + 1;
				stack[++pop] = end;
				
			}
		}
		
		rect.paintSorted();
		
		
//		quickSort(rect, arr, arrBool, start, pivotIndex - 1);
//		quickSort(rect, arr, arrBool, pivotIndex + 1, end);
		
	}
	
	private static int partition(Rectangles rect, int[] arr, boolean[] arrBool, int start, int end) {
		
		int pivot = arr[end];
		
		for (; start < end; start++) {
			
			if (arr[start] > pivot) {
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				arr[end] = arr[start];
				arr[start] = arr[end - 1];
				arr[end - 1] = pivot;
				
				arrBool[start] = arrBool[end] = arrBool[end - 1] = true;
				rect.repaint();
				
				start--;
				end--;
			}
		}
		return end;
	} 
	
	//Time Complexity : O(n * log(n))
	//Space Complexity: O(1) - Iterative version of Merge Sort
	public static void mergeSort(Rectangles rect, int[] arr, boolean[] arrBool) {
		
		for (int subArrSize = 1; subArrSize < arr.length; subArrSize *= 2) {
			
			for (int i = 0; i < arr.length; i += (2*subArrSize)) {
				
				int left = i;
				int middle = Math.min(left + subArrSize - 1, arr.length - 1);
				int right = Math.min(middle + subArrSize, arr.length - 1);
				
				merge(rect, arr, arrBool, left, middle, right);
			}
		}
		rect.paintSorted();
	}
	
	private static void merge(Rectangles rect, int[] arr, boolean[] arrBool, int left, int middle, int right) {
		
		int subArraySize = middle - left + 1;
		int[] arrLeft  = new int[subArraySize];
		int[] arrRight = new int[subArraySize];
		
		int leftArrEnd = subArraySize;
		int rightArrEnd = right - middle;
		
		for (int i = 0; i < leftArrEnd; i++) {
			arrLeft[i] = arr[left + i];
		}
		
		for (int i = 0; i < rightArrEnd; i++) {
			arrRight[i] = arr[middle + i + 1];
		}
		
		
		int i, j, k;
		i = j = 0;
		k = left;
		
		while ((i < leftArrEnd) && (j < rightArrEnd)) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (arrLeft[i] < arrRight[j]) {
				
				arr[k] = arrLeft[i++];
				arrBool[k] = true;
				rect.repaint();
				
			} else {
				
				arr[k] = arrRight[j++];
				arrBool[k] = true;
				rect.repaint();
			}
			
			k++;
			
		}
		
		while (i < leftArrEnd) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			arr[k++] = arrLeft[i++];
			arrBool[k - 1] = true;
			rect.repaint();
			
		}
		
		while (j < rightArrEnd) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			arr[k++] = arrRight[j++];
			arrBool[k - 1] = true;
			rect.repaint();
			
		}
	}
	
	//Time Complexity : O(n * log(n))
	//Space Complexity: O(1)
	
	public static void heapSort(Rectangles rect, int[] arr, boolean[] arrBool) {
		
		for (int i = (arr.length / 2) - 1; i > -1; i--) {
			
			heapify(rect, arr, arrBool, i, arr.length);
			
		}
		
		for (int i = arr.length - 1; i > 0; i--) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			arrBool[0] = arrBool[i] = true;
			rect.repaint();
			
			heapify(rect, arr, arrBool, 0, i);
			
		}
		
		rect.paintSorted();
	}
	
	private static void heapify(Rectangles rect, int[] arr, boolean[] arrBool, int currentIndex, int arrSize) {
		
		int largest = currentIndex;
		int leftChild  = (currentIndex * 2) + 1;
		int rightChild = leftChild + 1;
		
		if ((leftChild  < arrSize) && (arr[leftChild]  > arr[largest])) largest = leftChild;
		if ((rightChild < arrSize) && (arr[rightChild] > arr[largest])) largest = rightChild;
		
		if (largest != currentIndex) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int temp = arr[currentIndex];
			arr[currentIndex] = arr[largest];
			arr[largest] = temp;
			
			arrBool[currentIndex] = arrBool[largest] = true;
			rect.repaint();
			
			heapify(rect, arr, arrBool, largest, arrSize);
			
		}
	}
	
	public static void bitonicSort(Rectangles rect, int[] arr, boolean[] arrBool) {
	
		for (int currGroupSize = 2; currGroupSize <= arr.length; currGroupSize *= 2) {
			makeBitonic(rect, arr, arrBool, currGroupSize);
		}
		rect.paintSorted();
	}
	
	private static void makeBitonic(Rectangles rect, int[] arr, boolean[] arrBool, int currGroupSize) {
		
		boolean makeIncreasing;
		int count, makeIncreasingCount;
		count = makeIncreasingCount = 0;
		int makeIncreasingCheck = currGroupSize;
		
		for (int k = currGroupSize; k >= 2; k /= 2) {
			
			makeIncreasing = true;
			makeIncreasingCount = 0;
			count = 0;
			
			for (int i = 0; i < arr.length; i++) {
				
				int j = i + (k / 2);
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (makeIncreasing) {
					if(arr[i] > arr[j]) {
						
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						arrBool[i] = arrBool[j] = true;
						rect.repaint();
						
					}
				} else {
					
					if(arr[i] < arr[j]) {
						
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						arrBool[i] = arrBool[j] = true;
						rect.repaint();
						
					}
				}
				
				count++;
				makeIncreasingCount++;
				
				if (makeIncreasingCount == (makeIncreasingCheck / 2)) {
					makeIncreasing = !makeIncreasing;
					makeIncreasingCount = 0;
				}
				
				if (count == (k / 2)) {
					
					
					i += (k / 2);
					count = 0;
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*
		int[] a = {64, 25, 12, 22, 11};
		selectionSort(a);
		System.out.println(Arrays.toString(a));
		
		int[] b = {64, 34, 25, 12, 22, 11, 90};
		bubbleSort(b);
		System.out.println(Arrays.toString(b));
		
		int[] c = {12, 11, 13, 5, 6};
		insertionSort(c);
		System.out.println(Arrays.toString(c));
		
		int[] d = {12, 11, 13, 5, 6, 7};
		mergeSort(d);
		System.out.println(Arrays.toString(d));
	
		int[] e = {10, 7, 8, 9, 1, 5};
		quickSort(e);
		System.out.println(Arrays.toString(e));
		
		int[] f = {4, 10, 3, 5, 1};
		heapSort(f);
		System.out.println(Arrays.toString(f));
		
		int[] g = {3, 7, 4, 8, 6, 2, 1, 5};
		bitonicSort(g);
		System.out.println(Arrays.toString(g));
		
		*/
			
	}
}
