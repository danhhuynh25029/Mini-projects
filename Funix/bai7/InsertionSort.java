package bai7;

import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	public static void main(String[] args) {
		System.out.print("Enter number of array : ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = rand.nextInt(n) + 1;
		}
		System.out.print("Unsorted array : ");
		printArray(arr);
		System.out.print("Sorted Array : ");
		arr = insertionSort(arr);
		printArray(arr);
	}
	public static void printArray(int[] arr) {
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
	public static int[] insertionSort(int[] arr) {
		 int n = arr.length;
	       for (int i = 1; i < n; ++i) {
	            int key = arr[i];
	            int j = i - 1;
	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j = j - 1;
	            }
	            arr[j + 1] = key;
	        }
	     return arr;
	}
}
