package com.sun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;



public class MyInvocationHandler implements InvocationHandler{
	Object subject;
	
	public MyInvocationHandler(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		method.invoke(subject, args);
		System.out.println("after");
		return null;
	}

}
