package com.ssamz.web.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DispatcherServletBackup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));


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
