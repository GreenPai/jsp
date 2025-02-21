package kr.co.jboard.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.dto.UserDTO;

@WebFilter("/*")
public class LoginCheckFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		logger.debug("LoginCheckFilter...1");
		
		// �α��� ���� �˻�
		HttpServletRequest request =(HttpServletRequest) req;
		HttpSession session = request.getSession();
		
		UserDTO userDTO = (UserDTO) session.getAttribute("sessUser");
		
		// ��û URL Ȯ��
		String uri  = request.getRequestURI(); // /jboard/article/list.do
		logger.debug("LoginCheckFilter...2 : " + uri);
		
		String ctxPath = request.getContextPath(); // /jboard
		logger.debug("LoginCheckFilter...3 : " + ctxPath);
		
		String path = uri.substring(ctxPath.length());
		logger.debug("LoginCheckFilter...4 : " + path );
		
		
		
		if(path.startsWith("/user") && !path.contains("logout.do")) {
			// �α����ϰ� /user/* ��û�� ��
			if(userDTO != null) {
				// �α����� ������ ��� �α��� �������� �̵�
				HttpServletResponse response = (HttpServletResponse) resp;
				response.sendRedirect("/jboard/article/list.do");
				return;	
			}
		}else if(path.startsWith("/article")) {
			// �α����� ���� �ʰ� /article/* ��û�� ��
			// �α����� ������ ��� �α��� �������� �̵�
			
			if(userDTO == null) {
				// �α����� ������ ��� �α��� �������� �̵�
				HttpServletResponse response = (HttpServletResponse) resp;
				response.sendRedirect("/jboard/user/login.do?result=102");
				return;	
			}
		}
	
		// ���� ����(Controller) �̵�
		chain.doFilter(req, resp);
		
	}

}
