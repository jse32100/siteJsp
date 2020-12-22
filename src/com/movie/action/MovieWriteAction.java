package com.movie.action;

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

import com.member.model.MemberDTO;
import com.movie.model.MovieDAO;
import com.movie.model.MovieDTO;
import com.movie.model.movieDAOImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MovieWriteAction
 */
@WebServlet("/movie/moviewrite")
public class MovieWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieWriteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("movieWrite.jsp");
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
		
		MovieDAO dao = movieDAOImpl.getInstance();
		MovieDTO movie = new MovieDTO();
		movie.setContent(multi.getParameter("content"));
		movie.setFilename(filename);
		movie.setTag(multi.getParameter("tag"));
		movie.setTitle(multi.getParameter("title"));
		movie.setWriter(nickname);
		
		dao.movietWrite(movie);
		response.sendRedirect("movielist");
	}

}
