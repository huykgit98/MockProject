package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.model.Customer;
import edu.sgu.bookingsystem.service.CustomerService;
import edu.sgu.bookingsystem.service.impl.CustomerServiceImpl;


@WebServlet(name = "LoginInfoClientController", urlPatterns = {"/LoginInfoClientController"})
public class LoginInfoClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginInfoClientController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("infoCustomer".equalsIgnoreCase(request.getParameter("param"))) {
			String email = (String) request.getSession().getAttribute("email");
			String password = (String) request.getSession().getAttribute("password");

			Customer customer = new Customer(email, password);

//			CustomerDAO customerDAO = new CustomerDAOImpl();
//			customer = customerDAO.getCustomer(customer);
			CustomerService customerService = new CustomerServiceImpl();
			customer = customerService.getCustomer(customer);
			request.setAttribute("customerinfo", customer);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/client/customer_login_info.jsp");

			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
