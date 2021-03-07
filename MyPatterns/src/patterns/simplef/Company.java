package patterns.simplef;

import java.util.ArrayList;
import java.util.List;

public class Company {
	public List<Computer> buy(List<String> orderList) throws Exception {
		List<Computer> compList = new ArrayList<Computer>();	
		for(String type:orderList) {
			Computer comp = new Computer();
			if(type.equals("H")) {
				comp.setCpu(new CPU("Intel", "i5"));
				comp.setM(new Memery("Kingston", "8G"));
			}else if(type.equals("L")){
				comp.setCpu(new CPU("Intel", "i7"));
				comp.setM(new Memery("Kingston", "16G"));
			}else {
				throw new Exception("Undefined Computer Type");
			}
			compList.add(comp);
		}
		return compList;
	}
}
