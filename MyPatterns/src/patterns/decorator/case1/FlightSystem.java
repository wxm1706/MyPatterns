package patterns.decorator.case1;

public class FlightSystem extends EquipmentSystem {
	public FlightSystem(Robot robot) {
		super(robot);
		// TODO Auto-generated constructor stub
	}

	public void execute(String command) {
		if(command.equals("fly")) {
			fly();
		}else {
			super.execute(command);
		}
	}
	
	public void fly() {
		System.out.println("[Íê³É·ÉÐÐ]");
	}
}
