package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet Filter implementation class EndUserFilter
 */
@WebFilter(filterName="EndUserFilter")
public class EndUserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EndUserFilter() {
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
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        User curUser = (User)req.getSession(false).getAttribute("curUser");
        
        if(!curUser.getUserType().equals("MOD") && !curUser.getUserType().equals("ADMIN")){
        	chain.doFilter(request, response);
        }else{
        	res.sendRedirect(req.getContextPath() + "/validuser/loggedin.jsp");
        }	
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
