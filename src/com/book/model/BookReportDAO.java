package com.book.model;

import java.util.ArrayList;

public interface BookReportDAO {
	
	//게시글 추가
	public void bookReportWrite(BookReportDTO book);
	
	//게시글 수정
	public void bookReportModify(BookReportDTO book);

	//게시글 삭제
	public void bookReportDelete(int num);

	//게시글 전체보기
	public ArrayList<BookReportDTO> findAll();

	//게시글 상세보기
	public BookReportDTO findByNum(int num);

	//게시글수
	public int bookReportCount(); 

}
