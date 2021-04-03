package patterns.adapter.case1;

public interface IProcess {
	public TableData sortByField(DataSource ds, String field, boolean isNumber);
}
