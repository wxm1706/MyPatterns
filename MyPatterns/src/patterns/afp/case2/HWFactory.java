package patterns.afp.case2;

public class HWFactory implements IFactory {

	@Override
	public SmartBox createSmartBox() {
		// TODO Auto-generated method stub
		return new HWSmartBox();
	}

	@Override
	public AirConditioner createAirConditioner() {
		// TODO Auto-generated method stub
		return new HWAirConditioner();
	}

}
