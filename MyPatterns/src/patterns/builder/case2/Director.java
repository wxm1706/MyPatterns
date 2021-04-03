package patterns.builder.case2;

public class Director {
	private IBuilder builder;
	
	public void construct(String data) {
		String[] ulList = data.split(";");
		for(String ul : ulList) {
			String[] items = ul.split(":");
			String title = items[0];
			builder.appendListTitle(title);
			String[] liList = items[1].split(",");
			for(String liTitle : liList) {
				builder.appendListItem(liTitle);
			}
			builder.appendListTail();
		}
	}



	public IBuilder getBuilder() {
		return builder;
	}



	public void setBuilder(IBuilder builder) {
		this.builder = builder;
	}
}
