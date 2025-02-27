package kr.co.jboard.controller.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.FileDTO;
import kr.co.jboard.service.ArticleService;
import kr.co.jboard.service.FileService;

@WebServlet("/article/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 12323L;
	private FileService fileService = FileService.INSTANCE;
	private ArticleService articleService = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		// 저장된 파일 이름 조회
		List<String> sname =  fileService.findFileByAno(no);		
		System.out.println(sname.toString());
		
		// 파일 DB 삭제
		fileService.deleteFile(req, sname);
		
		// 글 삭제
		articleService.deleteArticle(no);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/article/list.do");
		dispatcher.forward(req, resp);
	}
	
}
