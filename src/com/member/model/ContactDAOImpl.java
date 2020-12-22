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


public class ContactDAOImpl implements ContactDAO {
	
	private static ContactDAO instance = new ContactDAOImpl();
	public static ContactDAO getInstance() {
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
	public void contactRegister(ContactDTO contact) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into contact");
			sb.append("(num, userid, name, email, phone, category, message, reg_date, title)");
			sb.append(" values(contact_seq.nextval,?,?,?,?,?,?,sysdate,?)");
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, contact.getUserid());
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getPhone());
			ps.setString(5, contact.getCategory());
			ps.setString(6, contact.getMessage());
			ps.setString(7, contact.getTitle());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}

	}

	@Override
	public ArrayList<ContactDTO> contactList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ContactDTO> arr = new ArrayList<ContactDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from contact order by num desc";
			st= con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ContactDTO contact = new ContactDTO();
				contact.setCategory(rs.getString("category"));
				contact.setEmail(rs.getString("email"));
				contact.setMessage(rs.getString("message"));
				contact.setName(rs.getString("name"));
				contact.setNum(rs.getInt("num"));
				contact.setPhone(rs.getString("phone"));
				contact.setReg_date(rs.getString("reg_date"));
				contact.setUserid(rs.getString("userid"));
				contact.setTitle(rs.getString("title"));
				arr.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override
	public ContactDTO findById(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ContactDTO contact = null;
		
		try {
			con = getConnection();
			String sql = "select * from contact where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				contact = new ContactDTO();
				contact.setCategory(rs.getString("category"));
				contact.setEmail(rs.getString("email"));
				contact.setMessage(rs.getString("message"));
				contact.setName(rs.getString("name"));
				contact.setNum(rs.getInt("num"));
				contact.setPhone(rs.getString("phone"));
				contact.setReg_date(rs.getString("reg_date"));
				contact.setUserid(rs.getString("userid"));
				contact.setTitle(rs.getString("title"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return contact;
	}

	@Override
	public void contactDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from contact where num='"+num+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
	}

	@Override
	public int contactCount() {
		// TODO Auto-generated method stub
		return 0;
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
