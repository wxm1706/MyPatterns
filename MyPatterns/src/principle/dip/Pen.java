package principle.dip;

public class Pen implements IPen {

	@Override
	public void write(String text) {
		System.out.printf("The text [%s] is writed by a pen", text);
	}

}
