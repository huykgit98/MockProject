package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sgu.bookingsystem.model.Customer;
import edu.sgu.bookingsystem.service.CustomerService;
import edu.sgu.bookingsystem.service.impl.CustomerServiceImpl;
import edu.sgu.bookingsystem.utils.MD5Encrypt;

@WebServlet(name = "LoginClienController", urlPatterns = {"/LoginClienController"})
public class LoginClienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginClienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("logout".equalsIgnoreCase(request.getParameter("param"))) {
			HttpSession session = request.getSession();
			if (session != null) {
				session.invalidate();
				//session.removeAttribute("login");
			
			}
			response.sendRedirect("/MockProject/views/client/home.jsp");
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("login".equalsIgnoreCase(request.getParameter("param"))) {
			String user = request.getParameter("username");
			String password = request.getParameter("password");

			Customer customer = new Customer(user, MD5Encrypt.md5(password));

			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(1800);

			CustomerService customerService = new CustomerServiceImpl();
			customer = customerService.getCustomer(customer);
			session.removeAttribute("errorReg");

			if (customer.getId() == 0) {
				session.setAttribute("error", "Invalid User Name or Password");
				response.sendRedirect("/MockProject/views/client/login.jsp");
			} else {
				//session.setAttribute("customer", customer);

				session.setAttribute("customername", customer.getFullName());
				session.setAttribute("customerid", customer.getId());
				session.setAttribute("email", customer.getEmail());
				session.setAttribute("password", customer.getPassword());

				session.removeAttribute("error");
				response.sendRedirect("/MockProject/views/client/home.jsp");
			}
		}
	}

}
