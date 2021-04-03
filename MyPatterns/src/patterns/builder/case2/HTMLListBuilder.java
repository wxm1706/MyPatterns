package patterns.builder.case2;

public class HTMLListBuilder implements IBuilder{
	private StringBuilder value;

	public HTMLListBuilder() {
		value = new StringBuilder();
	}
	
	@Override
	public void appendListTitle(String title) {
		value.append("<li>" + title + "\n<ul>");
	}

	@Override
	public void appendListItem(String item) {
		value.append("<li>" + item +"</li>\n");
	}

	@Override
	public void appendListTail() {
		value.append("</ul></li>\n");
	}

	@Override
	public StringBuilder getResult() {
		return value;
	}
	
	
}
