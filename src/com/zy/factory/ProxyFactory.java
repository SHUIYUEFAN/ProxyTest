package com.zy.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.zy.service.IUserService;
import com.zy.service.UserService;

public class ProxyFactory implements InvocationHandler{

	private IUserService service;//��ʵ����
	
	public ProxyFactory(IUserService service) {
		this.service=service;
	}
	
	public IUserService getProxy() {
		IUserService proxyService = (IUserService)Proxy.newProxyInstance(ProxyFactory.class.getClassLoader()
				, UserService.class.getInterfaces()
				, this);
		
		return proxyService;
	}
	
	@Override
	public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
		preHandle();//
		Object invoke = method.invoke(service, arg2);
		postHandle();//
		return invoke;
	}

	private void preHandle() {//Ԥ����
		System.out.println("--Ԥ����");
	}
	
	
	private void postHandle() {//����
		System.out.println("--����");
	}
}
