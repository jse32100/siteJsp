package com.movie.model;

import java.util.ArrayList;


public interface MovieDAO {
	
	//�Խñ� �߰�
	public void movietWrite(MovieDTO movie);
	
	//�Խñ� ����
	public void movieModify(MovieDTO movie);

	//�Խñ� ����
	public void movieDelete(int num);

	//�Խñ� ��ü����
	public ArrayList<MovieDTO> findAll();

	//�Խñ� �󼼺���
	public MovieDTO findByNum(int num);

	//�Խñۼ�
	public int movieCount(); 
	
	//�ڸ�Ʈ �߰�
	public void commentInsert(commentMovieDTO comment);
	
	//�ڸ�Ʈ ����Ʈ
	public ArrayList<commentMovieDTO> findAllComment(int bnum);
	
	//�ڸ�Ʈ ����
	public void commentDelete(int cnum);

}
