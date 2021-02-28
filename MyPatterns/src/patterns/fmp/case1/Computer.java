package patterns.fmp.case1;

public abstract class Computer {
	private String cpu;
	private String hardDesk;
	private String memery;
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getHardDesk() {
		return hardDesk;
	}
	public void setHardDesk(String hardDesk) {
		this.hardDesk = hardDesk;
	}
	public String getMemery() {
		return memery;
	}
	public void setMemery(String memery) {
		this.memery = memery;
	}
}
