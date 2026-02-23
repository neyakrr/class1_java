package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class myfilter
 */
@WebFilter("/myfilter")
public class myfilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public myfilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter 
        String a= request.getParameter("x");
        String b = request.getParameter("y");
        int c= Integer.parseInt(a);
        int d= Integer.parseInt(b);	
		
		if(c >= 0 && d>= 0) {
		System.out.println("before .....");
		chain.doFilter(request, response);
		System.out.println("after ......");
	}else {
		response.setContentType("text/html");
		 PrintWriter o= response.getWriter();
		 
		 o.println("Enter only positive numbers\n");
		System.out.println("Enter only positive numbers");
		 o.println("<a href = NewFile.html >Back</a>");
	}
      
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
