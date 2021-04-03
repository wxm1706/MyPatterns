package patterns.builder.case2;

public class Test {

	public static void main(String[] args) {
		String data = "标题1:子标题1,子标题2;标题2:子标题1,子标题2";
		Director director = new Director();
		IBuilder builder = new HTMLListBuilder();
		director.setBuilder(builder);
		director.construct(data);
		System.out.println(builder.getResult());
		
		builder = new TextListBuilder();
		director.setBuilder(builder);
		director.construct(data);
		System.out.println(builder.getResult());
	}

}
