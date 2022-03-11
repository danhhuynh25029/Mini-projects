package bai16;

import java.util.*;

public class Caculate {
	static Scanner scan = new Scanner(System.in);
	public static void main(String args[]) {
		Caculate c = new Caculate();
		int n = 0;
		do {
			System.out.println("======= Equation Program =======");
			System.out.println("1.Caculate Superlative Equation.");
			System.out.println("2.Caculate Quadratic Equation.");
			System.out.println("3.Exit.");
			System.out.println("Please choice one option: ");
			n = scan.nextInt();
			scan.nextLine();
			switch(n) {
			case 1:
				System.out.println("Please input number : ");
				String as;
				do {
					System.out.print("Enter A : ");
					as = scan.nextLine();
				}while(c.check(as) == null);
				float a = c.check(as);
				do {
					System.out.print("Enter B : ");
					as = scan.nextLine();
				}while(c.check(as) == null);
				float b = c.check(as);
				List<Float> r = c.calculateEquation(a, b);
				if(r == null) {
					System.out.println("Soulution : null");
				}else if(r.isEmpty()) {
					System.out.println("Soulution : empty");
				}else {
					System.out.println("Soulution : x = " + r.get(0) + ".");
				}
//				
				System.out.print("Number is Odd: ");
				if((int)a % 2 != 0) {
					System.out.print(a);
				}
				if((int)b % 2 != 0) {
					System.out.print(" " + b);
				}
				System.out.println();
				System.out.print("Number is Even: ");
				if((int)a % 2 == 0) {
					System.out.print(a);
				}
				if((int)b % 2 == 0) {
					System.out.print(" " + b);
				}
				System.out.println();
				
				System.out.print("Number is Perfect Square: ");
				if(Math.sqrt((int)a) == (int)Math.sqrt((int)a)) {
					System.out.print(a);
				}
				if(Math.sqrt((int)b) == (int)Math.sqrt((int)b)){
					System.out.println(" "+b);
				}
				
				break;
			case 2:
				System.out.println("Please input number : ");
				do {
					System.out.print("Enter A : ");
					as = scan.nextLine();
				}while(c.check(as) == null);
				float a1 = c.check(as);
				do {
					System.out.print("Enter B : ");
					as = scan.nextLine();
				}while(c.check(as) == null);
				float  b1 = c.check(as);
				do {
					System.out.print("Enter C : ");
					as = scan.nextLine();
				}while(c.check(as) == null);
				float c1 = c.check(as);
				List<Float> r1 = c.calculateQuadraticEquation(a1,b1,c1);
				if(r1 == null) {
					System.out.println("Soulution : null");
				}else if(r1.isEmpty()) {
					System.out.println("Soulution : empty");
				}else {
					System.out.print("Soulution : ");
					for(int i = 0 ; i < r1.size() ; i++) {
						if(i == r1.size() - 1)
							System.out.print("x"+(i+1)+" = " + r1.get(i) + ".");
						else
							System.out.print("x"+(i+1)+" = " + r1.get(i));
						if(r1.size() >= 1 && i != r1.size() - 1) System.out.print(" and ");
					}
				}
				System.out.println();
				System.out.print("Number is Odd: ");
				if((int)a1 % 2 != 0) {
					System.out.print(a1);
				}
				if((int)b1 % 2 != 0) {
					System.out.print(" " + b1);
				}
				if((int)c1 % 2 != 0) {
					System.out.print(" " + c1);
				}
				System.out.println();
				
				System.out.print("Number is Even: ");
				if((int)a1 % 2 == 0) {
					System.out.print(a1 );
				}
				if((int)b1 % 2 == 0) {
					System.out.print(" " + b1 );
				}
				if((int)c1 % 2 == 0) {
					System.out.print(" " + c1);
				}
				System.out.println();
				
				System.out.print("Number is Perfect Square: ");
				if(Math.sqrt((int)a1) == (int)Math.sqrt((int)a1)) {
					System.out.print(a1);
				}
				if(Math.sqrt((int)b1) == (int)Math.sqrt((int)b1)){
					System.out.print(" " + b1);
				}
				if(Math.sqrt((int)c1) == (int)Math.sqrt((int)c1)){
					System.out.print(" " + c1);
				}
				System.out.println();
				break;
				
			}
		}while(n != 3);
	}
	public List<Float> calculateEquation(float a,float b){
		List<Float> tmp = new ArrayList<>();
		if (a == 0) {
            if (b == 0) {
                return null;
            } else {
                return tmp;
            }
        } else {
            float r = (float) -b / a;
            tmp.add(r);
        }
		return tmp;
	}
	public List<Float>	calculateQuadraticEquation(float a,float b,float c){
		List<Float> tmp = new ArrayList<>();
		if (a == 0) {
            if (b == 0) {
                return null;
            } else {
                tmp.add(-c / b);
                return tmp;
            }
        }
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            tmp.add(x1);
            tmp.add(x2);
            return tmp;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            tmp.add(x1);
            tmp.add(x1);
            return tmp;
        } else {
            return null;
        }
//		return null;
	}
	public Float check(String a) {
		try {
			return Float.parseFloat(a);
		} catch (Exception e) {
			return null;
		}
		
	}
}
