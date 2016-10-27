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
import javax.servlet.http.HttpSession;

import beans.User;

/**
 * Servlet Filter implementation class HomeFilter
 */
@WebFilter(filterName="HomeFilter")
public class HomeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HomeFilter() {
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
        HttpSession session = req.getSession(false);
        
        String homeURI = req.getContextPath() + "/validuser/loggedin.jsp";
        boolean homeRequest = req.getRequestURI().equals(homeURI);
        
        if(!homeRequest){
        	chain.doFilter(request, response);
        }else{
        	User curUser = (User)session.getAttribute("curUser");
        	if(curUser.getUserType().equals("MOD")){
        		res.sendRedirect(req.getContextPath() + "/validuser/moderator/home.jsp");
        	}else if(curUser.getUserType().equals("ADMIN")){
        		res.sendRedirect(req.getContextPath() + "/validuser/admin/home.jsp");
        	}else{
        		res.sendRedirect(req.getContextPath() + "/validuser/enduser/home.jsp");
        	}
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
