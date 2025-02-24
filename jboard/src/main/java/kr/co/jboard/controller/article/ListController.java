package kr.co.jboard.controller.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.PageGroupDTO;
import kr.co.jboard.service.ArticleService;

@WebServlet("/article/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1271262765653325736L;
	
	private ArticleService service = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// pg ������ ����
		String pg = req.getParameter("pg");
		
		// ��ü �Խù� ���� ���ϱ�
		int total = service.getCountArticle();
		
		// ������ ������ ��ȣ ���ϱ�
		int lastPageNum = service.getLastPageNum(total);
		
		// ���� ������ ��ȣ ���ϱ�
		int currentPage = service.getCurrentPage(pg);
		
		// LIMIT�� start
		int start = service.getStartNum(currentPage);
		
		// ������ �׷� ���ϱ�
		PageGroupDTO pageGroupDTO = service.getCurrentPageGroup(currentPage, lastPageNum);
		
		// ������ ���۹�ȣ ���ϱ�
		int pageStartNum = service.getPageStartNum(total, currentPage);
		
		// �۸�� ������ ��ȸ
		List<ArticleDTO> articles = service.findAllArticle(start);
		
		// ������ ���� ����
		req.setAttribute("articles", articles);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pageGroupDTO", pageGroupDTO);
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/article/list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}