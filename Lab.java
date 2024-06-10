package src4;

public class Lab {
	private String lab;
	private int cost;
	private static int num=0;
	
	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Lab.num = num;
	}

	public String getLab() {
		return lab;
	}
	
	public void setLab(String lab) {
		this.lab = lab;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void newLab(String lab, int cost) {
		setLab(lab);
		setCost(cost);
		num++;
	}
	
	public String labList() {
		String str = this.lab+"/"+this.cost;
		return str;
	}
	
}

