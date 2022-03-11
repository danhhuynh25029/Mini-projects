package bai29;

import java.util.*;
public class InforProgram {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Person[] person = new Person[3];
		System.out.println("======= Management Person programer =======");
		int i = 0;
		do {
			System.out.println("Input Information of Person");
			System.out.print("Please input name : ");
			String name = scan.nextLine();
			System.out.print("Please input address : ");
			String address = scan.nextLine();
			
			Person p;
			do {
				System.out.print("Please input salary : ");
				String sSalary = scan.nextLine();
				p = inputPersonInfo(name, address, sSalary);
			}while(p == null);
			person[i] = p;
			i += 1;
		}while(i < 3);
		person = sortBySalary(person);
		for(i = 0 ; i < person.length ; i++) {
			displayPersonInfor(person[i]);
		}
	}
	public static Person inputPersonInfo(String name,String address,String sSalary) {
		try {
			double salary = Double.parseDouble(sSalary);
			if(salary < 0) {
				System.out.println("You must input positive");
				return null;
			}else {
				Person p = new Person(name,address,salary);
				return p;
			}
		}catch (Exception e) {
			System.out.println("You must input is digit");
			return null;
		}
		
	}
	public static void displayPersonInfor(Person person) {
		System.out.println("Information of Person you have entered:");
		System.out.println("Name : " + person.getName());
		System.out.println("Address : " + person.getAddress());
		System.out.println("Salary : " + person.getSalary());
		System.out.println();
	}
	public static Person[] sortBySalary(Person[] person) {
		for(int i = 0 ; i < person.length - 1 ; i++) {
			for(int j = 0 ; j < person.length - i - 1 ; j++ ) {
				if(person[j].getSalary() > person[j+1].getSalary()) {
					Person tmp = person[j];
					person[j] = person[j+1];
					person[j+1] = tmp;
				}
			}
		}
		return person;
	}
}
class Person{
	private String name;
	private String address;
	private double salary;
	public Person(String name,String address,double salary) {
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}