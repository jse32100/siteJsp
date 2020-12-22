package com.movie.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberDTO;
import com.movie.model.MovieDAO;
import com.movie.model.commentMovieDTO;
import com.movie.model.movieDAOImpl;


/**
 * Servlet implementation class CommentInsertAction
 */
@WebServlet("/movie/commentInsert")
public class CommentInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//세션값 구해서 nickname 받아오기
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
			
		//insert된 값 받아오기
		String content = request.getParameter("content");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		MovieDAO dao = movieDAOImpl.getInstance();
		commentMovieDTO comment = new commentMovieDTO();
		
		comment.setNickname(member.getNickname());
		comment.setContent(content);
		comment.setBnum(bnum);
		dao.commentInsert(comment);
		response.sendRedirect("detail?num="+bnum);

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
