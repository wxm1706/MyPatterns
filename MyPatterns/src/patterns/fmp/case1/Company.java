package patterns.fmp.case1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
@startuml
together {
	interface IFactory{
		+Computer create()
	}
	class AppleFactory
	class DellFactory
}
IFactory <|.. AppleFactory
IFactory <|.. DellFactory
AppleFactory ..> AppleComputer
DellFactory ..> DellComputer
together {
	abstract class Computer{
		-String cpu
		-String hardDesk
		-String memery
	}
	class DellComputer
	class AppleComputer
}
Computer <|-- DellComputer
Computer <|-- AppleComputer
Class Company{
	+List<Computer> assemble(Map<String, IFactory> orderList);
}
Company ..> Computer
Company ..> IFactory
@enduml
**/

public class Company {

	public static void main(String[] args) {
		Company company = new Company();
		Map<String, IFactory> orderList = new HashMap<String, IFactory>();
		IFactory dell = new DellFactory();
		IFactory apple = new AppleFactory();
		orderList.put("APPLE", apple);
		orderList.put("DELL", dell);
		company.assemble(orderList);
	}
	
	public List<Computer> assemble(Map<String, IFactory> orderList) {
		List<Computer> computers = new ArrayList<Computer>();
		for(String type:orderList.keySet()) {
			computers.add(orderList.get(type).create());
		}
		System.out.println("组装完成");
		return computers;
	}

}
