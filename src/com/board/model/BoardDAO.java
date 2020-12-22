package com.board.model;

import java.util.ArrayList;

public interface BoardDAO {
	
	//게시글 추가
	public void boardWrite(BoardDTO board);
	
	//게시글 수정
	public void boardModify(BoardDTO board);

	//게시글 삭제
	public void boardDelete(int num);

	//게시글 전체보기
	public ArrayList<BoardDTO> findAll();

	//게시글 상세보기
	public BoardDTO findByNum(int num);

	//게시글수
	public int boardCount(); 

	//게시글 검색
	public ArrayList<BoardDTO> findAll(String field, String word);

	//검색(게시글수)
	public int getBoardCount(String field, String word);

}
