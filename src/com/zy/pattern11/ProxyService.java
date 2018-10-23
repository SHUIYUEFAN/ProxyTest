package com.zy.pattern11;

public class ProxyService implements IService{
	
	private RealService realService=new RealService();

	@Override
	public void doLogin(String username, String password) {
		//1.服务前的预操作
		preService();
		
		realService.doLogin(username, password);
		
		//2.服务后的操作
		postService();
	}
	
	private void preService() {
		System.out.println("--登录前的预操作");
	}

	
	private void postService() {
		System.out.println("--登录后的操作");
	}
}
