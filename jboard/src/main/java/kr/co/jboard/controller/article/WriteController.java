package kr.co.jboard.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.FileDTO;
import kr.co.jboard.service.ArticleService;
import kr.co.jboard.service.FileService;

@WebServlet("/article/write.do")
public class WriteController extends HttpServlet {
	
	private static final long serialVersionUID = 123223232323L;
	private ArticleService service = ArticleService.INSTANCE;
	private FileService fileService = FileService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/article/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// ������ ���� ó��
		String title   = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getRemoteAddr();
		
		// ���� ���ε� ���� ȣ��
		List<FileDTO> files = fileService.uploadFile(req);
		System.out.println("���� �ٿ�ε� �Ϸ�");
		System.out.println(files.toString());
		
		// DTO ����
		ArticleDTO dto = new ArticleDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFile(files.size());
		dto.setWriter(writer);
		dto.setRegip(regip);
		logger.debug(dto.toString());
		
		// �۵�� ���� ȣ��
		int no = service.registerArticle(dto);
		
		// ���� ��� ���� ȣ��
		for(FileDTO fileDTO : files) {
			fileDTO.setAno(no);
			fileService.registerFile(fileDTO);
		}
		
		
		// �̵�
		resp.sendRedirect("/jboard/article/list.do");
		
	}
	
}
