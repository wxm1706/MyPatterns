package patterns.fmp.case1;

public class AppleFactory implements IFactory {

	@Override
	public Computer create() {
		Computer c = new AppleComputer();
		c.setCpu("Apple CPU");
		c.setHardDesk("Apple HardDesk");
		c.setMemery("Apple Memery");
		return c;
	}

}
