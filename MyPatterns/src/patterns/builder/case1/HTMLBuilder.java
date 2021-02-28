package patterns.builder.case1;

public class HTMLBuilder extends Builder {

	@Override
	public void setTitle(String title) {
		getStr().append("<html><head><title>" + title + "</title></head><body>\n");
	}

	@Override
	public void addItems(Student[] items) {
		for(Student s:items) {
			getStr().append("<ul>");
			getStr().append("<li>ĞÕÃû:" + s.getName() + "</li>\n");
			getStr().append("<li>±àºÅ:" + s.getId() + "</li>\n");
			getStr().append("</ul>\n");
		}
	}

	@Override
	public Object getResult() {
		getStr().append("</body></html>");
		return this.getStr();
	}

}
