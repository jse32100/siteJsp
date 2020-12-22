package com.member.model;

import java.util.ArrayList;

public interface ContactDAO {
	
		//�߰�
		public void contactRegister(ContactDTO contact);
		
		//��ü����
		public ArrayList<ContactDTO> contactList();
		
		//�󼼺���
		public ContactDTO findById(int num);
		
		//����
		public void contactDelete(int num);
		
		//ȸ����
		public int contactCount();

}
