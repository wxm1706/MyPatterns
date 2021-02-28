package principle.ocp;

public class Test {

	public static void main(String[] args) {
		String[] geoList= {"ocp.Circle", "ocp.Rectangle"};
		for(String g:geoList) {
			try {
				IGeometry geo = (IGeometry) Class.forName(g).newInstance();
				System.out.printf("The area and perimeter of the %s geometry is %4.2f and %4.2f\n", geo.getClass().getSimpleName(), geo.getArea(), geo.getPerimeter());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
