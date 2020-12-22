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

import com.sun.corba.se.spi.orbutil.fsm.State;


public class BookDAOImpl implements BookDAO {
	
	private static BookDAO instance = new BookDAOImpl();
	public static BookDAO getInstance() {
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
	public void bookInsert(BookDTO book) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into book");
			sb.append("(num, title, writer, price, publisher, description, filename, category)");
			sb.append(" values(book_seq.nextval,?,?,?,?,?,?,?)");
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getWriter());
			ps.setInt(3, book.getPrice());
			ps.setString(4, book.getPublisher());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getFilename());
			ps.setString(7, book.getCategory());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}

	}

	@Override
	public ArrayList<BookDTO> bookList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BookDTO> arr = new ArrayList<BookDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from book";
			st= con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BookDTO book = new BookDTO();
				book.setCategory(rs.getString("category"));
				book.setDescription(rs.getString("description"));
				book.setFilename(rs.getString("filename"));
				book.setNum(rs.getInt("num"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
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
	public void bookUpdate(BookDTO book) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "update book set title=?, writer=?, publisher=?, price=?, description=?, category=?, filename=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getWriter());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getCategory());
			ps.setString(7, book.getFilename());
			ps.setInt(8, book.getNum());
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}
	}

	@Override
	public void bookDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from book where num='"+num+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
	}

	@Override
	public BookDTO bookDetail(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BookDTO book = null;
		
		try {
			con = getConnection();
			String sql = "select * from book where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				book = new BookDTO();
				book.setCategory(rs.getString("category"));
				book.setDescription(rs.getString("description"));
				book.setFilename(rs.getString("filename"));
				book.setNum(rs.getInt("num"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
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
	public int bookCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from book";
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
