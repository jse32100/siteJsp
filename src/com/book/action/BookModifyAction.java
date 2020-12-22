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

import com.book.model.BookDAO;
import com.book.model.BookDAOImpl;
import com.book.model.BookDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BookModifyAction
 */
@WebServlet("/book/modify")
public class BookModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		BookDAO dao = BookDAOImpl.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		BookDTO book = dao.bookDetail(num);
		request.setAttribute("book", book);
	
		RequestDispatcher rd = request.getRequestDispatcher("bookModify.jsp");
		rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
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
		if(filename==null) {
			filename=multi.getParameter("filenames");
		}
		System.out.println("���ϸ� : " + filename);
		
		BookDAO dao = BookDAOImpl.getInstance();
		BookDTO book = new BookDTO();
		
		book.setNum(Integer.parseInt(multi.getParameter("num")));
		book.setCategory(multi.getParameter("category"));
		book.setDescription(multi.getParameter("description"));
		book.setFilename(filename);
		book.setPrice(Integer.parseInt(multi.getParameter("price")));
		book.setPublisher(multi.getParameter("publisher"));
		book.setTitle(multi.getParameter("title"));
		book.setWriter(multi.getParameter("writer"));

		
		dao.bookUpdate(book);
		response.sendRedirect("booklist");
	}

}
