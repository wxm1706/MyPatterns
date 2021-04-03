package patterns.singleton.case1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Singleton{
	private static Singleton instance;

	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized(Singleton.class) {
				if(instance == null)
					instance = new Singleton();
			}
			
		}
		return instance;
	}

	public static void main(String[] args) throws Exception {
		Singleton instanceOne = Singleton.getInstance();
		Singleton instanceTwo = null;
        try {
            Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                //创建新对象，破坏单例结构
                constructor.setAccessible(true);
                instanceTwo = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
