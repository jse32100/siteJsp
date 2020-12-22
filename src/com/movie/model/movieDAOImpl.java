package com.movie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class movieDAOImpl implements MovieDAO {
	
	private static MovieDAO instance = new movieDAOImpl();
	public static MovieDAO getInstance() {
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
	public void movietWrite(MovieDTO movie) {
		// 게시글 추가
				Connection con = null;
				PreparedStatement ps = null;
				
				try {
					con = getConnection();
					StringBuilder sb = new StringBuilder();
					sb.append("insert into movie");
					sb.append("(num, title, writer, content, filename, readcount, reg_date, tag)");
					sb.append(" values(movie_seq.nextval, ?, ?, ?, ?, ?, sysdate, ?)");
					ps = con.prepareStatement(sb.toString());
					ps.setString(1, movie.getTitle());
					ps.setString(2, movie.getWriter());
					ps.setString(3, movie.getContent());
					ps.setString(4, movie.getFilename());
					ps.setInt(5, movie.getReadcount());
					ps.setString(6, movie.getTag());
					ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeConnection(con, ps, null, null);
				}

	}

	@Override
	public void movieModify(MovieDTO movie) {
		//영화 감상 수정
				Connection con = null;
				PreparedStatement ps = null;
				
				try {
					con = getConnection();
					String sql = "update movie set title=?, writer=?, content=?, tag=?, reg_date=sysdate, filename=? where num=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, movie.getTitle());
					ps.setString(2, movie.getWriter());
					ps.setString(3, movie.getContent());
					ps.setString(4, movie.getTag());
					ps.setString(5, movie.getFilename());
					ps.setInt(6, movie.getNum());
					ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeConnection(con, ps, null, null);
				}

	}

	@Override
	public void movieDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from movie where num='"+num+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}

	}

	@Override
	public ArrayList<MovieDTO> findAll() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<MovieDTO> arr = new ArrayList<MovieDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from movie order by num desc";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				MovieDTO movie = new MovieDTO();
				movie.setContent(rs.getString("content"));
				movie.setFilename(rs.getString("filename"));
				movie.setNum(rs.getInt("num"));
				movie.setReadcount(rs.getInt("readcount"));
				movie.setReg_date(rs.getString("reg_date"));
				movie.setTag(rs.getString("tag"));
				movie.setTitle(rs.getString("title"));
				movie.setWriter(rs.getString("writer"));
				arr.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override
	public MovieDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MovieDTO movie = null;
		
		try {
			con = getConnection();
			String sql = "select * from movie where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				movie = new MovieDTO();
				movie.setContent(rs.getString("content"));
				movie.setFilename(rs.getString("filename"));
				movie.setNum(rs.getInt("num"));
				movie.setReadcount(rs.getInt("readcount"));
				movie.setReg_date(rs.getString("reg_date"));
				movie.setTag(rs.getString("tag"));
				movie.setTitle(rs.getString("title"));
				movie.setWriter(rs.getString("writer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return movie;
	}

	@Override
	public int movieCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from movie";
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
	public void commentInsert(commentMovieDTO comment) {
		//코멘트 추가
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into commentmovie values (?, ?, ?, sysdate, commentmovie_seq.nextval)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, comment.getBnum());
			ps.setString(2, comment.getContent());
			ps.setString(3, comment.getNickname());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}
		
	}

	@Override
	public ArrayList<commentMovieDTO> findAllComment(int bnum) {
		// 댓글리스트
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		ArrayList<commentMovieDTO> carr = new ArrayList<commentMovieDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from commentmovie where bnum="+bnum;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				commentMovieDTO comment = new commentMovieDTO();
				comment.setBnum(rs.getInt("bnum"));
				comment.setCnum(rs.getInt("cnum"));
				comment.setContent(rs.getString("content"));
				comment.setNickname(rs.getString("nickname"));
				comment.setReg_date(rs.getString("reg_date"));
				carr.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return carr;
	}
	
	@Override
	public void commentDelete(int cnum) {
		//코멘트 삭제
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from commentmovie where cnum='"+cnum+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
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
