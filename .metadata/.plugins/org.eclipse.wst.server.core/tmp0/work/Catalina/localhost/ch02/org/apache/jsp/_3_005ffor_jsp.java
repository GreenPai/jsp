/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.34
 * Generated at: 2025-02-03 02:26:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class _3_005ffor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>3.for</title>\r\n");
      out.write("	<!-- \r\n");
      out.write("		날짜 : 2025/02/03\r\n");
      out.write("		이름 : 우상호\r\n");
      out.write("		내용 : JSP 반복문 실습하기\r\n");
      out.write("	 -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h3>JSP 반복문</h3>\r\n");
      out.write("	\r\n");
      out.write("	<h4>for</h4>\r\n");
      out.write("	");

		for(int i=0; i<5; i++){
			out.println("<p>i : " + i + "</p>");
		}
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	");
 for(int k=0; k<5; k++){ 
      out.write("\r\n");
      out.write("		<p>k : ");
      out.print( k );
      out.write("</p>\r\n");
      out.write("	");
 } 
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<h4>while</h4>\r\n");
      out.write("	");

		int j = 1;
		while(j<=5){
	
      out.write("\r\n");
      out.write("		<p>j : ");
      out.print( j );
      out.write("</p>\r\n");
      out.write("	");

			j++;
		}
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<h4>구구단</h4>	\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>2단</th>\r\n");
      out.write("			<th>3단</th>\r\n");
      out.write("			<th>4단</th>\r\n");
      out.write("			<th>5단</th>\r\n");
      out.write("			<th>6단</th>\r\n");
      out.write("			<th>7단</th>\r\n");
      out.write("			<th>8단</th>\r\n");
      out.write("			<th>9단</th>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>2 x 1 = 2</td>\r\n");
      out.write("			<td>3 x 1 = 3</td>\r\n");
      out.write("			<td>4 x 1 = 4</td>\r\n");
      out.write("			<td>5 x 1 = 5</td>\r\n");
      out.write("			<td>6 x 1 = 6</td>\r\n");
      out.write("			<td>7 x 1 = 7</td>\r\n");
      out.write("			<td>8 x 1 = 8</td>\r\n");
      out.write("			<td>9 x 1 = 9</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>2 x 2 = 4</td>\r\n");
      out.write("			<td>3 x 2 = 6</td>\r\n");
      out.write("			<td>4 x 2 = 8</td>\r\n");
      out.write("			<td>5 x 2 = 10</td>\r\n");
      out.write("			<td>6 x 2 = 8</td>\r\n");
      out.write("			<td>7 x 2 = 14</td>\r\n");
      out.write("			<td>8 x 2 = 16</td>\r\n");
      out.write("			<td>9 x 2 = 18</td>\r\n");
      out.write("		</tr>		\r\n");
      out.write("	</table>\r\n");
      out.write("	\r\n");
      out.write("	<br>\r\n");
      out.write("	\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("	\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>2단</th>\r\n");
      out.write("			<th>3단</th>\r\n");
      out.write("			<th>4단</th>\r\n");
      out.write("			<th>5단</th>\r\n");
      out.write("			<th>6단</th>\r\n");
      out.write("			<th>7단</th>\r\n");
      out.write("			<th>8단</th>\r\n");
      out.write("			<th>9단</th>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");
 
		for(int i=1; i<=9; i++){
		
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>2 x ");
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( 2*i );
      out.write("</td>\r\n");
      out.write("			<td>3 x ");
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( 3*i );
      out.write("</td>\r\n");
      out.write("			<td>4 x ");
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( 4*i );
      out.write("</td>\r\n");
      out.write("			<td>5 x ");
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( 5*i );
      out.write("</td>\r\n");
      out.write("			<td>6 x ");
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( 6*i );
      out.write("</td>\r\n");
      out.write("			<td>7 x ");
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( 7*i );
      out.write("</td>\r\n");
      out.write("			<td>8 x ");
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( 8*i );
      out.write("</td>\r\n");
      out.write("			<td>9 x ");
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( 9*i );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("			\r\n");
      out.write("		");
 } 
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("	</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
