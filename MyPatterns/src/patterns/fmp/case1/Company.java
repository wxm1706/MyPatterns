package patterns.fmp.case1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {
	public static void main(String[] args) {
		Company company = new Company();
		Map<String, IFactory> orderMap = new HashMap<String, IFactory>();
		IFactory dellF = new DellFactory();
		IFactory appleF = new AppleFactory();
		orderMap.put("001", dellF);
		orderMap.put("002", appleF);
		company.buy(orderMap);
	}
	public List<Computer> buy(Map<String, IFactory> orderMap) {
		List<Computer> compList = new ArrayList<Computer>();
		for(String orderID:orderMap.keySet()) {
			compList.add(orderMap.get(orderID).createComputer());
		}
		return compList;
	}
}
