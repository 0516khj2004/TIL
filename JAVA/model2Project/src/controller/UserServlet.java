package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.deploy.nativesandbox.comm.Request;

import jdbc.user.dao.UserDAO;
import jdbc.user.vo.UserVO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("*.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	private RequestDispatcher rd;
    
	@Override
	public void init() throws ServletException {
		System.out.println("userServlet init() method called!");
		dao = new UserDAO();
	}
	
	@Override
	public void destroy() {
		System.out.println("userServlet destroy() method called!");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("userServlet doGet() method called!");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String cmd = request.getParameter("cmd");
		System.out.println(">>>>cmmand : " + cmd);
		if(cmd.equals("userList")) {
			userList(request, response);
		}else if(cmd.equals("userDetail")) {
			userDetail(request, response);
		}
	}

	private void userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.DAO ȣ��
		List<UserVO> users = dao.getUsers();
		System.out.println(users);
		//2.DAO�� �޾� �� List ��ü�� Jsp���� ����� �� �ֵ��� request ��ü �����մϴ�.
		request.setAttribute("userList", users);
		//3.����� ������� jsp - useList.jsp �� ������ 
		rd = request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
	}
	
	private void userDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid = request.getParameter("id"); // Lsit.jsp���� id �Ķ���� ���� ������
		System.out.println(">>>>userid : " + userid);

//		//1.DAO ȣ��
//		List<UserVO> users = dao.getUsers();
//		System.out.println(users);
//		//2.DAO�� �޾� �� List ��ü�� Jsp���� ����� �� �ֵ��� request ��ü �����մϴ�.
//		request.setAttribute("userList", users);
//		//3.����� ������� jsp - useList.jsp �� ������ 
//		rd = request.getRequestDispatcher("userList.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
