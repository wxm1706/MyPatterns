package patterns.prototype.case2;

public class Item implements Cloneable{
	private String title;
	private String txt;
	
	public Item(String title, String txt) {
		this.title = title;
		this.txt = txt;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
}
