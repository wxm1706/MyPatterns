package patterns.adapter.case1;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
	public List<String> load(){
		// Ä£ÄâÊı¾İ
		List<String> list = new ArrayList<String>();
		list.add("id,score");
		list.add("001,100");
		list.add("002,80");
		list.add("003,99");
		list.add("004,67");
		return list;
	}
}
