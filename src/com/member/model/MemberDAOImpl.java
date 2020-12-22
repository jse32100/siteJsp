package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO {
	
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {
		return instance;
	}

	//디비연결
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/member");
			return ds.getConnection();
		}
		
	@Override
	public void memberRegister(MemberDTO member) {
		// 회원 가입
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setString(4, member.getNickname());
			ps.setInt(5, member.getAge());
			ps.setString(6, member.getGender());
			ps.setString(7, member.getEmail());
			ps.setString(8, member.getPhone());
			ps.setString(9, member.getZipcode());
			ps.setString(10, member.getAddress());
			ps.setInt(11, member.getAdmin());
			ps.setString(12, member.getAddress2());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}

	}

	@Override
	public ArrayList<MemberDTO> getMember() {
		//멤버전체보기
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from member order by name desc";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setAddress(rs.getString("address"));
				member.setAddress2(rs.getString("address2"));
				member.setAdmin(rs.getInt("admin"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setGender(rs.getString("gender"));
				member.setName(rs.getString("name"));
				member.setNickname(rs.getString("nickname"));
				member.setPhone(rs.getString("phone"));
				member.setPwd(rs.getString("pwd"));
				member.setUserid(rs.getString("userid"));
				member.setZipcode(rs.getString("zipcode"));
				arr.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return arr;
	}

	@Override
	public int memberUpdate(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			con = getConnection();
			String sql = "update member set name=?, nickname=?, pwd=?, email=?, phone=?, zipcode=?, address=?, address2=? where userid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getNickname());
			ps.setString(3, member.getPwd());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getZipcode());
			ps.setString(7, member.getAddress());
			ps.setString(8, member.getAddress2());
			ps.setString(9, member.getUserid());
			flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}
		
		return flag;
	}

	@Override
	public MemberDTO findById(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MemberDTO member = null;		
		
		try {
			con = getConnection();
			String sql = "select * from member where userid='"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				member = new MemberDTO();
				member.setAddress(rs.getString("address"));
				member.setAddress2(rs.getString("address2"));
				member.setAdmin(rs.getInt("admin"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setGender(rs.getString("gender"));
				member.setName(rs.getString("name"));
				member.setNickname(rs.getString("nickname"));
				member.setPhone(rs.getString("phone"));
				member.setPwd(rs.getString("pwd"));
				member.setUserid(rs.getString("userid"));
				member.setZipcode(rs.getString("zipcode"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return member;
	}

	@Override
	public void memberDelete(String userid) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from member where userid='"+userid+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}

	}

	@Override
	public int memberCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from member";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}

		return count;
	}

	@Override
	public String memberIdCheck(String userid) {
		// 아이디 중복 체크
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String result = "yes";
		
		try {
			con = getConnection();
			String sql = "select userid from member where userid='"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				result = "no";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return result;
	}

	@Override
	public String memberNickCheck(String nickname) {
		// 닉네임 중복 체크
				Connection con = null;
				Statement st = null;
				ResultSet rs = null;
				String result = "yes";
				
				try {
					con = getConnection();
					String sql = "select userid from member where nickname='"+nickname+"'";
					st = con.createStatement();
					rs = st.executeQuery(sql);
					if(rs.next()) {
						result = "no";
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeConnection(con, null, st, rs);
				}
				
				return result;
	}

	@Override
	public MemberDTO memberLoginCheck(String userid, String pwd) {
		// 멤버 로그인
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		MemberDTO member = new MemberDTO();
		member.setAdmin(-1); // -1은 비회원
		
		try {
			con = getConnection();
			String sql = "select * from member where userid='"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					member.setAddress(rs.getString("address"));
					member.setAddress2(rs.getString("address2"));
					member.setAdmin(rs.getInt("admin"));
					member.setAge(rs.getInt("age"));
					member.setEmail(rs.getString("email"));
					member.setGender(rs.getString("gender"));
					member.setName(rs.getString("name"));
					member.setNickname(rs.getString("nickname"));
					member.setPhone(rs.getString("phone"));
					member.setPwd(rs.getString("pwd"));
					member.setUserid(rs.getString("userid"));
					member.setZipcode(rs.getString("zipcode"));
				} else {
					member.setAdmin(2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		
		return member;
	}
	
	//닫기 메소드
	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
			try {
				if(rs!=null )  rs.close();
				if(st!=null )  st.close();
				if(ps!=null )  ps.close();
				if(con!=null )  con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
