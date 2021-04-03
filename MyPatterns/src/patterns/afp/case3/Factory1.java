package patterns.afp.case3;

public class Factory1 implements IFactory{
	private static final IFactory instance = new Factory1();
	
	public static IFactory getInstance() {
		return instance;
	}

	@Override
	public ProductA createA() {
		return new ProductA1();
	}

	@Override
	public ProductB createB() {
		return new ProductB1();
	}

}
