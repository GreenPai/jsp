package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

// WAS의 실행/종료를 감시하는 리스너
public class MyContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// WAS가 시작될 때
		System.out.println("MyContextListener contextInitialized..");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// WAS가 종료될 때
		System.out.println("MyContextListener contextDestroyed...");
	}

}
