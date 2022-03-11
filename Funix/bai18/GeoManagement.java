package bai18;

public class GeoManagement {
	public static void main(String[] args) {
		
	}
}

class Country{
	protected String countryCode;
	protected String countryName;
	protected float totalArea;
	public Country() {
		
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public float getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(float totalArea) {
		this.totalArea = totalArea;
	}
	public void Display() {
		System.out.println(this.countryCode + " " + this.countryName + " " + this.totalArea);
	}
}
class EastAsiaCountries extends Country{
	private String countryTerrain;
	public EastAsiaCountries(String countryCode,String countryName,float totalArea,String countryTerrain) {
		super();
		this.countryTerrain = countryTerrain;
	}
	public String getCountryTerrain() {
		return countryTerrain;
	}
	public void setCountryTerrain(String countryTerrain) {
		this.countryTerrain = countryTerrain;
	}
	@Override
	public void Display() {
		System.out.println(this.countryCode + " " + this.countryName + " " + this.totalArea + " " + this.countryTerrain);
	}
}