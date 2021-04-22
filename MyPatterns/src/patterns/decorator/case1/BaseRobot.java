package patterns.decorator.case1;

public class BaseRobot implements Robot{

	@Override
	public void execute(String command) {
		if(command.equals("move")) {
			move();
		}else {
			throw new RuntimeException("Not Supported Command: " + command);
		}
	}
	
	public void move() {
		System.out.println("[ÕÍ≥…“∆∂Ø]");
	}
}
