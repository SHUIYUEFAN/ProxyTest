package com.zy.factory;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.zy.service.UserService;

public class ProxyFactory2 implements MethodInterceptor{
	
	public UserService getProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserService.class);
		enhancer.setCallback(this);
		
		UserService proxyService =(UserService) enhancer.create();
		
		return proxyService;
	}

	@Override
	public Object intercept(Object service, Method method, Object[] arg2, MethodProxy methodProxy) throws Throwable {
		preHandle();
		Object invokeSuper = methodProxy.invokeSuper(service, arg2);
		postHandle();
		return invokeSuper;
	}

	
	private void preHandle() {
		System.out.println("--预处理");
	}
	
	private void postHandle() {
		System.out.println("--后处理");
	}
}
