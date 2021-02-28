package principle.dip;

public class Pencil implements IPen{

	@Override
	public void write(String text) {
		System.out.printf("The text [%s] is writed by a pencil", text);
	}

}
