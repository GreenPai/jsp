package kr.co.jboard.controller.user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.TermsDTD;
import kr.co.jboard.service.TermsService;

@WebServlet("/user/terms.do")
public class TermsController extends HttpServlet {

	
	private static final long serialVersionUID = 12323L;
	private TermsService service = TermsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TermsDTD dto = service.findTerms(1);
		
		req.setAttribute("dto", dto);
		
		System.out.println(dto);
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/terms.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
