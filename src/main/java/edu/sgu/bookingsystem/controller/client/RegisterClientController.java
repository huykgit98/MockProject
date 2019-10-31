package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;
import javax.servlet.ServletConfig;
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


//@WebServlet("/RegisterClientController")
@WebServlet(name = "RegisterClientController", urlPatterns = {"/RegisterClientController"})
public class RegisterClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CustomerService customerService ;
    public RegisterClientController() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		customerService = new CustomerServiceImpl();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		if ("register".equalsIgnoreCase(request.getParameter("param"))) {
			HttpSession session = request.getSession();
			request.getSession().removeAttribute("error");

			String email = request.getParameter("email");
			String phoneNum = request.getParameter("phonenumber");

			String password = MD5Encrypt.md5(request.getParameter("password"));
			String repassword = MD5Encrypt.md5(request.getParameter("repassword"));

			String fullName = request.getParameter("fullname");
			String address = request.getParameter("address");

			Customer customer = new Customer(email, phoneNum, password, fullName, address);


			if (!password.equals(repassword)) {
				request.getSession().setAttribute("errorReg", "Password is different with RePassword");

			} else {

				int result = customerService.insertCustomer(customer);

				if (result == -1) {
					request.getSession().setAttribute("errorReg", "Email was exists");

				} else {
					if (result == -2) {
						request.getSession().setAttribute("errorReg", "Phone Number was exists");

					} else {
						if (result == 1) {
							if (request.getParameter("button") == null) {
								customerService = new CustomerServiceImpl();
								customer = customerService.getCustomer(customer);
								session.setAttribute("customername", customer.getFullName());
								session.setAttribute("customerid", customer.getId());
								session.setAttribute("email", customer.getEmail());
								session.setAttribute("password", customer.getPassword());
							}

							request.getSession().removeAttribute("errorReg");
						} else {
							request.getSession().setAttribute("errorReg",
									"Internal Server Error, Please try again later.");
						}
					}
				}
			}

			if (request.getParameter("button") == null) {
				response.sendRedirect("/MockProject/views/client/register.jsp");
			}

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
