package kr.co.jboard.controller.user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.dto.UserDTO;
import kr.co.jboard.service.UserService;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1270462765653325712L;
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ������ ����
		String result = req.getParameter("result");
		
		// ������ ���� ����
		req.setAttribute("result", result);		
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������ ����
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		
		// DTO ����
		UserDTO dto = new UserDTO();
		dto.setUid(uid);
		dto.setPass(pass);
		
		// ���� ȣ��	
		UserDTO userDTO = service.findUser(dto);
		System.out.println(userDTO);
		
		
		if(userDTO != null) {
			// ȸ���� ���� ��� ���� ����
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", userDTO);
			
			// �Խ��� ��� �̵�
			resp.sendRedirect("/jboard/article/list.do");
		}else {
			// ȸ���� �ƴ� ��� �ٽ� �α��� ������ �̵�
			resp.sendRedirect("/jboard/user/login.do?result=100");			
		}
	}
}