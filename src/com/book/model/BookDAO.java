package com.book.model;

import java.util.ArrayList;

public interface BookDAO {
	
	//å �߰�
	public void bookInsert(BookDTO book);
	
	//å ����Ʈ
	public ArrayList<BookDTO> bookList(); 
	
	//å ����
	public void bookUpdate(BookDTO book);
	
	//å ����
	public void bookDelete(int num);
	
	//å �󼼺���
	public BookDTO bookDetail(int num);
	
	//å ����
	public int bookCount();

}
