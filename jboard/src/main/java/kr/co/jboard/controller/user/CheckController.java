package kr.co.jboard.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.service.UserService;


@WebServlet("/user/check.do")
public class CheckController extends HttpServlet {

	private static final long serialVersionUID = -8567214395021632366L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������ ����
		String type = req.getParameter("type");
		String value = req.getParameter("value");
	
		// ���ŵ� ������ �ݵ�� ����غ���
		System.out.println("type : " + type + ", value : " + value); // �ý��� �ܼ� �̿�
		logger.debug("type : " + type + ", value : " + value); // �ΰ� �̿�
		
		// ī��Ʈ ��ȸ�ϱ�
		int count = service.countUser(type, value);
		logger.debug("count : " + count);
		
		// �̸��� ������ȣ �߼�
		if(type.equals("email") && count == 0) {
			String code = service.sendEmailCode(value);
			
			// ���� ����
			HttpSession session = req.getSession();
			session.setAttribute("sessAuthCode", code);
		}
		
		// JSON ����
		JsonObject json = new JsonObject();
		json.addProperty("count", count);
		logger.debug("json : " + json);
		
		// JSON ���
		PrintWriter writer = resp.getWriter();
		writer.println(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// ���� ������ ����ó��
		String authCode = req.getParameter("authCode");
		logger.debug("authCode : " + authCode);
		
		// ���ǿ� ����� �ڵ�� �� �� JSON ���
		HttpSession session = req.getSession();
		String sessAuthCode = (String) session.getAttribute("sessAuthCode");
		logger.debug("sessAuthCode : " + sessAuthCode);
		
		if(authCode.equals(sessAuthCode)){
			// ���� ����
			JsonObject json = new JsonObject();
			json.addProperty("result", 1);
			resp.getWriter().println(json);			
			
		}else {
			// ���� ����
			JsonObject json = new JsonObject();
			json.addProperty("result", 0);
			resp.getWriter().println(json);
		}
	
	}
}