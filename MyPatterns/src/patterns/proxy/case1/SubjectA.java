package patterns.proxy.case1;

public class SubjectA implements ISubjectA{

	@Override
	public void requestA() {
		System.out.println("requestA");
	}
	
}
