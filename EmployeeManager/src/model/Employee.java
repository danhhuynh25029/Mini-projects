package model;

public class Employee {
	private String name;
	private int id;
//	private String address;
	private String phoneNumber;
	private int code;
	public Employee(int id,String name,String phoneNumber,int code){
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
