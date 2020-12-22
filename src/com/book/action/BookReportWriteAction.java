package com.book.action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.model.BookReportDAO;
import com.book.model.BookReportDAOImpl;
import com.book.model.BookReportDTO;
import com.member.model.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BookReportInsertAction
 */
@WebServlet("/book/bookreportwrite")
public class BookReportWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReportWriteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("bookReportWrite.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("utf-8");
		
		String savePath = "upload"; //����� ������ ��ġ(����)
		int uploadFileSizeLimit = 5*1024*1024; //�ִ� ���ε� 5mb�� ����
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("�������� ���� ���丮 : " + uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest(request/*request ��ü*/, uploadFilePath/*�������� ���� ���丮*/, 
				uploadFileSizeLimit/*�ִ� ���ε� ���� ũ��*/, encType/*���ڵ� ���*/, 
				new DefaultFileRenamePolicy()/*������ �̸� ����� ���ο� �̸� �ο���*/);
		//���ε�� ���� �̸� ���
		Enumeration files = multi.getFileNames();
		String name = (String) files.nextElement();
		String filename = multi.getFilesystemName(name);
		System.out.println("���ϸ� : " + filename);
		
		HttpSession session = request.getSession();
		MemberDTO sessionUser = (MemberDTO) session.getAttribute("member");
		String nickname = sessionUser.getNickname();
		
		BookReportDAO dao = BookReportDAOImpl.getInstance();
		BookReportDTO book = new BookReportDTO();
		book.setContent(multi.getParameter("content"));
		book.setFilename(filename);
		book.setTag(multi.getParameter("tag"));
		book.setTitle(multi.getParameter("title"));
		book.setWriter(nickname);
		
		dao.bookReportWrite(book);
		response.sendRedirect("bookreportlist");
		
		
	}

}
