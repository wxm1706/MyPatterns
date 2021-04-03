package game;

public class MathTool {
	public static boolean isOverlap(Rectangle r1, Rectangle r2) {
		if(r1.getX() + r1.getWidth() > r2.getX() 
				&& r2.getX() + r2.getWidth() > r1.getX() 
				&& r1.getY() + r1.getHeight() > r2.getY() 
				&& r2.getY() + r2.getHeight() > r1.getY()) {
			return true;
		}
		return false;
	}
}
