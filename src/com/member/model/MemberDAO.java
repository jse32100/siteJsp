package com.member.model;

import java.util.ArrayList;

public interface MemberDAO {
	
	//추가
	public void memberRegister(MemberDTO member);
	
	//전체보기
	public ArrayList<MemberDTO> getMember();
	
	//수정
	public int memberUpdate(MemberDTO member);
	
	//상세보기
	public MemberDTO findById(String userid);
	
	//삭제
	public void memberDelete(String userid);
	
	//회원수
	public int memberCount();
	
	//아이디 중복 확인
	public String memberIdCheck(String userid);

	//아이디 중복 확인
	public String memberNickCheck(String nickname);
		
	//로그인 확인
	public MemberDTO memberLoginCheck(String userid, String pwd);


}
