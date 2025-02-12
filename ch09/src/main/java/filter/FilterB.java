package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FilterB implements Filter{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// ���� ����
		System.out.println("FilterB doFilter...");
				
		// ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		
		// ���� ���� ȣ��
		chain.doFilter(req, resp);
		
	}

}
