package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//dang-nhap = login
@WebServlet(urlPatterns = {"/admin-homepage", "/"})
public class HomeControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeControllerAdmin() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher rd = request.getRequestDispatcher("/views/admin/index-admin.jsp");
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/admin/index-admin.jsp");
		dispatcher.forward(request, response);
	}

    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
