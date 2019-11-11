package edu.sgu.bookingsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.sgu.bookingsystem.model.Place;
import edu.sgu.bookingsystem.model.Schedule;
import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookingTicketService;
import edu.sgu.bookingsystem.service.PlaceService;
import edu.sgu.bookingsystem.service.ScheduleService;
import edu.sgu.bookingsystem.service.impl.BookingTicketServiceImpl;
import edu.sgu.bookingsystem.service.impl.PlaceServiceImpl;
import edu.sgu.bookingsystem.service.impl.ScheduleServiceImpl;

/**
 * Servlet implementation class TestController
 */
@WebServlet(name = "TestController", urlPatterns = {"/TestController"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//tạo các đối tượng service để lấy thông tin
				PlaceService placeService = new PlaceServiceImpl();
				ScheduleService scheduleService = new ScheduleServiceImpl();
				BookingTicketService bookingTicketService = new BookingTicketServiceImpl();

				//tạo các danh sách 
				List<Place> placeList = placeService.getPlaces();
				long startPlaceID= 1;
				long finishPlaceID=7;
				String dateStart = "2019-10-22";
				String timeStart = "20:00:00";
				
				HashSet<Schedule> listFinishPlace = scheduleService.getFinishPlaceByStartPlace(startPlaceID);
				HashSet<Schedule> listTimeStart = scheduleService.getTimeStartBySchedule(startPlaceID, finishPlaceID);
				List<Ticket> listSeat = bookingTicketService.getSeatsBySchedule(startPlaceID, finishPlaceID, dateStart, timeStart);
				
		         ObjectMapper Obj = new ObjectMapper(); 
		        try { 
					PrintWriter out = response.getWriter();

		            // get Oraganisation object as a json string 
		            String jsonListPlace = Obj.writeValueAsString(placeList); 
		            String jsonListFinishPlace = Obj.writeValueAsString(listFinishPlace); 
		            String jsonListTimeStart = Obj.writeValueAsString(listTimeStart); 
		            String jsonListSeat = Obj.writeValueAsString(listSeat); 
		  
		            // Displaying JSON String 
//		            System.out.println(jsonListPlace); 
//		            System.out.println(jsonListFinishPlace); 
//		            System.out.println(jsonListTimeStart); 
//		            System.out.println(jsonListSeat); 
		    		response.getWriter().write(jsonListPlace);
					response.getWriter().write("||");
		    		response.getWriter().write(jsonListFinishPlace);
					response.getWriter().write("||");
		    		response.getWriter().write(jsonListTimeStart);
					response.getWriter().write("||");
		    		response.getWriter().write(jsonListSeat);
		            
		        } 
		  
		        catch (IOException e) { 
		            e.printStackTrace(); 
		        } 		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//tạo các đối tượng service để lấy thông tin
				PlaceService placeService = new PlaceServiceImpl();
				ScheduleService scheduleService = new ScheduleServiceImpl();
				BookingTicketService bookingTicketService = new BookingTicketServiceImpl();

				//tạo các danh sách 
				List<Place> placeList = placeService.getPlaces();
				long startPlaceID= 1;
				long finishPlaceID=7;
				String dateStart = "2019-10-22";
				String timeStart = "20:00:00";
				
				HashSet<Schedule> listFinishPlace = scheduleService.getFinishPlaceByStartPlace(startPlaceID);
				HashSet<Schedule> listTimeStart = scheduleService.getTimeStartBySchedule(startPlaceID, finishPlaceID);
				List<Ticket> listSeat = bookingTicketService.getSeatsBySchedule(startPlaceID, finishPlaceID, dateStart, timeStart);
				
		         ObjectMapper Obj = new ObjectMapper(); 
		        try { 
					PrintWriter out = response.getWriter();

		            // get Oraganisation object as a json string 
		            String jsonListPlace = Obj.writeValueAsString(placeList); 
		            String jsonListFinishPlace = Obj.writeValueAsString(listFinishPlace); 
		            String jsonListTimeStart = Obj.writeValueAsString(listTimeStart); 
		            String jsonListSeat = Obj.writeValueAsString(listSeat); 
		  
		            // Displaying JSON String 
//		            System.out.println(jsonListPlace); 
//		            System.out.println(jsonListFinishPlace); 
//		            System.out.println(jsonListTimeStart); 
//		            System.out.println(jsonListSeat); 
		    		response.getWriter().write(jsonListPlace);
		    		response.getWriter().write(jsonListFinishPlace);
		    		response.getWriter().write(jsonListTimeStart);
		    		response.getWriter().write(jsonListSeat);
		            
		        } 
		  
		        catch (IOException e) { 
		            e.printStackTrace(); 
		        } 		
	}

}
