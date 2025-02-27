package kr.co.jboard.controller.comment;

import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
=======
>>>>>>> 225ae82ad7d48243f53747d54b74f4d1d3f25302

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.CommentDTO;
import kr.co.jboard.service.CommentService;

@WebServlet("/comment/write.do")
public class WriteController extends HttpServlet{

	private static final long serialVersionUID = 1123123L;
	private CommentService service = CommentService.INSTANCE;
<<<<<<< HEAD
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
=======
>>>>>>> 225ae82ad7d48243f53747d54b74f4d1d3f25302
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		
=======
>>>>>>> 225ae82ad7d48243f53747d54b74f4d1d3f25302
		// 데이터 수신
		String parent = req.getParameter("parent");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		// regip 구하기
		String regip = req.getRemoteAddr();
		
		// DTO 생성
		CommentDTO dto = new CommentDTO();
		dto.setContent(content);
		dto.setParent(parent);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		// 서비스 호출
<<<<<<< HEAD
		CommentDTO savedCommentDTO = service.registerComment(dto);
		
		// JSON 출력(Javascript fetch함수로 데이터를 전송할 때)
		PrintWriter printWriter = resp.getWriter();

		Gson gson = new Gson();
		String json = gson.toJson(savedCommentDTO);
		printWriter.println(json);
		

=======
		service.registerComment(dto);
		
		// 리다이렉트 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jboard/article/view.do?no=" + parent);
		resp.sendRedirect("/jboard/article/view.do?no="+parent);
>>>>>>> 225ae82ad7d48243f53747d54b74f4d1d3f25302
	}
	
}
