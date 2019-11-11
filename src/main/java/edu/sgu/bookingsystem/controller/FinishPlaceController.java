package edu.sgu.bookingsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

@WebServlet(name = "FinishPlaceController", urlPatterns = {"/FinishPlaceController"})
public class FinishPlaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinishPlaceController() {
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

				HashSet<Schedule> listFinishPlace = new HashSet<Schedule>();
				List<Ticket> listSeat = new ArrayList<Ticket>();
				
				//tạo các danh sách 
				List<Place> placeList = placeService.getPlaces();

				String start_place = request.getParameter("startplace");

	
				
				
		         ObjectMapper Obj = new ObjectMapper(); 
		        try { 
					PrintWriter out = response.getWriter();

		            
		            if(start_place!=null) {

						listFinishPlace=scheduleService.getFinishPlaceByStartPlace(Long.valueOf(start_place) );
			            String jsonListFinishPlace = Obj.writeValueAsString(listFinishPlace); 
			            
						response.getWriter().write(jsonListFinishPlace);
		            }
		    		//response.getWriter().write(jsonListPlace);
		    		//response.getWriter().write(jsonListFinishPlace);
		    		//response.getWriter().write(jsonListTimeStart);
		    		//response.getWriter().write(jsonListSeat);
		            
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
		doGet(request, response);
	}

}
