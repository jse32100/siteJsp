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
 * Servlet implementation class BookRegisterAction
 */
@WebServlet("/book/register")
public class BookRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRegisterAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("bookRegister.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("utf-8");
		
		String savePath = "upload"; //저장될 파일의 위치(폴더)
		int uploadFileSizeLimit = 5*1024*1024; //최대 업로드 5mb로 제한
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리 : " + uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest(request/*request 객체*/, uploadFilePath/*서버상의 실제 디렉토리*/, 
				uploadFileSizeLimit/*최대 업로드 파일 크기*/, encType/*인코딩 방법*/, 
				new DefaultFileRenamePolicy()/*동일한 이름 존재시 새로운 이름 부여됨*/);
		//업로드된 파일 이름 얻기
		Enumeration files = multi.getFileNames();
		String name = (String) files.nextElement();
		String filename = multi.getFilesystemName(name);
		if(filename==null) {
			filename=multi.getParameter("filenames");
		}
		System.out.println("파일명 : " + filename);
		
		BookDAO dao = BookDAOImpl.getInstance();
		BookDTO book = new BookDTO();
		book.setCategory(multi.getParameter("category"));
		book.setDescription(multi.getParameter("description"));
		book.setFilename(filename);
		book.setPrice(Integer.parseInt(multi.getParameter("price")));
		book.setPublisher(multi.getParameter("publisher"));
		book.setTitle(multi.getParameter("title"));
		book.setWriter(multi.getParameter("writer"));
		
		dao.bookInsert(book);
		response.sendRedirect("booklist");
		
		
		
	}

}
