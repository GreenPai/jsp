package kr.co.jboard.controller.file;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.FileDTO;
import kr.co.jboard.service.FileService;

@WebServlet("/file/download.do")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1624825922704067870L;

	private FileService service = FileService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		// �ٿ�ε��� ���� ��ȣ ������ ����
		String fno = req.getParameter("fno");
		
		// ���� ���� ��ȸ ���� ȣ�� & �ٿ�ε� ī��Ʈ ����
		FileDTO fileDTO = service.findFile(fno);
		service.downloadCountUp(fno);
		
		// ���� ������ü ���� ����
		req.setAttribute("fileDTO", fileDTO);
		
		// ���� �ٿ�ε� ���� ȣ��		
		service.downloadFile(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}