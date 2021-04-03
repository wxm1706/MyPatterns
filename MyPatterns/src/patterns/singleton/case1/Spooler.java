package patterns.singleton.case1;

import java.util.LinkedList;
import java.util.Queue;

public class Spooler {
	private Queue<Request> requestList;
	
	private static Spooler instance;
	
	public static Spooler getInstance() {
		if(instance == null) {
			synchronized(Spooler.class) {
				if(instance == null) {
					instance = new Spooler();
				}
			}
		}
		return instance;
	}
	
	// 访问性修改为private
	private Spooler() {
		requestList = new LinkedList<Request>();
	}
	
	public void print() {
		Request r = requestList.poll();
		if(r != null) {
			System.out.println("ID:" + r.getId());
			System.out.println("Content:" + r.getContent());
		}	
	}
	
	public void cancel(String id) {
		Request remove = null;
		for(Request r:requestList) {
			if(id.equals(r.getId())) {
				remove = r;
			}
		}
		if(remove != null)
			requestList.remove(remove);
	}
	
	public void add(Request r) {
		requestList.offer(r);
	}
}
