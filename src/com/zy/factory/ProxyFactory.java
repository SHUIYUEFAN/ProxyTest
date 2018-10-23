package com.zy.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.zy.service.IUserService;
import com.zy.service.UserService;

public class ProxyFactory implements InvocationHandler{

	private IUserService service;//真实服务
	
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

	private void preHandle() {//预处理
		System.out.println("--预处理");
	}
	
	
	private void postHandle() {//后处理
		System.out.println("--后处理");
	}
}
