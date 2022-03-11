package bai30;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class FormatProgram {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		FormatProgram f = new FormatProgram();
		System.out.println("======= Validate Program =======");
		String r;
		String p;
		do {
			System.out.print("Phone number : ");
			p = scan.nextLine();
			r = f.checkPhone(p);
			if(!r.equals(p)) {
				System.out.println(r);
			}
		}while(!r.equals(p));
//		String r;
		String e;
		do {
			System.out.print("Email : ");
			e = scan.nextLine();
			r = f.checkMail(e);
			if(!r.equals(e)) {
				System.out.println(r);
			}
		}while(!r.equals(e));
//		String r;
		String d;
		do {
			System.out.print("Date : ");
			d = scan.nextLine();
			r = f.checkDate(d);
			if(!r.equals(d)) {
				System.out.println(r);
			}
		}while(!r.equals(d));
	}
	public String checkPhone(String phone) {
		try {
			 int p = Integer.parseInt(phone);
			 if(phone.length() < 10 || phone.length() > 10) {
				 return "Phone number must be 10 digit"; 
			 }else {
				 return phone;
			 }
		 }catch(Exception e) {
			 return "Phone number must is integer";
		 }
		
	}
	public String checkDate(String date) {
		Date d = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			d = (Date) sdf.parse(date);
			if(!date.equals(sdf.format(d))) {
				return "Date to correct format(dd/MM/yyyy)";
			}else {
				return date;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			System.out.println(e);
//			return "1";
			
			return "Date to correct format(dd/MM/yyyy)";
		}
//		return null;
	}
	public String checkMail(String email) {
		Pattern EMAIL_REGEX = Pattern.compile("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)", Pattern.CASE_INSENSITIVE);
	    boolean check =  EMAIL_REGEX.matcher(email).matches();
		if(check == false) {
			return "Email must is correct format";
		}else {
			return email;
		}
	}
}
