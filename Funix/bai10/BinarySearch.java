package bai10;

import java.util.*;

public class BinarySearch {
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.print("Enter number of array : ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = rand.nextInt(n) + 1;
		}
		System.out.print("Enter search value : ");
		int k = scan.nextInt();
		System.out.print("Sorted array : ");
		bs.sort(arr);
		bs.printArray(arr);
		bs.search(arr, k);
		
	}
	void search(int[] arr,int k) {
		int l = 0;
		int r = arr.length;
		while(l < r) {
			int m = (l+r)/2;
			if(arr[m] == k) {
				System.out.println("Found " + k + " at index: " + m);
				break;
			}
			if(arr[m] > k) r = m - 1;
			if(arr[m] < k) l = m + 1;
			
		}
	}
	void sort(int[] arr) {
			for(int i = 0 ; i < arr.length - 1 ; i++) {
				for(int j = 0 ; j < arr.length - i - 1 ; j++ ) {
					if(arr[j] > arr[j+1]) {
						int tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}
	}
	void printArray(int[] arr) {
		System.out.print("[ ");
		for(int i = 0 ; i < arr.length ; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i] + " ");
			}else {
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.println("]");
	}
}
