package patterns.builder.case1;


public class TextBuilder extends Builder {

	@Override
	public void setTitle(String title) {
		getStr().append("========================\n");
		getStr().append("[" + title + "]\n");
	}

	@Override
	public void addItems(Student[] items) {
		for(Student s:items) {
			getStr().append("-----------\n");
			getStr().append("����:" + s.getName() + "\n");
			getStr().append("���:" + s.getId() + "\n");
		}
	}

	@Override
	public Object getResult() {
		return this.getStr();
	}

}
