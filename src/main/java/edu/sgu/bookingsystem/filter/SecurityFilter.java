package edu.sgu.bookingsystem.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.filter.UserRoleRequestWrapper.UserRoleRequestWrapper;
import edu.sgu.bookingsystem.model.User;
import edu.sgu.bookingsystem.utils.AppUtils;
import edu.sgu.bookingsystem.utils.SecurityUtils;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
						throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String servletPath = request.getServletPath(); //get Path
		
		//UserInfo save in Session
		//(After Login success)
		User loginedUser =  AppUtils.getLoginedUser(request.getSession());
		
		if (servletPath.equals("/login"))
		{
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest wrapRequest = request;
		
		if (loginedUser != null)
		{
			//User Name
			String userName = loginedUser.getUserName(); //lay username cua user da dang nhap
			
			//cac vai tro(role)
			List<String> roles = loginedUser.getRoles(); //lay tat ca role cua user da dang nhap
			
			//goi request cu~ boi 1 request moi	voi cac thong tin username va role
			wrapRequest = new UserRoleRequestWrapper(userName, roles, request);
		}
		
		//Cac trang bat buoc phai dang nhap
		if (SecurityUtils.isSecurityPage(request))
		{
			//neu nguoi dung chua dang nhap, Redirect(chuyen huong) toi trang dang nhap
			if (loginedUser == null)
			{
				String requestUri = request.getRequestURI();
				
				//luu tru trang hien tai de Redirect den sau khi dang nhap thanh cong
				int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);
				
				response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
				return;
			}
			
			//kiem tra nguoi dung co hop le khong?
			boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
			if ( !hasPermission )
			{
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/admin/accessDeniedView.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
