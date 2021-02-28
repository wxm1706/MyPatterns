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
			getStr().append("ĞÕÃû:" + s.getName() + "\n");
			getStr().append("±àºÅ:" + s.getId() + "\n");
		}
	}

	@Override
	public Object getResult() {
		return this.getStr();
	}

}
