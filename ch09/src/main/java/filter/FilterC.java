package filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/welcome.do","/greeting.do"})
public class FilterC implements Filter {
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // ���� ���� �α�
        System.out.println("FilterC doFilter...");

        // ���ڵ� ó��
        req.setCharacterEncoding("UTF-8");

        // ���� ���� �Ǵ� �������� ��û ����
        chain.doFilter(req, resp);
    }
}
