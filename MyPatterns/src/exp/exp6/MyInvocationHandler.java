package exp.exp6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class MyInvocationHandler implements InvocationHandler {
	public MyInvocationHandler(Object obj) {
		super();
		this.obj = obj;
	}

	Object obj;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Manager m = Manager.getInstance();
		Object o = null;
		if(m.isLogin()) {
			o = method.invoke(obj, args);
			m.log(new Date(System.currentTimeMillis()).toString() + "\t��ɲ�����" + method.getName());
		}else {
			m.log(new Date(System.currentTimeMillis()).toString() + "\tû��Ȩ�޲�����" + method.getName());
		}
		return o;
	}

}
