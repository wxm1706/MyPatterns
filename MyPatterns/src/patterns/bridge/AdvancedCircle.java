package patterns.bridge;

public class AdvancedCircle extends Circle {
	private String color;
	private String strokeType;
	
	@Override
	public void draw() {
		System.out.println("设置填充色" + color);
		System.out.println("设置边样式" + strokeType);
		super.draw();
	}
}
