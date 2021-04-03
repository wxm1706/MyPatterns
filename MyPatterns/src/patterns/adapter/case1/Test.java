package patterns.adapter.case1;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		DataTool dt = new DataTool();
		TableData td = dt.load(new File("C:\\Users\\wxm1706\\git\\repository\\MyPatterns\\bin\\patterns\\adapter\\case1\\data.csv"), ",");
		dt.sortBy(td, "score", true);
		
		System.out.println(td.toString());
	}

}
