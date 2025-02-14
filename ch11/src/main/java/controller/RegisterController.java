package controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.CustomerDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;


@WebServlet("/shop/customer/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1232323L;
	
	private CustomerService service = CustomerService.INSTANCE;
	
	//로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		logger.trace("RegisterController logger trace...");
		logger.debug("RegisterController logger debug...");
		logger.info("RegisterController logger debug...");
		logger.warn("RegisterController logger warn...");
		logger.error("RegisterController logger error...");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/shop/customer/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String custId = req.getParameter("custId");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String addr = req.getParameter("addr");
		
		CustomerDto dto = new CustomerDto();
		dto.setCustId(custId);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAddr(addr);
		
		service.registerCustomer(dto);
		
		resp.sendRedirect("/ch11/shop/customer/register.do");
	}
}
