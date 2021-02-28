package patterns.builder.case1;

public class Director {
	
	private Builder builder;

	public static void main(String[] args) {
		String title = "学生信息";
		Student[] items = {new Student("小明", "001"), new Student("小红", "002")};
		Director d = new Director();
		d.setBuilder(new TextBuilder());
		System.out.println(d.construct(title, items).toString());
		d.setBuilder(new HTMLBuilder());
		System.out.println(d.construct(title, items).toString());
	}
	
	
	public Object construct(String title, Student[] items) {
		builder.setTitle(title);
		builder.addItems(items);
		return builder.getResult();
	}


	public Builder getBuilder() {
		return builder;
	}


	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
}
