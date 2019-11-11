package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;



import edu.sgu.bookingsystem.dao.PlaceDAO;
import edu.sgu.bookingsystem.dao.impl.PlaceDAOImpl;
import edu.sgu.bookingsystem.model.Customer;
import edu.sgu.bookingsystem.model.Place;
import edu.sgu.bookingsystem.model.Schedule;
import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookingTicketService;
import edu.sgu.bookingsystem.service.CustomerService;
import edu.sgu.bookingsystem.service.PlaceService;
import edu.sgu.bookingsystem.service.ScheduleService;
import edu.sgu.bookingsystem.service.impl.BookingTicketServiceImpl;
import edu.sgu.bookingsystem.service.impl.CustomerServiceImpl;
import edu.sgu.bookingsystem.service.impl.PlaceServiceImpl;
import edu.sgu.bookingsystem.service.impl.ScheduleServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BookingTicketController", urlPatterns = {"/BookingTicketController"})
public class BookingTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookingTicketController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	    String email = (String) request.getSession().getAttribute("email");
		String password = (String) request.getSession().getAttribute("password");

		Customer customer = new Customer(email, password);
		//tạo các đối tượng service để lấy thông tin
		PlaceService placeService = new PlaceServiceImpl();
		ScheduleService scheduleService = new ScheduleServiceImpl();
		BookingTicketService bookingTicketService = new BookingTicketServiceImpl();

		CustomerService customerService = new CustomerServiceImpl();
		
		customer = customerService.getCustomer(customer);
		request.setAttribute("customerinfo", customer);
		List<Place> placeList = placeService.getPlaces();
		request.setAttribute("placeList", placeList);
		
		
        
		//tạo các danh sách 

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/client/booking_ticket.jsp");
		requestDispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	    String fullName = (String) request.getParameter("fullname");
	    String phoneNumber = (String) request.getParameter("phonenumber");
	    String email = (String) request.getParameter("email");
	    String address = (String) request.getParameter("address");
	    //id not name finishplace=12&datestart=2019-11-11&timestart=18%3A00%3A00&listseatbooking=13%2C14%2C18%2C17&unitprice=200000
	    String startPlace = (String) request.getParameter("startplace");
	    String finishPlace = (String) request.getParameter("finishplace");
	    String dateStart = (String) request.getParameter("datestart");
	    String timeStart = (String) request.getParameter("timestart");
	    String unitPrice = (String) request.getParameter("unitprice");
	    String listSeatBooking = (String) request.getParameter("listseatbooking");

	    System.out.println(fullName+" - "+phoneNumber+" - " +email+ " - "+address+ " - "+ startPlace + " - " +finishPlace+ " - " +dateStart +" - " +timeStart+ "- "+unitPrice+ " - "+listSeatBooking);
		response.sendRedirect("BookingTicketController");

	}


}
