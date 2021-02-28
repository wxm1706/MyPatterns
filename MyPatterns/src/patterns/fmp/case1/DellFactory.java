package patterns.fmp.case1;

public class DellFactory implements IFactory {

	@Override
	public Computer create() {
		Computer c = new DellComputer();
		c.setCpu("DELL CPU");
		c.setHardDesk("DELL HardDesk");
		c.setMemery("DELL Memery");
		return c;
	}

}
