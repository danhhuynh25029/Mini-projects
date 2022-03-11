package bai12;

import java.util.*;

public class CountWord {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter your content : ");
		String s = scan.nextLine();
		String[] arr = s.split(" ");
		countWord(arr);
		countChar(s);
	}
	
	public static void countWord(String[] arr) {
		System.out.print("{");
		ArrayList<String> tmp = new ArrayList<>();
 		for(int i = 0 ; i < arr.length ; i++ ) {
 			boolean check = false;
 			for(String s : tmp) {
 				if(s.equals(arr[i])) {
 					check =true;
 					break;
 				}
 			}
 			if(check == false) {
				int count = 1;
				for(int j = i + 1 ; j < arr.length ; j++) {
					if(arr[i].equals(arr[j])) {
						count += 1;
					}
				}
				if(i != arr.length - 1)
				System.out.print(arr[i] + "=" + count + ", ");
				else System.out.print(arr[i] + "=" + count);
				tmp.add(arr[i]);
 			}
		}
		System.out.println("}");
	}
	public static void countChar(String s) {
		System.out.print("{");
		ArrayList<Character> tmp = new ArrayList<>();
		for(int i = 0 ; i < s.length() ; i++ ) {
			boolean check = false;
			for(char c : tmp) {
				if(c == s.charAt(i)) {
					check = true;
					break;
				}
			}
			if(s.charAt(i) != ' ' && check == false ) {
				int count = 1;
				for(int j = i + 1 ; j < s.length() ; j++) {
					if(s.charAt(i) == (s.charAt(j))) {
						count += 1;
					}
				}
				if(i != s.length() - 1)
				System.out.print(s.charAt(i) + "=" + count + ", ");
				else System.out.print(s.charAt(i) + "=" + count);
				tmp.add(s.charAt(i));
			}
		}
		System.out.println("}");
	}
}
