package com.board.action;

import java.io.IOException;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.model.BoardDAO;
import com.board.model.BoardDAOImpl;
import com.board.model.BoardDTO;
import com.member.model.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class NoticeWriteAction
 */
@WebServlet("/notice/noticewrite")
public class NoticeWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteAction() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("noticeWrite.jsp");
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
		
		BoardDAO dao = BoardDAOImpl.getInstance();
		BoardDTO board = new BoardDTO();
		board.setDescription(multi.getParameter("description"));
		board.setFilename(filename);
		board.setTag(multi.getParameter("tag"));
		board.setTitle(multi.getParameter("title"));
		board.setWriter(nickname);
		
		dao.boardWrite(board);
		response.sendRedirect("noticelist");
		
	}

}
