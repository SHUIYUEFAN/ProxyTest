package com.zy.service;

public class UserService implements IUserService{

	@Override
	public void insert() {
		System.out.println("--����û�");
	}

	@Override
	public void delete() {
		System.out.println("--ɾ���û�");
	}

	@Override
	public void update() {
		System.out.println("--�޸��û�");
	}

	@Override
	public void query() {
		System.out.println("--��ѯ�û�");
	}

}
