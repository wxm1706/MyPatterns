package patterns.decorator.case1;

public abstract class EquipmentSystem implements Robot{
	public EquipmentSystem(Robot robot) {
		super();
		this.robot = robot;
	}

	private Robot robot;

	@Override
	public void execute(String command) {
		robot.execute(command);
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
}
