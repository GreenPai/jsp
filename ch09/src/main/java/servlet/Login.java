package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login.do")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 4L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ������ ����
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		
		// ���̵� abc123, ��й�ȣ 1234
		if(uid.equals("abc123") && pass.equals("1234")) {
			
			// ���� Ŭ���̾�Ʈ ���� �������� 
			HttpSession session = req.getSession();
			
			// �α��� ���� ó��
			session.setAttribute("username", uid);
			
			// �̵�
			resp.sendRedirect("/ch09/3.Listener.jsp");
		}else {
			// �̵�
			resp.sendRedirect("/ch09/3.Listener.jsp?login=100");
		}
	}
}
