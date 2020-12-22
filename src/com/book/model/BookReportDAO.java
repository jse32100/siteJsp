package com.book.model;

import java.util.ArrayList;

public interface BookReportDAO {
	
	//�Խñ� �߰�
	public void bookReportWrite(BookReportDTO book);
	
	//�Խñ� ����
	public void bookReportModify(BookReportDTO book);

	//�Խñ� ����
	public void bookReportDelete(int num);

	//�Խñ� ��ü����
	public ArrayList<BookReportDTO> findAll();

	//�Խñ� �󼼺���
	public BookReportDTO findByNum(int num);

	//�Խñۼ�
	public int bookReportCount(); 

}
