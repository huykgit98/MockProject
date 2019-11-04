package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		if ("infoCustomer".equalsIgnoreCase(request.getParameter("param"))) {

//			CustomerDAO customerDAO = new CustomerDAOImpl();
			CustomerService customerService = new CustomerServiceImpl();

			// Get Email and Password of User who is available in session
			String email = (String) request.getSession().getAttribute("email");
			String password = (String) request.getSession().getAttribute("password");
			String oldPass = password;
			long customer_id =  Long.parseLong(String.valueOf(request.getSession().getAttribute("customerid")));

			// Get ID of User
			Customer customer = new Customer(email, customer_id);
			//customer = customerDAO.getCustomer(customer);
			customer = customerService.getCustomer(customer);
			// Get Password and Re-Password
			password = request.getParameter("password");
			String repassword = request.getParameter("repassword");

			//String oldpassword = (String) request.getSession().getAttribute("old_password");

//			if(!oldPass.equals(oldpassword) )
//			{
//				request.getSession().setAttribute("errorUpd", "Old password is incorrect");
//				response.sendRedirect("LoginInfoClientController?param=infoCustomer");
//			}
			
			// Check Password == Re-Password ?
			if (!password.equals(repassword)) {
				request.getSession().setAttribute("errorUpd", "Password is different with RePassword");
				response.sendRedirect("LoginInfoClientController?param=infoCustomer");
			} else {
				
				if(!oldPass.equals(password) )
					password = MD5Encrypt.md5(password);
				customer.setPassword(password);

				// Update Info to Database
				customerService = new CustomerServiceImpl();
				int result = customerService.updateCustomer(customer);

						// Result of Update complete
						if (result == 1) {

							// Save new Info to Session
							HttpSession session = request.getSession();
							session.setAttribute("customername", customer.getFullName());
							session.setAttribute("email", customer.getEmail());
							session.setAttribute("password", customer.getPassword());

							// Delete errorUpd when Update Complete
							request.getSession().removeAttribute("errorUpd");

							response.sendRedirect("LoginInfoClientController?param=infoCustomer");

						} else { // Result of Update Fail
							request.getSession().setAttribute("errorUpd",
									"Internal Server Error, Please try again later.");
							response.sendRedirect("LoginInfoClientController?param=infoCustomer");
						}
					
				
			//}

			}
		}
	}  
	
//	public static void main(String[] args) {
//		CustomerService customerService = new CustomerServiceImpl();
//		String email ="huykg98@gmail.com";
//		String password = "123123";
//		String oldPass = password;
//		long customer_id =  41;
//		// Get ID of User
//		Customer customer = new Customer(email, customer_id);
//		//customer = customerDAO.getCustomer(customer);
//		customer = customerService.getCustomer(customer);
//		// Get Password and Re-Password
//		password = "123456";
//		String repassword = "123456";
//		
//		// Check Password == Re-Password ?
//					if (!password.equals(repassword)) {
//						System.out.println( "Password is different with RePassword");
//					} else {
//						
//						if(!oldPass.equals(password) )
//							
//							password = MD5Encrypt.md5(password);
//						customer.setPassword(password);
//
//						// Update Info to Database
//						customerService = new CustomerServiceImpl();
//						int result = customerService.updateCustomer(customer);
//
//								// Result of Update complete
//								if (result == 1) {
//									System.out.println( "Update thanh cong");
//
//									
//									
//
//								} else { // Result of Update Fail
//									System.out.println( "update loi");
//
//								}
//							
//						
//					//}
//
//					}
//	}
}
