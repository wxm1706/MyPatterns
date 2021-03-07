package patterns.fmp.case1;

public class AppleFactory implements IFactory {

	@Override
	public Computer createComputer() {
		Computer c = new AppleComputer();
		c.setCpu(new CPU("Apple CPU", "1.0"));
		c.setM(new Memery("Apple Memery", "1.0"));
		return c;
	}

}
