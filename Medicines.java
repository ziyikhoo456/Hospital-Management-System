package src4;

public class Medicines {
	
	private String name,manufacturer,expiryDate;
	private int cost, count;
	private static int num = 0;
	
	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Medicines.num = num;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer=manufacturer;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setExpiryDate(String expiryDate) {
		this.expiryDate=expiryDate;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public void setCost(int cost) {
		this.cost=cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCount(int count) {
		this.count=count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void newMedical(String name, String manu, String expD, int cost, int count ) {
		
		setName(name);
		setManufacturer(manu);
		setExpiryDate(expD);
		setCost(cost);
		setCount(count);
		num++;
	}
	
	public String findMedical() {
		String str = this.name+"/"+this.manufacturer+"/"+this.expiryDate+"/"+this.cost+"/"+this.count;
		return str;
	}
	
}




