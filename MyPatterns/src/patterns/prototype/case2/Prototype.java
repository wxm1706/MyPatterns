package patterns.prototype.case2;

public class Prototype implements Cloneable{
	int a;
	int[] arr = {1,2};
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype src = new Prototype();
		
		Prototype copy = (Prototype) src.clone();
		
		copy.getArr()[1] = 1000;
		
		System.out.println(src.getArr()[1]);
		System.out.println(copy.getArr()[1]);
	}
	
	public Object clone() throws CloneNotSupportedException {
		Prototype copy = (Prototype) super.clone();
		copy.setArr(this.getArr().clone());
		
		return copy;
	}
	
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
}
