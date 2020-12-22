package com.board.action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDAOImpl;
import com.board.model.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class NoticeModifyAction
 */
@WebServlet("/notice/modify")
public class NoticeModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = BoardDAOImpl.getInstance();
		
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDTO board = dao.findByNum(num);
		request.setAttribute("board", board);
		
		RequestDispatcher rd = request.getRequestDispatcher("noticeModify.jsp");
		rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		if(filename==null) {
			filename=multi.getParameter("filenames");
		}
		System.out.println("���ϸ� : " + filename);
		
		
		BoardDAO dao = BoardDAOImpl.getInstance();
		BoardDTO board = new BoardDTO();
	
		board.setNum(Integer.parseInt(multi.getParameter("num")));
		board.setDescription(multi.getParameter("description"));
		board.setFilename(filename);
		board.setTag(multi.getParameter("tag"));
		board.setTitle(multi.getParameter("title"));
		board.setWriter(multi.getParameter("writer"));
		
		dao.boardModify(board);
		response.sendRedirect("noticelist");
		
		

	}

}
