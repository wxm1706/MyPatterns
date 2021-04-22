package patterns.proxy.case1;

public class SubjectB implements ISubjectB{

	@Override
	public void requestB() {
		System.out.println("RequestB");
	}

}
