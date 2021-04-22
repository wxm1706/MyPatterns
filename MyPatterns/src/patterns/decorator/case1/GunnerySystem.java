package patterns.decorator.case1;

public class GunnerySystem extends EquipmentSystem {
	public GunnerySystem(Robot robot) {
		super(robot);
	}
	public void execute(String command) {
		if(command.equals("shoot")) {
			shot();
		}else {
			super.execute(command);
		}
	}
	public void shot() {
		System.out.println("[Íê³ÉÉä»÷]");
	}
}
