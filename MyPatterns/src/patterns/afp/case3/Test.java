package patterns.afp.case3;

public class Test {

	public static void main(String[] args) {
		IFactory f1 = Factory1.getInstance();
		IFactory f2 = Factory2.getInstance();
		System.out.println(f1.createA());
		System.out.println(f1.createB());
		System.out.println(f2.createA());
		System.out.println(f2.createB());
	}

}
