package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

// WAS�� ����/���Ḧ �����ϴ� ������
public class MyContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// WAS�� ���۵� ��
		System.out.println("MyContextListener contextInitialized..");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// WAS�� ����� ��
		System.out.println("MyContextListener contextDestroyed...");
	}

}
