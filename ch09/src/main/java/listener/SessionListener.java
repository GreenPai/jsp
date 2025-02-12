package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionListener implements HttpSessionAttributeListener{

	int count = 0;
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// ���ǿ� ���� �߰��� ��
		count++;
		System.out.println("���� �α��� �� ����� : " + count);
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// ���ǿ� ���� ���ŵ� ��
		count--;
		System.out.println("���� �α��� �� ����� : " + count);
	}
}
