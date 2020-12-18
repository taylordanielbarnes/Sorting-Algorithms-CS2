/*
 * Taylor Barnes
 * Merge Sort Algorithm
 * Create a list of n random numbers
 * Sort them, and display the results
 * O(nlgn)
 */
 
import java.util.Random;



public class MerSort {
	final static int SIZE = 100; //how many numbers to sort
	final static int MAX = 500; //how large the numbers can be
	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] ar = new int[SIZE];
		
		//print the unsorted contents of the array
		for(int i = 0; i < SIZE; i++) {
			ar[i] = Math.abs(rand.nextInt() % MAX);
			System.out.printf("%3d ", ar[i]);
			if(i % 20 == 19) System.out.println("");
		}
		System.out.printf("\n\n\n");
		
		sort(ar, 0, SIZE); //run merge sort
		
		//print the sorted contents of the array
		for(int i = 0; i < SIZE; i++) {
			System.out.printf("%3d ", ar[i]);
			if(i % 20 == 19) System.out.println("");
		}
	}
	
	public static void merge(int[] a, int startInd, int leftSize, int rightSize) {
		int newSize = leftSize + rightSize; //size of the current selection
		int i, l = 0, r = 0;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		
		//populate two arrays, one representing the left half of what's being sorted, one representing the right half
		for(i = 0; i < leftSize; i++) {
			left[i] = a[i + startInd];
		}
		for(i = 0; i < rightSize; i++) {
			right[i] = a[i + startInd + leftSize];
		}
		
		//iterate across the two arrays, merging them together
		for(i = 0; i < newSize; i++) {
			if(l >= leftSize) { //if the left array is empty
				a[i + startInd] = right[r];
				r++;
			}
			else if(r >= rightSize) { //if the right array is empty
				a[i + startInd] = left[l];
				l++;
			}
			else if(left[l] < right[r]) { //if the next option in the left array is smaller
				a[i + startInd] = left[l];
				l++;
			}
			else{ //if the next option in the right array is smaller
				a[i + startInd] = right[r];
				r++;
			}
		}
	}
	
	//recursive algorithm
	public static void sort(int[] a, int startInd, int sz) {
		if(sz < 2) {
			return;
		}
		else {
			int demarc = ((sz - 1) / 2) + 1; //halfway through the current selection
			sort(a, startInd, demarc); //sort the left half of current selection
			sort(a, startInd + demarc, sz - demarc); //sort the right half of current selection
			merge(a, startInd, demarc, sz - demarc); //merge those two halves
		}
		
		return;
	}
}
