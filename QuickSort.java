/*
 * Taylor Barnes
 * QuickSort Algorithm
 * Create a list of n random numbers
 * Sort them, and display the results
 * O(n^2)
 */

import java.util.*;



public class QuickSort {
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
		
		sort(ar, 0, SIZE - 1); //run quicksort
		
		//print the sorted contents of the array
		for(int i = 0; i < SIZE; i++) {
			System.out.printf("%3d ", ar[i]);
			if(i % 20 == 19) System.out.println("");
		}
	}
	
	//recursive sorting algorithm
	public static void sort(int[] a, int p, int r) {
		int q = partition(a, p, r); //set pivot point
		if(p < q - 1)
			sort(a, p, q - 1); //sort everything less than the pivot
		if(q + 1 < r)
			sort(a, q + 1, r); //sort everything greater than the pivot
		return;
	}
	
	public static int partition(int[] a, int p, int r) {
		int q = p;
		int temp;
		
		for(int i = p; i < r; i++) { //iterate across everything to the left/right of the pivot
			if(a[i] <= a[r]) { //change this line to >= to sort in decreasing order
			
				//swap the selected number if it is on the wrong side of the pivot
				temp = a[i];
				a[i] = a[q];
				a[q] = temp;
								
				q++;
			}
		}
		
		//put the pivot in its place
		temp = a[q];
		a[q] = a[r];
		a[r] = temp;
		
		return q;
	}
}
