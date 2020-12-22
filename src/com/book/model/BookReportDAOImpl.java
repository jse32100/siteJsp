package com.book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BookReportDAOImpl implements BookReportDAO {
	
	private static BookReportDAO instance = new BookReportDAOImpl();
	public static BookReportDAO getInstance() {
		return instance;
	}

	//��񿬰�
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/member");
			return ds.getConnection();
		}

	@Override
	public void bookReportWrite(BookReportDTO book) {
		// �Խñ� �߰�
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into bookreport");
			sb.append("(num, title, writer, content, filename, readcount, reg_date, tag)");
			sb.append(" values(bookreport_seq.nextval, ?, ?, ?, ?, ?, sysdate, ?)");
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getWriter());
			ps.setString(3, book.getContent());
			ps.setString(4, book.getFilename());
			ps.setInt(5, book.getReadcount());
			ps.setString(6, book.getTag());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}

	}

	@Override
	public void bookReportModify(BookReportDTO book) {
		//å ���� ����
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "update bookreport set title=?, writer=?, content=?, tag=?, reg_date=sysdate, filename=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getWriter());
			ps.setString(3, book.getContent());
			ps.setString(4, book.getTag());
			ps.setString(5, book.getFilename());
			ps.setInt(6, book.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}


	}

	@Override
	public void bookReportDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from bookreport where num='"+num+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}

	}

	@Override
	public ArrayList<BookReportDTO> findAll() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BookReportDTO> arr = new ArrayList<BookReportDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from bookreport";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BookReportDTO book = new BookReportDTO();
				book.setContent(rs.getString("content"));
				book.setFilename(rs.getString("filename"));
				book.setNum(rs.getInt("num"));
				book.setReadcount(rs.getInt("readcount"));
				book.setReg_date(rs.getString("reg_date"));
				book.setTag(rs.getString("tag"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				arr.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override
	public BookReportDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BookReportDTO book = null;
		
		try {
			con = getConnection();
			String sql = "select * from bookreport where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				book = new BookReportDTO();
				book.setContent(rs.getString("content"));
				book.setFilename(rs.getString("filename"));
				book.setNum(rs.getInt("num"));
				book.setReadcount(rs.getInt("readcount"));
				book.setReg_date(rs.getString("reg_date"));
				book.setTag(rs.getString("tag"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return book;
	}

	@Override
	public int bookReportCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from bookreport";
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
	
	//�ݱ� �޼ҵ�
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
