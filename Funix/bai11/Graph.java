package bai11;

import java.util.*;

public class Graph {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter the number of nodes on the graph: ");
		int n = scan.nextInt();
		System.out.println("Enter the edge matrix:");
		int[][] arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.nextLine();
		System.out.print("Enter the start point: ");
		int s = scan.nextInt();
		System.out.print("Enter the end point: ");
		int e = scan.nextInt();
		checkEdge(s, e, arr);
	}
	public static void checkEdge(int s,int e,int[][] arr) {
		if(arr[s-1][e-1] == 1) {
			System.out.println("This is an edge");
		}else {
			System.out.println("This is not an edge");
		}
	}
}
