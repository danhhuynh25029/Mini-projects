package bai8;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
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
		quickSort(arr,0,arr.length-1);
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
	 public static int partition(int arr[], int low, int high) {
	        int pivot = arr[high];
	        int i = (low - 1);
	        for (int j = low; j < high; j++) {
	            if (arr[j] < pivot) {
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        int temp = arr[i + 1];
	        arr[i + 1] = arr[high];
	        arr[high] = temp;

	        return i + 1;
	    }
	    public static void quickSort(int arr[], int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            quickSort(arr, low, pi - 1);
	            quickSort(arr, pi + 1, high);
	        }
	    }
}
