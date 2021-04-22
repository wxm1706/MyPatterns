package patterns.decorator.case1;

public class Test {

	public static void main(String[] args) {
		Robot r = new BaseRobot();
		EquipmentSystem es = null;
		
		// 任务1：完成飞行侦察以及攻击特殊目标
		String[] task1 = {"fly", "move", "shoot"};
		es = new GunnerySystem(new FlightSystem(r));
		doTask(es, task1);
		
		
		// 任务2：完成飞行和运输
		String[] task2 = {"move", "fly", "carry"};
		es = new CarrierSystem(new FlightSystem(r));
		doTask(es, task2);
		
		
		// 任务3：完成飞行、运输和射击任务
		String[] task3 = {"move", "fly", "carry", "shoot"};
		es = new GunnerySystem(new CarrierSystem(new FlightSystem(r)));
		doTask(es, task3);
		
		// 不可能的任务：完成飞行与跳舞
		String[] task4 = {"fly", "dance"};
		es = new GunnerySystem(new CarrierSystem(new FlightSystem(r)));
		doTask(es, task4);
	}
	
	public static void doTask(EquipmentSystem es, String[] commands) {
		System.out.println("-------------开始执行任务--------------");
		for(String command:commands) {
			es.execute(command);
		}
	}

}
