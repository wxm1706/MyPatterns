package principle.ocp;

public abstract class Geometry implements Comparable<Geometry>{
	public abstract double getArea();
	@Override
	public int compareTo(Geometry o) {
		return (int) (this.getArea() - o.getArea());
	}
}
