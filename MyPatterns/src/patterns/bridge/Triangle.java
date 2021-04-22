package patterns.bridge;

public class Triangle extends Geometry{

	@Override
	public void draw() {
		System.out.println("画一个三角形");
	}
	
}
