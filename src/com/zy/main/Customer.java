package com.zy.main;

import com.zy.factory.ProxyFactory;
import com.zy.factory.ProxyFactory2;
import com.zy.service.IUserService;
import com.zy.service.UserService;

public class Customer {

	public static void main(String[] args) {
		UserService userService = new UserService();
		ProxyFactory proxyFactory = new ProxyFactory(userService);
		
		IUserService proxyService = proxyFactory.getProxy();
		proxyService.insert();
		System.out.println(proxyService instanceof UserService);
		
		
		ProxyFactory2 proxyFactory2 = new ProxyFactory2();
		UserService proxyService2 = proxyFactory2.getProxy();
		proxyService2.delete();
		System.out.println(proxyService2 instanceof UserService);
		
	}

}
