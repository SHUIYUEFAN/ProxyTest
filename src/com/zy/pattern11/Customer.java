package com.zy.pattern11;

public class Customer {

	public static void main(String[] args) {
		ProxyService proxyService = new ProxyService();
		proxyService.doLogin("tom", "123");
	}

}
