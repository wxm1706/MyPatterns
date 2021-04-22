package patterns.decorator.case1;

public class CarrierSystem extends EquipmentSystem {
	public CarrierSystem(Robot robot) {
		super(robot);
		// TODO Auto-generated constructor stub
	}

	public void execute(String command) {
		if(command.equals("carry")) {
			carry();
		}else {
			super.execute(command);
		}
	}
	
	public void carry() {
		System.out.println("[ÕÍ≥…∞·‘À]");
	}
}
