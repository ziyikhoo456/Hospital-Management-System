package src4;

public class Staff {
	private String id;
	private String name;
	private String designation;
	private String sex;
	private int salary;
	
	public static int num = 0;
	
	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		Staff.num = num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void newStaff(String id, String name, String designation, String sex, int salary) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.sex = sex;
		this.salary = salary;
		num++;
	}
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDesignation() {
		return designation;
	}
	public String getSex() {
		return sex;
	}
	public int getSalary() {
		return salary;
	}
	public String showStaffInfo() {
		String str = this.id+"/"+this.name+"/"+this.designation+"/"+this.sex+"/"+this.salary;
		return str;
	}
	
}