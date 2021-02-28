package principle.dip;

public class Student {
	
	private String name;
	
	public void doHomework(IPen p, String answer) {
		p.write(answer);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
