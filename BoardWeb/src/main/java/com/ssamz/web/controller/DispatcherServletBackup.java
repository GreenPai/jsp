package com.ssamz.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.board.BoardDAO;
import com.ssamz.biz.board.BoardVO;
import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVO;

//@WebServlet("*.do")
public class DispatcherServletBackup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 요청 path를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));

		// 2. 추출된 path 정보에 따라 요청을 분기 처리한다.

		if (path.equals("/login.do")) {

		} else if (path.equals("/insertUser.do")) {

		} else if (path.equals("/logout.do")) {

		} else if (path.equals("/insertBoard.do")) {

		} else if (path.equals("/updateBoard.do")) {

		} else if (path.equals("/deleteBoard.do")) {

		} else if (path.equals("/getBoard.do")) {

		} else if (path.equals("/getBoardList.do")) {

		} else if (path.equals("/loginView.do")) {

		} else if (path.equals("/insertBoardView.do")) {

		} else if (path.equals("/insertUserView.do")) {

		}

	}
}
