package patterns.builder.case2;

public class TextListBuilder implements IBuilder{
	private StringBuilder value;
	
	public TextListBuilder() {
		value = new StringBuilder();
	}

	@Override
	public void appendListTitle(String title) {
		value.append(title + "\n");
	}

	@Override
	public void appendListItem(String item) {
		value.append("-" + item + "\n");
	}

	@Override
	public void appendListTail() {
		
	}

	@Override
	public StringBuilder getResult() {
		return value;
	}
}
