package patterns.adapter.case1;

import java.util.List;

public class TableData {
	private List<String> fields;
	private List<Record> items;
	
	public TableData(List<String> fields, List<Record> items) {
		this.fields = fields;
		this.items = items;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(String field:fields) {
			s.append(field + "\t");
		}
		s.append("\n");
		for(Record re:items) {
			for(String temp:re.getItems()) {
				s.append(temp + "\t");
			}
			s.append("\n");
		}
		return s.toString();
	}



	public List<String> getFields() {
		return fields;
	}



	public void setFields(List<String> fields) {
		this.fields = fields;
	}



	public List<Record> getItems() {
		return items;
	}



	public void setItems(List<Record> items) {
		this.items = items;
	}
}

class Field{
	private String name;
	
	public Field(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

class Record{
	private List<String> items;	
	
	public Record(List<String> r) {
		items = r;
	}
	
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
}