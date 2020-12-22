package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.ContactDAO;
import com.member.model.ContactDAOImpl;
import com.member.model.ContactDTO;

import com.member.model.MemberDTO;

/**
 * Servlet implementation class ContactWriteAction
 */
@WebServlet("/member/contactwrite")
public class ContactWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactWriteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		request.setAttribute("member", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("contactWrite.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		ContactDAO dao = ContactDAOImpl.getInstance();
		ContactDTO contact = new ContactDTO();
		
		contact.setCategory(request.getParameter("category"));
		contact.setEmail(request.getParameter("email"));
		contact.setMessage(request.getParameter("message"));
		contact.setName(request.getParameter("name"));
//		contact.setNum(Integer.parseInt(request.getParameter("num")));
		contact.setPhone(request.getParameter("phone"));
		contact.setReg_date(request.getParameter("reg_date"));
		contact.setUserid(request.getParameter("userid"));
		contact.setTitle(request.getParameter("title"));
		
		dao.contactRegister(contact);
		response.sendRedirect("contactfinish");
	}

}
