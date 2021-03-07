package patterns.afp.case2;

public class XMSmartBox extends SmartBox {

	@Override
	public void connect(AirConditioner ac) {
		if(ac instanceof XMAirConditioner) {
			System.out.println("Connected");
		}else {
			throw new RuntimeException("Wrong Device");
		}
	}

}
