package principle.carp;

public class Gun implements IWeapon {

	@Override
	public void attack() {
		System.out.print("Shooting!");
	}

}
