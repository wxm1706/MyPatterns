package patterns.afp.case2;

public class XMFactory implements IFactory {

	@Override
	public SmartBox createSmartBox() {
		return new XMSmartBox();
	}

	@Override
	public AirConditioner createAirConditioner() {
		// TODO Auto-generated method stub
		return new XMAirConditioner();
	}

}
