package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAO instance = new BoardDAOImpl();
	public static BoardDAO getInstance() {
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
	public void boardWrite(BoardDTO board) {
		// 게시글 추가
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into board");
			sb.append("(num, title, writer, description, filename, tag, reg_date)");
			sb.append(" values(board_seq.nextval, ?, ?, ?, ?, ?, sysdate)");
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getDescription());
			ps.setString(4, board.getFilename());
			ps.setString(5, board.getTag());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}

	}

	@Override
	public void boardModify(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "update board set title=?, writer=?, description=?, tag=?, reg_date=sysdate, filename=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getDescription());
			ps.setString(4, board.getTag());
			ps.setString(5, board.getFilename());
			ps.setInt(6, board.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}

	}

	@Override
	public void boardDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from board where num='"+num+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
		

	}

	@Override
	public ArrayList<BoardDTO> findAll() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from board";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setDescription(rs.getString("description"));
				board.setFilename(rs.getString("filename"));
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReg_date(rs.getString("reg_date"));
				board.setTag(rs.getString("tag"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				arr.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override
	public BoardDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardDTO board = null;
		
		try {
			con = getConnection();
			String sql = "select * from board where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				board = new BoardDTO();
				board.setDescription(rs.getString("description"));
				board.setFilename(rs.getString("filename"));
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReg_date(rs.getString("reg_date"));
				board.setTag(rs.getString("tag"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return board;
	}

	@Override
	public int boardCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from board";
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
	public ArrayList<BoardDTO> findAll(String field, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCount(String field, String word) {
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
