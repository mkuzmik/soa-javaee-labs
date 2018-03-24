package soa.mkuzmik.ex1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/AgeFilter")
public class BeerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        int age = Integer.valueOf(((HttpServletRequest) request).getParameter("age"));

        if (age < 18) {
            PrintWriter writer = response.getWriter();
            writer.println("Too young guy");
            writer.close();
        } else {
            chain.doFilter(request, response);
        }
    }
}
