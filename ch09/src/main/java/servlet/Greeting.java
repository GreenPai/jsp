package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/greeting.do")
public class Greeting extends HttpServlet{

	private static final long serialVersionUID = 2L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("Greeting doGet...");
		// HTML 출력 설정
	    resp.setContentType("text/html;charset=utf-8");

	    // 응답 객체에서 출력 스트림 가져오기
	    PrintWriter writer = resp.getWriter();
	    
	    writer.println("<html>");
	    writer.println("<head>");
	    writer.println("<meta charset='UTF-8'>");
	    writer.println("<title>Greeting</title>");
	    writer.println("</head>");
	    writer.println("<body>");
	    writer.println("<h3>Greeting Servlet</h3>");
	    writer.println("<a href='/ch09/hello.do'>Hello</a>");
	    writer.println("<a href='/ch09/welcome.do'>Welcome</a>");
	    writer.println("<a href='/ch09/greeting.do'>Greeting</a>");
	    writer.println("</body>");
	    writer.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}
