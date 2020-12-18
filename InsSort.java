/*
 * Taylor Barnes
 * Insertion Sort Algorithm
 * Create a list of n random numbers
 * Sort them, and display the results
 * O(n^2)
 */

import java.util.Random;



public class InsSort {
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
		
		
		int temp1, temp2, j;
		for(int i = 1; i < SIZE; i++) { //iterate over the entire array
			temp1 = ar[i];
			j = i;
			while(j > 0) { //move backward through array until the first i + 1 elements are sorted
				if(ar[i] <= ar[j - 1]) {
					j--;
					continue;
				}
				else
					break;
			}
			
			while(j <= i) { //move everything up the line
				temp2 = ar[j];
				ar[j] = temp1;
				temp1 = temp2;
				j++;
			}
		}
		
		//print the sorted contents of the array
		for(int i = 0; i < SIZE; i++) {
			System.out.printf("%3d ", ar[i]);
			if(i % 20 == 19) System.out.println("");
		}
	}
}
