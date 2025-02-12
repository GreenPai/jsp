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
        // 필터 실행 로그
        System.out.println("FilterC doFilter...");

        // 인코딩 처리
        req.setCharacterEncoding("UTF-8");

        // 다음 필터 또는 서블릿으로 요청 전달
        chain.doFilter(req, resp);
    }
}
