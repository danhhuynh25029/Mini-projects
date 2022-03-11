package bai19;

import java.util.*;

public class BubbleSort {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Program();
	}
	public static void Program() {
		int n = 0;
		System.out.println("======= Bubble Sort Program =======");
		System.out.println("1.Input Element");
		System.out.println("2.Sort Ascending");
		System.out.println("3.Sort Descending");
		int[] arr  = null;
		do {
			System.out.print("Pleas choice one option : ");
			n = scan.nextInt();
			scan.nextLine();
			
			switch(n) {
			case 1:
				String arr_l;
				System.out.println("======= Input Element =======");
				System.out.print("Input length of Array");
				do {
				System.out.print("Enter number : ");
				arr_l = scan.nextLine();
				if(checkIn(arr_l) == null) System.out.println("Please input numberand number is greater than zero");
				}while(checkIn(arr_l) == null);
				arr = new int[Integer.parseInt(arr_l)];
				int i = 0;
				while(i < Integer.parseInt(arr_l)) {
					System.out.print("Enter number " + (i+1) + " : ");
					String tmp = scan.nextLine();
					if(checkIn(tmp) != null) { 
						arr[i] = Integer.parseInt(tmp);
						i += 1;
					}
				}
				break;
			case 2:
				arr = sortAscending(arr);
				System.out.println("======= Ascending =======");
				for(int i1 = 0 ; i1 < arr.length ; i1++) {
					if(i1 != arr.length - 1)
					System.out.print("[" + arr[i1] + "]" + "->");
					else System.out.println("[" + arr[i1] + "]");
				}
				break;
			case 3:
				arr = sortDescending(arr);
				System.out.println("======= Descending =======");
				for(int i1 = 0 ; i1 < arr.length ; i1++) {
					if(i1 != arr.length - 1)
					System.out.print("[" + arr[i1] + "]" + "<-");
					else System.out.println("[" + arr[i1] + "]");
				}
				break;
			}
		}while(n != 4);
	}
	public static  int[] sortAscending(int[] arrayNeedSort) {
		for(int i = 0 ; i < arrayNeedSort.length - 1 ; i++) {
			for(int j = 0 ; j < arrayNeedSort.length - i - 1 ; j++ ) {
				if(arrayNeedSort[j] > arrayNeedSort[j+1]) {
					int tmp = arrayNeedSort[j];
					arrayNeedSort[j] = arrayNeedSort[j+1];
					arrayNeedSort[j+1] = tmp;
				}
			}
		}
		return arrayNeedSort;
		
	}
	public static  int[] sortDescending(int[] arrayNeedSort) {
		for(int i = 0 ; i < arrayNeedSort.length - 1 ; i++) {
			for(int j = 0 ; j < arrayNeedSort.length - i - 1 ; j++ ) {
				if(arrayNeedSort[j] < arrayNeedSort[j+1]) {
					int tmp = arrayNeedSort[j];
					arrayNeedSort[j] = arrayNeedSort[j+1];
					arrayNeedSort[j+1] = tmp;
				}
			}
		}
		return arrayNeedSort;
		
	}
	public static Integer checkIn(String val) {
		try {
			return Integer.parseInt(val);
		} catch (Exception e) {
			return null;
		}
	}
}
