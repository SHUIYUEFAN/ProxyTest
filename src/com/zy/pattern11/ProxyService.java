package com.zy.pattern11;

public class ProxyService implements IService{
	
	private RealService realService=new RealService();

	@Override
	public void doLogin(String username, String password) {
		//1.����ǰ��Ԥ����
		preService();
		
		realService.doLogin(username, password);
		
		//2.�����Ĳ���
		postService();
	}
	
	private void preService() {
		System.out.println("--��¼ǰ��Ԥ����");
	}

	
	private void postService() {
		System.out.println("--��¼��Ĳ���");
	}
}
