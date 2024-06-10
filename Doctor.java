package src4;

public class Doctor {
	private String id;
	private String name;
	private String specialist;
	private String workTime;
	private String qualification;
	private int room;
	private static int num = 0;

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Doctor.num = num;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
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
	
	public String getSpecialist() {
		return specialist;
	}
	
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	
	public String getWorkTime() {
		return workTime;
	}
	
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
	public String getQualification() {
		return qualification;
	}
	
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public void newDoctor(String id, String name, String specialist, String workTime, String qualification, int room) {
		this.id = id;
		this.name = name;
		this.specialist = specialist;
		this.workTime = workTime;
		this.qualification = qualification;
		this.room = room;
		num++;
	}
	
	public String showDoctorInfo() {
		String str = this.id+"/"+this.name+"/"+this.specialist+"/"+this.workTime+"/"+this.qualification+"/"+this.room;
		return str;
	}
	
	

}
