package patterns.afp.case2;

public class HWSmartBox extends SmartBox {

	@Override
	public void connect(AirConditioner ac) {
		if(ac instanceof HWAirConditioner) {
			System.out.println("Connected");
		}else {
			throw new RuntimeException("Wrong Device");
		}
	}

}
