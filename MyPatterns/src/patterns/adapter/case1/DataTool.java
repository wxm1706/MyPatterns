package patterns.adapter.case1;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DataTool{
	
	public TableData load(File csv, String sep) {
		TableData td = null;
		try(Scanner input = new Scanner(new FileInputStream(csv))){
			if(!input.hasNext())
				throw new RuntimeException("ÎÄ¼þÎª¿Õ");
			String[] fields = input.nextLine().split(sep);
			List<String> fieldList = new ArrayList<String>();
			for(String f:fields) {
				fieldList.add(f);
			}
			List<Record> recordList = new ArrayList<Record>();
			while(input.hasNext()) {
				String[] items = input.nextLine().split(sep);
				recordList.add(new Record(Arrays.asList(items)));
			}
			td = new TableData(fieldList, recordList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return td;
	}
	
	
	public void sortBy(TableData td, String field, boolean isNumber) {
		List<String> fieldList = td.getFields();
		int i;
		for(i = 0; i < fieldList.size(); i++) {
			if(fieldList.get(i).equals(field)) {
				break;
			}
		}
		int index = i;
		List<Record> recordList = td.getItems();
		recordList.sort(new Comparator<Record>(){

			@Override
			public int compare(Record o1, Record o2) {
				String s1 = o1.getItems().get(index);
				String s2 = o2.getItems().get(index);
				if(isNumber)
					return (int) (Double.parseDouble(s1) - Double.parseDouble(s2));
				else
					return s1.compareTo(s2);
			}
			
		});
		
	}
	
	public boolean isNumeric(String str){
		for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i))){
				return false;
		}
	}
	return true;
}
}
