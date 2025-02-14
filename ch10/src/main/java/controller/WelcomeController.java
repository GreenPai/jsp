package controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome.do")
public class WelcomeController extends HttpServlet{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final long serialVersionUID = 12L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
		dispatcher.forward(req, resp);
		
		// 로거 테스트
		logger.trace("RegisterController logger trace...");
		logger.debug("RegisterController logger debug...");
		logger.info("RegisterController logger debug...");
		logger.warn("RegisterController logger warn...");
		logger.error("RegisterController logger error...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
