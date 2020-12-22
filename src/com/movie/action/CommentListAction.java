package com.movie.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.movie.model.MovieDAO;
import com.movie.model.commentMovieDTO;
import com.movie.model.movieDAOImpl;

/**
 * Servlet implementation class CommentListAction
 */
@WebServlet("/movie/commentList")  
public class CommentListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		MovieDAO dao = movieDAOImpl.getInstance();
		
		ArrayList<commentMovieDTO> carr = dao.findAllComment(bnum); 

		JSONObject main = new JSONObject();
		JSONArray jarr = new JSONArray();
		for(commentMovieDTO c : carr) {
			JSONObject obj = new JSONObject();
			obj.put("cnum", c.getCnum());
			obj.put("content", c.getContent());
			obj.put("nickname", c.getNickname());
			obj.put("reg_date", c.getReg_date());
			obj.put("bnum", c.getBnum());
			jarr.add(obj);
		}
		
		main.put("jarr", jarr);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(main.toString());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
