package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sgu.bookingsystem.dao.CustomerDAO;
import edu.sgu.bookingsystem.dao.impl.CustomerDAOImpl;
import edu.sgu.bookingsystem.model.Customer;
import edu.sgu.bookingsystem.service.CustomerService;
import edu.sgu.bookingsystem.service.impl.CustomerServiceImpl;
import edu.sgu.bookingsystem.utils.MD5Encrypt;

@WebServlet(name = "CustomerInfoController", urlPatterns = {"/CustomerInfoController"})
public class CustomerInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

    public CustomerInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		if ("infoCustomer".equalsIgnoreCase(request.getParameter("param"))) {
			String email = (String) request.getSession().getAttribute("email");
			String password = (String) request.getSession().getAttribute("password");

			Customer customer = new Customer(email, password);

//			CustomerDAO customerDAO = new CustomerDAOImpl();
//			customer = customerDAO.getCustomer(customer);
			CustomerService customerService = new CustomerServiceImpl();
			customer = customerService.getCustomer(customer);
			request.setAttribute("customerinfo", customer);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/client/customer_info.jsp");

			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		if ("changeInfoCustomer".equalsIgnoreCase(request.getParameter("param"))) {

//			CustomerDAO customerDAO = new CustomerDAOImpl();
			CustomerService customerService = new CustomerServiceImpl();

			// Get Email and Password of User who is available in session
			String email = (String) request.getSession().getAttribute("email");
			//String password = (String) request.getSession().getAttribute("password");
			//String oldPass = password;
			long customer_id =  Long.parseLong(String.valueOf(request.getSession().getAttribute("customerid")));

			// Get ID of User
			Customer customer = new Customer(email, customer_id);
			//customer = customerDAO.getCustomer(customer);
			customer = customerService.getCustomer(customer);
			// Get Password and Re-Password
		//	password = request.getParameter("password");
		//	String repassword = request.getParameter("repassword");

			// Check Password == Re-Password ?
//			if (!password.equals(repassword)) {
//				request.getSession().setAttribute("errorUpd", "Password is different with RePassword");
//				response.sendRedirect("CustomerInfoController?param=infoCustomer");
//			} else {
//				
//				if(!oldPass.equals(password) )
//					password = MD5Encrypt.md5(password);

				// Set User with a new Infomation
				customer.setEmail(request.getParameter("email"));
				customer.setPhone(request.getParameter("phonenumber"));
				//customer.setPassword(password);
				customer.setFullName(request.getParameter("fullname"));
				customer.setAddress(request.getParameter("address"));
				
				

				// Update Info to Database
				customerService = new CustomerServiceImpl();
				int result = customerService.updateCustomer(customer);

				// Result of check Email exists
				if (result == -1) {
					request.getSession().setAttribute("errorUpd", "Email was exists");
					response.sendRedirect("CustomerInfoController?param=infoCustomer");

				} else {

					// Result of Check PhoneNumber exists
					if (result == -2) {
						request.getSession().setAttribute("errorUpd", "Phone Number was exists");
						response.sendRedirect("CustomerInfoController?param=infoCustomer");
					} else {

						// Result of Update complete
						if (result == 1) {

							// Save new Info to Session
							HttpSession session = request.getSession();
							session.setAttribute("customername", customer.getFullName());
							session.setAttribute("email", customer.getEmail());
//							session.setAttribute("password", customer.getPassword());

							// Delete errorUpd when Update Complete
							request.getSession().removeAttribute("errorUpd");

							response.sendRedirect("/MockProject/CustomerInfoController?param=infoCustomer");

						} else { // Result of Update Fail
							request.getSession().setAttribute("errorUpd",
									"Internal Server Error, Please try again later.");
							response.sendRedirect("CustomerInfoController?param=infoCustomer");
						}
					}
				}
			//}

		}
	}
	
	

	
	
}
