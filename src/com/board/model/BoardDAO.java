package com.board.model;

import java.util.ArrayList;

public interface BoardDAO {
	
	//�Խñ� �߰�
	public void boardWrite(BoardDTO board);
	
	//�Խñ� ����
	public void boardModify(BoardDTO board);

	//�Խñ� ����
	public void boardDelete(int num);

	//�Խñ� ��ü����
	public ArrayList<BoardDTO> findAll();

	//�Խñ� �󼼺���
	public BoardDTO findByNum(int num);

	//�Խñۼ�
	public int boardCount(); 

	//�Խñ� �˻�
	public ArrayList<BoardDTO> findAll(String field, String word);

	//�˻�(�Խñۼ�)
	public int getBoardCount(String field, String word);

}
