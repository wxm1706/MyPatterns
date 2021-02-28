package principle.carp;

public class Soldier {
	IWeapon myWeapon;
	
	public Soldier() {
	}
	
	public Soldier(IWeapon w) {
		myWeapon = w;
	}

	public IWeapon getMyWeapon() {
		return myWeapon;
	}

	public void setMyWeapon(IWeapon myWeapon) {
		this.myWeapon = myWeapon;
	}
}
