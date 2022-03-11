package bai14;

import java.util.Random;
import java.util.Scanner;


public class LinearSearch {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	public static void main(String[] args) {
		LinearSearch ls = new LinearSearch();
		System.out.print("Enter number of array : ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = rand.nextInt(n) + 1;
		}
		System.out.print("Enter search value : ");
		int k = scan.nextInt();
		System.out.print("Sorted array : ");
//		bs.sort(arr);
		ls.printArray(arr);
		ls.search(arr, k);
		
	}
	void search(int[] arr,int k) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] == k) {
				System.out.println("Found " + k + " at index: " + i);
				break;
			}
			i += 1;
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
