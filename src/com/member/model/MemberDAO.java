package com.member.model;

import java.util.ArrayList;

public interface MemberDAO {
	
	//�߰�
	public void memberRegister(MemberDTO member);
	
	//��ü����
	public ArrayList<MemberDTO> getMember();
	
	//����
	public int memberUpdate(MemberDTO member);
	
	//�󼼺���
	public MemberDTO findById(String userid);
	
	//����
	public void memberDelete(String userid);
	
	//ȸ����
	public int memberCount();
	
	//���̵� �ߺ� Ȯ��
	public String memberIdCheck(String userid);

	//���̵� �ߺ� Ȯ��
	public String memberNickCheck(String nickname);
		
	//�α��� Ȯ��
	public MemberDTO memberLoginCheck(String userid, String pwd);


}
