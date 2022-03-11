package bai27;

import java.util.*;

public class Program {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("======= Calculator Shape Program");
		System.out.print("Please input side width of Rectangle : ");
		double w = scan.nextDouble();
		System.out.print("Please input length of Rectangle : ");
		double l = scan.nextDouble();
		System.out.print("Please input radius of Circle : ");
		double r = scan.nextDouble();
		System.out.print("Please input side A of Triangle : ");
		double A = scan.nextDouble();
		System.out.print("Please input side B of Triangle : ");
		double B  = scan.nextDouble();
		System.out.print("Please input side C of Triangle : ");
		double C = scan.nextDouble();
		Triangle t = new Triangle(A, B, C);
		Rectangle rect = new Rectangle(w, l);
		Circle c = new Circle(r);
		rect.printResult();
		c.printResult();
		t.printResult();
	}
}
abstract class Shape{
	public abstract double getPerimeter();
	public abstract double getArea();
	public abstract void printResult();
}
class Triangle extends Shape {
	private double A;
	private double B;
	private double C;
	public Triangle(double A,double B,double C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}

	@Override
	public double getPerimeter() {
		
		return this.A + this.B + this.C;
	}

	@Override
	public double getArea() {
		double p = this.getPerimeter()/2;
		return Math.sqrt(p*(p-this.A)*(p - this.B)*(p - this.C));
	}

	@Override
	public void printResult() {
		System.out.println("------- Triangle -------");
		System.out.println("Side A : " + this.A);
		System.out.println("Side B : " + this.B);
		System.out.println("Side C : " + this.C);
		System.out.println("Area : " + this.getArea());
		System.out.println("Perimeter : " + this.getPerimeter());
	}
}
class Rectangle extends Shape{
	private double w;
	private double l;
	public Rectangle(double w,double l) {
		this.w = w;
		this.l= l ;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (this.w + this.l)*2;
	}
	@Override
	public double getArea() {

		return this.w*this.l;
	}
	@Override
	public void printResult() {
		System.out.println("------- Rectangle -------");
		System.out.println("Width : " + this.w);
		System.out.println("Length : " + this.l);
		System.out.println("Area : " + this.getArea());
		System.out.println("Perimeter : " + this.getPerimeter());
	}
}
class Circle extends Shape{
	private double r;
	public Circle(double r) {
		this.r = r;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*Math.PI*this.r;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*Math.pow(this.r, 2);
	}

	@Override
	public void printResult() {
		System.out.println("------- Circle -------");
		System.out.println("Radius : " + this.r);
		System.out.println("Area : "  + this.getArea());
		System.out.println("Perimeter : " + this.getPerimeter());
		
	}
	
}
