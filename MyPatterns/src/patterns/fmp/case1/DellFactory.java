package patterns.fmp.case1;

public class DellFactory implements IFactory {

	@Override
	public Computer createComputer() {
		Computer c = new AppleComputer();
		c.setCpu(new CPU("DELL CPU", "1.0"));
		c.setM(new Memery("DELL Memery", "1.0"));
		return c;
	}

}
