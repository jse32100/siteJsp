package com.movie.model;

import java.util.ArrayList;


public interface MovieDAO {
	
	//게시글 추가
	public void movietWrite(MovieDTO movie);
	
	//게시글 수정
	public void movieModify(MovieDTO movie);

	//게시글 삭제
	public void movieDelete(int num);

	//게시글 전체보기
	public ArrayList<MovieDTO> findAll();

	//게시글 상세보기
	public MovieDTO findByNum(int num);

	//게시글수
	public int movieCount(); 
	
	//코멘트 추가
	public void commentInsert(commentMovieDTO comment);
	
	//코멘트 리스트
	public ArrayList<commentMovieDTO> findAllComment(int bnum);
	
	//코멘트 삭제
	public void commentDelete(int cnum);

}
