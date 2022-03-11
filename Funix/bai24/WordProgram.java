package bai24;

import java.util.*;

public class WordProgram {
	static Scanner scan = new Scanner(System.in);
	static HashMap<String, String> dic = new HashMap<>();
	public static void main(String[] args) {
		Program();
	}
	public static void Program() {
		int n = 0;
		System.out.println("======= Dictionary program =======");
		System.out.println(".    Add Word");
		System.out.println(".    Delete Word");
		System.out.println(".    Translate");
		
		do {
			System.out.print("Please choice one option : ");
			n = scan.nextInt();
			scan.nextLine();
			switch(n) {
			case 1:
				System.out.println("------- Add Word -------");
				System.out.print("Enter English : ");
				String eng = scan.nextLine();
				System.out.print("Enter Vietnamese : ");
				String vn = scan.nextLine();
				boolean b = addWord(eng,vn);
				if(b == true) {
					System.out.println("Sucessful");
				}
				break;
			case 2:
				System.out.println("------- Delete Word -------");
				System.out.print("Enter English : ");
				String eng1 = scan.nextLine();
				boolean b1 = removeWord(eng1);
				if(b1 == true) {
					System.out.println("Sucessful");
				}
				break;
			case 3:
				System.out.println("------- Translate -------");
				System.out.print("Enter English : ");
				String eng2 = scan.nextLine();
				String vn1 = Translate(eng2);
				if(vn1 == null) {
					System.out.println("Word is not exists");
				}else {
				System.out.println("Vietnamese : " + vn1);
				}
				break;
			}
		}while(n != 4);
	}
	public static boolean addWord(String eng,String vn){
		if(dic.get(eng) != null) {
			System.out.print("You want update word Y/N : ");
			String c = scan.nextLine();
			if(c.equals("Y")) {
				dic.put(eng, vn);
				return true;
			}else {
				return false;
			}
		}
		dic.put(eng, vn);
		return true;
	}
	public static boolean removeWord(String eng){
		if(dic.get(eng) != null) {
			dic.remove(eng);
			return true;
		}else {
			System.out.println("Word is not exists");
			return false;
		}
	}
	public static String Translate(String eng) {
		return dic.get(eng);
	}
}
