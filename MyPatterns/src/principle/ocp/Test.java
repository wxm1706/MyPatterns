package principle.ocp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Geometry> list = new ArrayList<Geometry>();
		list.add(new Rectangle(2.0, 3.0));
		list.add(new Circle(1.0));
		Collections.sort(list);
		for(Geometry g:list) {
			System.out.println(g.toString());
		}
	}
}
