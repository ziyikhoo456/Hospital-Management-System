package src4;

public class Patient {
	private String id;
	private String name;
	private String disease;
	private String sex;
	private String admitStatus;
	private int age;
	private static int num = 0;

	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		Patient.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAdmitStatus() {
		return admitStatus;
	}
	public void setAdmitStatus(String admitStatus) {
		this.admitStatus = admitStatus;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void newPatient(String id, String name, String disease, String sex, String admitStatus, int age) {
		setId(id);
		setName(name);
		setDisease(disease);
		setSex(sex);
		setAdmitStatus(admitStatus);
		setAge(age);
		num++;
	}
		
	public String showPatientInfo() {
		String str = this.id+"/"+this.name+"/"+this.disease+"/"+this.sex+"/"+this.admitStatus+"/"+this.age;
		return str;
	}
}
