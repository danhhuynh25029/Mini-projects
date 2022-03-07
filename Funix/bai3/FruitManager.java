package bai3;

//import java.lang.reflect.Array;
import java.util.*;

public class FruitManager {
	static ArrayList<Fruit> listFruit = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static Hashtable<String, ArrayList<Fruit>> user = new Hashtable<String, ArrayList<Fruit>>();
	public static void main(String[] args) {
		System.out.println(""
				+ "1.Tao trai cay.\n"
				+ "2.Xem don dat hang.\n"
				+ "3.Mua sam.\n"
				+ "4.Thoat\n");
		int n = 0;
		do {
			System.out.print("Vui long nhap lua chon cua ban : ");
			n = scan.nextInt();
			switch(n) {
			case 1:
				createFruit();
				break;
			case 2:
				billDetail();
				break;
			case 3:
				purchaseFruit();
				break;
			}
		}while(n != 4);
		
	}
	public static void createFruit() {
		String c = "";
		do {
			System.out.print("Nhap ID : ");
			int id = scan.nextInt();
			scan.nextLine();
			
			System.out.print("Nhap ten : " );
			String name = scan.nextLine();
			System.out.print("Nhap gia : ");
			int price = scan.nextInt();
			System.out.print("Nhap so luong cua qua : ");
			int quantity = scan.nextInt();
			System.out.print("Nhap dia chi : ");
			scan.nextLine();
			String roots = scan.nextLine();
			
			listFruit.add(new Fruit(id, name, price, quantity, roots));
			System.out.println("-----");
			System.out.print("Ban muon tiep tuc khong Y/N : ");
			c = scan.nextLine();
			if(!c.equals("Y")) break;
		}while(!c.equals("N"));
		System.out.println("ID | San pham | So luong | Gia");
		for(Fruit f : listFruit) {
			System.out.println(f.getId() + "    " + f.getName() + "         " + f.getQuantity() + "          " + f.getPrice() + "$");
		}
	}
	public static void billDetail() {
		for(String key : user.keySet()) {
			System.out.println("-----");
			System.out.println("Khach hang : " + key);
			System.out.println("San pham | So luong | Gia | So tien");
			for(int i = 0 ; i < user.get(key).size() ; i++) {
				System.out.println(user.get(key).get(i).getId() + "." + user.get(key).get(i).getName() + "         " + user.get(key).get(i).getQuantity() + "          " + user.get(key).get(i).getPrice() + "$" + 
						"          " + (user.get(key).get(i).getQuantity() * user.get(key).get(i).getPrice()) + "$");
			}
		}
	}
	
	public static void purchaseFruit() {
		ArrayList<Fruit> tmp = new ArrayList<>();
		System.out.println("| ++ Mục++ | ++ Tên trái cây ++ | ++ Xuất xứ++ | ++ Giá++ |");
		for(int i = 0 ; i < listFruit.size() ; i++) {
			System.out.println("      "+ i+1 + "          " + listFruit.get(i).getName() + "               " + listFruit.get(i).getRoots() + "        " + listFruit.get(i).getPrice());
		}
		String c = "";
		do {
			System.out.print("Vui long chon mat hang : ");
			int index = scan.nextInt();
			index = index - 1;
			System.out.println("Ban da chon : " + listFruit.get(index).getName());
			System.out.print("Vui long nhap so luong : ");
			int quantity = scan.nextInt();
			if(listFruit.get(index).getQuantity() - quantity < 0) {
				System.out.println("Vui long nhap lai");
			}else {
				listFruit.get(index).setQuantity(listFruit.get(index).getQuantity() - quantity);
				System.out.println("Ban co muon dat hang ngay bay gio Y/N :");
				scan.nextLine();
				c = scan.nextLine();
				tmp.add(new Fruit(listFruit.get(index).getId(),listFruit.get(index).getName(),listFruit.get(index).getPrice(),quantity,listFruit.get(index).getRoots()));
			}
		}while(!c.equals("Y"));
		System.out.println("-----");
		System.out.println("San pham | So luong | Gia |  So tien");
		for(Fruit f : tmp) {
			System.out.println(f.getName() + "      " + f.getQuantity() + "       " + f.getPrice() + "     " + (f.getPrice()*f.getQuantity()) + "$");
		}
		System.out.print("Vui long nhap ten khach hang : ");
		String name = scan.nextLine();
		user.put(name, tmp);
		System.out.println("Khach hang dat hang thanh cong");
	}
}
class Fruit{
	private int id;
	private String name;
	private int price;
	private int quantity;
	private String roots;
	public Fruit(int id,String name,int price,int quantity,String roots) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.roots = roots;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setRoots(String roots) {
		this.roots = roots;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getRoots() {
		return roots;
	}
	
}