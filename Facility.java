package src4;

public class Facility {
	private String facility;
	private static int num = 0;

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Facility.num = num;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}
	
	public void newFacility(String facility) {
		setFacility(facility);
		num++;
	}
	
	public String showFacility() {
		String str = this.facility;
		return str;
	}
}
