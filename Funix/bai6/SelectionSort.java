package bai6;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
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
		arr = selectionSort(arr);
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
	public static int[] selectionSort(int[] arr) {
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			int min = i;
			for(int j = i+1 ; j < arr.length; j++ ) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
		return arr;
	}
}
