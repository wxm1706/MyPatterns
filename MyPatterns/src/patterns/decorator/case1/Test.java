package patterns.decorator.case1;

public class Test {

	public static void main(String[] args) {
		Robot r = new BaseRobot();
		EquipmentSystem es = null;
		
		// ����1����ɷ�������Լ���������Ŀ��
		String[] task1 = {"fly", "move", "shoot"};
		es = new GunnerySystem(new FlightSystem(r));
		doTask(es, task1);
		
		
		// ����2����ɷ��к�����
		String[] task2 = {"move", "fly", "carry"};
		es = new CarrierSystem(new FlightSystem(r));
		doTask(es, task2);
		
		
		// ����3����ɷ��С�������������
		String[] task3 = {"move", "fly", "carry", "shoot"};
		es = new GunnerySystem(new CarrierSystem(new FlightSystem(r)));
		doTask(es, task3);
		
		// �����ܵ�������ɷ���������
		String[] task4 = {"fly", "dance"};
		es = new GunnerySystem(new CarrierSystem(new FlightSystem(r)));
		doTask(es, task4);
	}
	
	public static void doTask(EquipmentSystem es, String[] commands) {
		System.out.println("-------------��ʼִ������--------------");
		for(String command:commands) {
			es.execute(command);
		}
	}

}
