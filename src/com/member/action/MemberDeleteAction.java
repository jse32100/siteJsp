package com.member.action;

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

import com.member.model.MemberDAO;
import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;


/**
 * Servlet implementation class MemberDeleteAction
 */
@WebServlet("/member/userDelete")
public class MemberDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		
		MemberDAO dao = MemberDAOImpl.getInstance();
		dao.memberDelete(userid);
		int count = dao.memberCount();
		
		ArrayList<MemberDTO> arr = dao.getMember();
		
		JSONArray jarr = new JSONArray();
		for(MemberDTO m : arr) {
			String mode = m.getAdmin() == 1 ? "관리자" : "일반회원";
			JSONObject obj = new JSONObject();
			obj.put("userid", m.getUserid());
			obj.put("email", m.getEmail());
			obj.put("name", m.getName());
			obj.put("phone", m.getPhone());
			obj.put("nickname", m.getNickname());
			obj.put("admin", mode);
			jarr.add(obj);
		}
		
		JSONObject countObj = new JSONObject();
		countObj.put("count", count);
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("jarr", jarr);
		mainObj.put("countObj", countObj);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(mainObj.toString());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
