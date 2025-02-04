package com.ssamz.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssamz.web.controller.board.DeleteBoardController;
import com.ssamz.web.controller.board.GetBoardController;
import com.ssamz.web.controller.board.GetBoardListController;
import com.ssamz.web.controller.board.InsertBoardController;
import com.ssamz.web.controller.board.InsertBoardViewController;
import com.ssamz.web.controller.board.UpdateBoardController;
import com.ssamz.web.controller.user.InsertUserController;
import com.ssamz.web.controller.user.InsertUserViewController;
import com.ssamz.web.controller.user.LoginController;
import com.ssamz.web.controller.user.LoginViewController;
import com.ssamz.web.controller.user.LogoutController;

public class HandlerMapping {
	
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/insertUserView.do", new InsertUserViewController());
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/loginView.do", new LoginViewController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoardView.do", new InsertBoardViewController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
		
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
