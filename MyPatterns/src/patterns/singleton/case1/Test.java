package patterns.singleton.case1;

import java.util.UUID;

public class Test {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.out.println(r.maxMemory());
		System.out.println(r.totalMemory());

		Thread taskThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					Request r = new Request(UUID.randomUUID().toString(), ""+Math.random());
					Spooler.getInstance().add(r);
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}}, "CreateTask");
		
		taskThread.start();
		
		Thread printThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					Spooler.getInstance().print();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}, "Print");
		printThread.start();
	}
}
