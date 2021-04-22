package patterns.bridge;

public class AdvancedCircle extends Circle {
	private String color;
	private String strokeType;
	
	@Override
	public void draw() {
		System.out.println("�������ɫ" + color);
		System.out.println("���ñ���ʽ" + strokeType);
		super.draw();
	}
}
