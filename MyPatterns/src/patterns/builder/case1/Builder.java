package patterns.builder.case1;

public abstract class Builder {
	private StringBuilder str = new StringBuilder();
	public abstract void setTitle(String title);
	public abstract void addItems(Student[] items);
	public abstract Object getResult();
	
	public StringBuilder getStr() {
		return str;
	}
	public void setStr(StringBuilder str) {
		this.str = str;
	}
}
