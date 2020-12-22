package com.member.model;

import java.util.ArrayList;

public interface ContactDAO {
	
		//추가
		public void contactRegister(ContactDTO contact);
		
		//전체보기
		public ArrayList<ContactDTO> contactList();
		
		//상세보기
		public ContactDTO findById(int num);
		
		//삭제
		public void contactDelete(int num);
		
		//회원수
		public int contactCount();

}
