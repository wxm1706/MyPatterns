package patterns.proxy.case1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		ISubjectA subjectA = new SubjectA();
		ISubjectB subjectB = new SubjectB();
		InvocationHandler ih = new MyInvocationHandler(subjectB);
		ISubjectB proxy = (ISubjectB) Proxy.newProxyInstance(subjectA.getClass().getClassLoader(), new Class[]{ISubjectA.class, ISubjectB.class}, ih);
		proxy.requestB();
		System.out.println(proxy.getClass().getCanonicalName());
	}

}
