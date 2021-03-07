package patterns.fmp.case1;

public class CPU {
	public CPU(String name, String version) {
		super();
		this.name = name;
		this.version = version;
	}
	private String name;
	private String version;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
