package bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Student> listStudent = new ArrayList<>();
	public static void main(String[] args) {
		Menu();		
	}
	public static void Menu() {
		int n = 0;
	
		System.out.println(""
				+ "1.Them Sinh vien.\n"
				+ "2.Tim kiem va sap xep.\n"
				+ "3.Cap nhat hoac xoa.\n"
				+ "4.Bao cao.\n"
				+ "0.Thoat.\n"
				);
		do {
			System.out.print("Vui long nham lua chon : ");
			n = scan.nextInt();
			switch(n) {
			case 1:
				if (listStudent.size() >= 10) {
					scan.nextLine();
					System.out.print("Ban co muon tiep tuc khong Y/N : ");
					String check = scan.nextLine();
					if(check.equals("N")) {
						break;
					}
				}
				addStudent();
				break;
			case 2:
				findStudent();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				resultTable();
				break;
			}
		}while(n != 0);
	}
	public static void addStudent(){
		System.out.print("Nhap id : ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.print("Nhap ten : ");
		String name = scan.nextLine();
		System.out.print("Nhap khoa hoc : ");
		String course = scan.nextLine();
		System.out.print("Nhap hoc ky : ");
		int semester = scan.nextInt();
//		System.out.print(name);
		listStudent.add(new Student(id,name,course,semester));
		System.out.println();
	}
	public static void findStudent() {
		scan.nextLine();
		System.out.print("Vui long nhap ten can tim : ");
		String name = scan.nextLine();
		ArrayList<Student> tmp = new ArrayList<>();
		for(Student s : listStudent) {
			if(s.getName().indexOf(name) >= 0) {
				tmp.add(s);
			}
		}
		Collections.sort(tmp,new NameComparator());
		for(Student s : tmp) {
			System.out.println(s.toString());
		}
	}
	public static void searchStudent() {
		scan.nextLine();
		System.out.print("Nhap id ban muon tim : ");
		int id = scan.nextInt();
		int index = -1;
		for(int i = 0 ; i < listStudent.size(); i++) {
			if(listStudent.get(i).getId() == id) {
				index = i;
			}
		}
		scan.nextLine();
		System.out.print("Ban muon xoa(D) hay cap nhat(U) : ");
		String c = scan.nextLine();
		if (c.equals("D")) {
			deleteStudent(index);
		}else if(c.equals("U")){
			updateStudent(index);
		}
	}
	public static void deleteStudent(int index) {
		listStudent.remove(index);
	}
	public static void updateStudent(int index) {
//		scan.nextLine();
//		System.out.print("Nhap id : ");
//		int id = scan.nextInt();
//		scan.nextLine();
		System.out.print("Nhap ten : ");
		String name = scan.nextLine();
		System.out.print("Nhap khoa hoc : ");
		String course = scan.nextLine();
		System.out.print("Nhap hoc ky : ");
		int semester = scan.nextInt();
//		System.out.print(name);
		listStudent.set(index,new Student(listStudent.get(index).getId(),name,course,semester));
		System.out.println();
	}
	public static void resultTable() {
		ArrayList<String> tmpName = new ArrayList<>();
		ArrayList<String> courses = new ArrayList<>();
		for(Student s : listStudent) {
			boolean tmp = false;
			for(int i = 0 ; i < tmpName.size() ; i++) {
				if(s.getName().equals(tmpName.get(i)) && s.getCourse().equals(courses.get(i))) {
					tmp = true;
				}
			}
			if(tmp == true) {
				continue;
			}else {
				int count = 0;
				for(Student s1 : listStudent) {
					if(s.getName().equals(s.getName()) && s.getCourse().equals(s1.getCourse())) {
						count += 1;
					}
				}
				System.out.println(s.getName() + " | " + s.getCourse() + " | " + count);
				tmpName.add(s.getName());
				courses.add(s.getCourse());
			}
		}
	}
}
class Student{
	private int id;
	private String name;
	private int semester;
	private String course;
	public Student(int id,String name,String course,int semester) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.semester = semester;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getCourse() {
		return course;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getSemester() {
		return semester;
	}
	@Override
	public String toString() {
		return this.name + " | " + this.semester + " | " + this.course;
	}
}
class NameComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
	
}