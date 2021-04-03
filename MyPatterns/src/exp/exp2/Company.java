package exp.exp2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Company{

	public static void main(String[] args){
		Map<String, IFactory> factoryMap = new HashMap<String, IFactory>();
		factoryMap.put("A", new FactoryA());
		factoryMap.put("B", new FactoryB());
		
		List<Car> list = new ArrayList<Car>();
		
		try(Scanner input = new Scanner(new FileInputStream(new File("order.txt")))){
			while(input.hasNext()) {
				String typeToCreate = input.next();
				IFactory selectedFactory = factoryMap.get(typeToCreate);
				list.add(selectedFactory.createCar());
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		for(Car c:list) {
			System.out.println(c);
		}
	}
}

interface IFactory{
	Car createCar();
}
class FactoryA implements IFactory{

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return null;
	}}
class FactoryB implements IFactory{

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return null;
	}}
abstract class Car{}
class CarA extends Car{}
class CarB extends Car{}
