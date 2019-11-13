package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.model.User;
import edu.sgu.bookingsystem.service.UserService;
import edu.sgu.bookingsystem.service.impl.UserServiceImpl;
import edu.sgu.bookingsystem.utils.AppUtils;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
    
    private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher= this.getServletContext().getRequestDispatcher("/views/admin/login.jsp");
		 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userName = request.getParameter("userName").trim();
	        String password = request.getParameter("password");
	        User userAccount = userService.checkUser(userName, password);
	        //login tu client -> server goi checkUser, tai UserDaoImpl -> lay ra username va password tu map de so sanh => goi ham findUser de add vao map
		if (userAccount == null)
		{
			String errorMessage ="Invalid userName or Password";
			
			request.setAttribute("errorMessage", errorMessage);
			
			RequestDispatcher dispatcher= this.getServletContext().getRequestDispatcher("/views/admin/login.jsp");
			
			dispatcher.forward(request, response);
            return;
		}
	      
		AppUtils.storeLoginedUser(request.getSession(), userAccount);
		
		//
		int redirectId = -1;
		try {
			redirectId = Integer.parseInt(request.getParameter("redirectId"));
		} catch (Exception e) {
		}
		String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
		if (requestUri != null) {
            response.sendRedirect(requestUri);
        } else {
            // Mac dinh sau khi dang nhap thanh cong
            // chuyen huong ve trang /userInfo
            response.sendRedirect(request.getContextPath() + "/admin-homepage");
        }
	}
}
