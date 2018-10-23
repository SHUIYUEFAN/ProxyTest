package com.zy.pattern11;

public class RealService implements IService{

	@Override
	public void doLogin(String username, String password) {
		System.out.println("验证用户名、密码。");
	}

}
