package bai26;

import java.util.*;

public class Program {
	static Scanner scan = new Scanner(System.in);
	static int wallet = 0;
	static Person p1;
	public static void main(String[] args) {
		Program p = new Program();
		System.out.println("======= Shopping program ======");
		System.out.print("Input number of bill : ");
		int n = scan.nextInt();
		int[] bill = new int[n];
		for(int i = 0 ; i < n ; i++) {
			System.out.print("Input value of bill " + (i+1)  + " : ");
			int tmp = scan.nextInt();
			bill[i] = tmp;
		}
		System.out.print("Input value of wallet : ");
		wallet = scan.nextInt();
		p1 = new Person(new Wallet(wallet));
		int total = p.calcTotal(bill);
		System.out.println("This is total of bill : " + total);
		if(p.payMoney(total) == true) {
			System.out.println("You can buy it");
		}else {
			System.out.println("You can't buy it");
		}
	}
	public int calcTotal(int[] bill) {
		int total = 0;
		for(int i = 0 ; i < bill.length ; i++) {
			total += bill[i];
		}
		return total;
	}
	public boolean payMoney(int total) {
		if(p1.getW().getWallet() >= total) {
			return true;
		}else{
			return false;
		}
	}
}
class Person{
	private Wallet w;
	public Person(Wallet w) {
		this.w = w;
	}
	public void setW(Wallet w) {
		this.w = w;
	}
	public Wallet getW() {
		return w;
	}
}
class Wallet{
	private int wallet;
	public Wallet(int wallet) {
		this.wallet = wallet;
	}
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
}