package com.book.model;

import java.util.ArrayList;

public interface BookDAO {
	
	//책 추가
	public void bookInsert(BookDTO book);
	
	//책 리스트
	public ArrayList<BookDTO> bookList(); 
	
	//책 수정
	public void bookUpdate(BookDTO book);
	
	//책 삭제
	public void bookDelete(int num);
	
	//책 상세보기
	public BookDTO bookDetail(int num);
	
	//책 개수
	public int bookCount();

}
