package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet{

	// �ĺ� ��ȣ
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Hello init...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ŭ���̾�Ʈ ��û�� GET ����� ��
		System.out.println("Hello doGet...");
		
		// HTML ���
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
	    writer.println("<head>");
	    writer.println("<meta charset='UTF-8'>");
	    writer.println("<title>Hello</title>");
	    writer.println("</head>");
	    writer.println("<body>");
	    writer.println("<h3>Hello Servlet</h3>");
	    writer.println("<a href='/ch09/hello.do'>Hello</a>");
	    writer.println("<a href='/ch09/welcome.do'>Welcome</a>");
	    writer.println("<a href='/ch09/greeting.do'>Greeting</a>");
	    writer.println("</body>");
	    writer.println("</html>");
		
		writer.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ŭ���̾�Ʈ ��û�� POST ����� ��
		System.out.println("Hello doPost...");
	}
	
	@Override
	public void destroy() {
		// ������ ����� ��
		System.out.println("Hello destroy...");
	}
	
}
