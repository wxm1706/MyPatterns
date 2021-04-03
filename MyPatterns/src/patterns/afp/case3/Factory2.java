package patterns.afp.case3;

public class Factory2 implements IFactory{
	private static final IFactory instance = new Factory2();
	
	public static IFactory getInstance() {
		return instance;
	}
	
	@Override
	public ProductA createA() {
		return new ProductA2();
	}

	@Override
	public ProductB createB() {
		return new ProductB2();
	}

}
