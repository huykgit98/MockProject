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
		PlaceService placeService = new PlaceServiceImpl();
		BookingTicketService bookingservice = new BookingTicketServiceImpl();
		List<Place> placeList = placeService.getPlaces();
	   // List<Ticket> ticketList = bookingservice.getTicketInfo("Sài Gòn", "Cà Mau", "2019-10-22", "20:00:00");
		
	    String email = (String) request.getSession().getAttribute("email");
		String password = (String) request.getSession().getAttribute("password");

		Customer customer = new Customer(email, password);

//		CustomerDAO customerDAO = new CustomerDAOImpl();
//		customer = customerDAO.getCustomer(customer);
		CustomerService customerService = new CustomerServiceImpl();
		customer = customerService.getCustomer(customer);
		
		
		
		
		request.setAttribute("customerinfo", customer);
		request.setAttribute("placeList", placeList);
	//	request.setAttribute("ticketList", ticketList);
//    	String json = new Gson().toJson(placeList);
    	 
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
	//	response.getWriter().write(json);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/client/booking_ticket.jsp");
		requestDispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			PrintWriter out = response.getWriter();
//			ArrayList<String> arr1 = new ArrayList<String>();
//			arr1.add("của sài gòn 1");
//			arr1.add("của sài gòn 2");
//			arr1.add("của sài gòn 3");
//
//			ArrayList<String> arr2 = new ArrayList<String>();
//			arr2.add("của kiên giang 1");
//			arr2.add("của kiên giang 2");
//			arr2.add("của kiên giang 3");
			ScheduleService scheduleService = new ScheduleServiceImpl();
			PlaceService placeService = new PlaceServiceImpl();
			List<Place> listStartPlace = placeService.getPlaces();
			HashSet<Schedule> listFinishPlace = new HashSet<Schedule>();
			HashSet<Schedule> listTimeStart = new HashSet<Schedule>();

			long startPlace;
			long finishPlace=1;
			
			String loadinfoticket = request.getParameter("loadinfoticket");
			if(loadinfoticket!=null) {
				for(Place k:listStartPlace) {
					if(loadinfoticket.equals(String.valueOf(k.getId())))
					{
						startPlace =k.getId() ;
						listFinishPlace=scheduleService.getFinishPlaceByStartPlace(startPlace );
						listTimeStart=scheduleService.getTimeStartBySchedule(startPlace, finishPlace );
						response.getWriter().write("load diem ve: <select>");
						for(Schedule i:listFinishPlace) {
							response.getWriter().write("<option value='"+i.getFinishPlaceID()+"'>"+i.getFinishPlace()+"</option>");
						}
						response.getWriter().write("</select>");
						response.getWriter().write("||");
						response.getWriter().write("load thoi gian chay: <select>");
						for(Schedule i:listTimeStart) {
							response.getWriter().write("<option value='"+i.getTimeStart()+"'>"+i.getTimeStart()+"</option>");
						}
						response.getWriter().write("</select>");
					}
				}
			}

			
		}
		catch(Exception e) {}
		//doGet(request, response);
		
	}
	public static void main(String[] args) throws Exception, SecurityException {
		ScheduleService scheduleService = new ScheduleServiceImpl();
		BookingTicketService bookingTicketService = new BookingTicketServiceImpl();
		
		PlaceService placeService = new PlaceServiceImpl();
		List<Place> listStartPlace = placeService.getPlaces();
		
		HashSet<Schedule> listFinishPlace = new HashSet<Schedule>();
		HashSet<Schedule> listTimeStart = new HashSet<Schedule>();
		List<Ticket> listSeat = new ArrayList<Ticket>();

		long startPlaceID= 1;
		long finishPlaceID=7;
		String dateStart = "2019-10-22";
		String timeStart = "20:00:00";
		
		listFinishPlace = scheduleService.getFinishPlaceByStartPlace(startPlaceID);
		listTimeStart = scheduleService.getTimeStartBySchedule(startPlaceID, finishPlaceID);
		listSeat = bookingTicketService.getSeatsBySchedule(startPlaceID, finishPlaceID, dateStart, timeStart);
		
		
		
	}

}
