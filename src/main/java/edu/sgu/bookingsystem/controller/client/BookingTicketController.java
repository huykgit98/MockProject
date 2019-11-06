package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sgu.bookingsystem.dao.PlaceDAO;
import edu.sgu.bookingsystem.dao.impl.PlaceDAOImpl;
import edu.sgu.bookingsystem.model.Customer;
import edu.sgu.bookingsystem.model.Place;
import edu.sgu.bookingsystem.service.CustomerService;
import edu.sgu.bookingsystem.service.PlaceService;
import edu.sgu.bookingsystem.service.impl.CustomerServiceImpl;
import edu.sgu.bookingsystem.service.impl.PlaceServiceImpl;


@WebServlet(name = "BookingTicketController", urlPatterns = {"/BookingTicketController"})
public class BookingTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookingTicketController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PlaceService placeService = new PlaceServiceImpl();
		List<Place> placeList = placeService.getPlaces();
	       
		String email = (String) request.getSession().getAttribute("email");
		String password = (String) request.getSession().getAttribute("password");

		Customer customer = new Customer(email, password);

//		CustomerDAO customerDAO = new CustomerDAOImpl();
//		customer = customerDAO.getCustomer(customer);
		CustomerService customerService = new CustomerServiceImpl();
		customer = customerService.getCustomer(customer);
		request.setAttribute("customerinfo", customer);
		request.setAttribute("placeList", placeList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/client/booking_ticket.jsp");
		requestDispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
