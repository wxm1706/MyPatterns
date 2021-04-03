package patterns.builder.case2;

public interface IBuilder {
	
	public void appendListTitle(String title);
	public void appendListItem(String item);
	public void appendListTail();
	
	public StringBuilder getResult();
}
