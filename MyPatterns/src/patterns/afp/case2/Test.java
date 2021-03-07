package patterns.afp.case2;

public class Test {
	public static void main(String[] args) {
		IFactory xmf = new XMFactory();
		SmartBox sbox = xmf.createSmartBox();
		AirConditioner ac = xmf.createAirConditioner();
		sbox.connect(ac);
	}
}
