package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BookedSuccessController", urlPatterns = {"/BookedSuccessController"})
public class BookedSuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookedSuccessController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().println("Thanh toán thành công");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/client/bookingsuccess.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
