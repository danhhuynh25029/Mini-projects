package bai31;

import java.util.*;

public class Program {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		System.out.println("======= Management Student Program =======");
		do {
			System.out.print("Name : ");
			String name = scan.nextLine();
			System.out.print("Classes : ");
			String classes = scan.nextLine();
			
			String maths = null;
			do {
				System.out.print("Maths : ");
				maths = scan.nextLine();
				if(checkNumber(maths) == true) {
					if(Double.parseDouble(maths) < 0) {
						System.out.println("Maths is greater than equal zero");
					}
					else if(Double.parseDouble(maths) > 10) {
						System.out.println("Maths is less than equal ten");
					}else {
						break;
					}
				}else {
					System.out.println("Maths is digit");
				}
			}while(true);
			String chemistry = null;
			do {
				System.out.print("Chemistry : ");
				chemistry = scan.nextLine();
				if(checkNumber(chemistry) == true) {
					if(Double.parseDouble(chemistry) < 0) {
						System.out.println("Chemistry is greater than equal zero");
					}
					else if(Double.parseDouble(chemistry) > 10) {
						System.out.println("Chemistry is less than equal ten");
					}else {
						break;
					}
				}else {
					System.out.println("Chemistry is digit");
				}
			}while(true);
			String physics = null;
			do {
				System.out.print("Physics : ");
				physics = scan.nextLine();
				if(checkNumber(physics) == true) {
					if(Double.parseDouble(physics) < 0) {
						System.out.println("Physics is greater than equal zero");
					}
					else if(Double.parseDouble(physics) > 10) {
						System.out.println("Physics is less than equal ten");
					}else {
						break;
					}
				}else {
					System.out.println("Physics is digit");
				}
			}while(true);
			Student s = createStudent(name, classes, Double.parseDouble(maths), Double.parseDouble(chemistry), Double.parseDouble(physics));
			students.add(s);
			System.out.print("Do you want to enter more student information?(Y/N): ");
			String c = scan.nextLine();
			if(!c.equals("Y")) {
				break;
			}
		}while(true);
		students = averageStudent(students);
		HashMap<String,Double> percent = getPercentTypeStudent(students);
		for(int i = 0 ; i < students.size() ; i++) {
			System.out.println("------- Student" + (i+1) + "Info -------");
			System.out.println("Name : " + students.get(i).getName());
			System.out.println("Classes : " + students.get(i).getClasses());
			System.out.println("AVG : " + students.get(i).getAVG());
			System.out.println("Type : " + students.get(i).getType());
		}
		System.out.println("------- Classification Info -------");
		for(String key : percent.keySet()) {
			System.out.println(key + ": " + percent.get(key) + "%");
		}
	}
	public static boolean checkNumber(String s) {
		try {
			double n = Double.parseDouble(s);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public static Student createStudent(String name, String classes, double maths, double chemistry, double physics)
	{
		Student s = new Student(name, classes, maths, chemistry, physics);
		return s;
	}
	public static List<Student> averageStudent(List<Student> students){
		for(Student s : students) {
			double AVG = (s.getChemistry() + s.getMaths() + s.getPhysics())/3;
			if(AVG > 7.5) {
				s.setAVG(AVG);
				s.setType("A");
			}else if(6 <= AVG && AVG <= 7.5) {
				s.setAVG(AVG);
				s.setType("B");
			}else if(4 <= AVG && AVG < 6) {
				s.setAVG(AVG);
				s.setType("C");
			}else {
				s.setAVG(AVG);
				s.setType("D");
			}
		}
		return students;
	}
	public static HashMap<String,Double> getPercentTypeStudent(List<Student> students){
		HashMap<String,Double> percent = new HashMap<>();
		String[] types = {"A","B","C","D"};
		for(int i = 0 ; i < types.length ; i++) {
			int count = 0;
			for(Student s : students) {
				if(s.getType().equals(types[i])) {
					count += 1;
				}
			}
			double  d = (count*100)/students.size();
			System.out.println(d);
			percent.put(types[i],d);
		}
		return percent;
	}
}
class Student{
	private String name;
	private String classes;
	private double maths;
	private double chemistry;
	private double physics;
	private double AVG;
	private String type;
	public Student(String name,String classes,double maths,double chemistry,double physics) {
		this.name = name;
		this.classes = classes;
		this.maths = maths;
		this.chemistry = chemistry;
		this.physics = physics;
	}
	public void setAVG(double aVG) {
		AVG = aVG;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAVG() {
		return AVG;
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public double getMaths() {
		return maths;
	}
	public void setMaths(float maths) {
		this.maths = maths;
	}
	public double getChemistry() {
		return chemistry;
	}
	public void setChemistry(float chemistry) {
		this.chemistry = chemistry;
	}
	public double getPhysics() {
		return physics;
	}
	public void setPhysics(float physics) {
		this.physics = physics;
	}
	
}