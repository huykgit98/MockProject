package edu.sgu.bookingsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
import edu.sgu.bookingsystem.utils.MapSeat;


@WebServlet(name = "SeatsController", urlPatterns = {"/SeatsController"})
public class SeatsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeatsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		request.setCharacterEncoding("utf-8");
		//tạo các đối tượng service để lấy thông tin
				BookingTicketService bookingTicketService = new BookingTicketServiceImpl();

				List<Ticket> listSeat = new ArrayList<Ticket>();
				List<MapSeat> listSeat1 = new ArrayList<MapSeat>();
				
				
				String start_place = request.getParameter("startplace");
				String finish_place = request.getParameter("finishplace");
				String date_start = request.getParameter("datestart");
				String time = request.getParameter("timestart");
				System.out.println(start_place);
				System.out.println(finish_place);
				System.out.println(time);


				ObjectMapper Obj = new ObjectMapper(); 
		        try { 
					PrintWriter out = response.getWriter();

		            					
//		            
//					if(finish_place!=null&&start_place!=null&&date_start!=null&&time_start!=null)
//					{

					listSeat1 = bookingTicketService.getSeatListBySchedule(Long.valueOf(start_place),Long.valueOf(finish_place),date_start,time);

					//	listSeat = bookingTicketService.getSeatsBySchedule(1,7,"2019-11-11","20:00:00");
			            String jsonListSeat = Obj.writeValueAsString(listSeat1); 
   			            response.setContentType("application/json");
			            response.setCharacterEncoding("UTF-8");
						response.getWriter().write(jsonListSeat);

//		            }
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

	public static void main(String[] args) {
		BookingTicketService bookingTicketService = new BookingTicketServiceImpl();

		List<Ticket> listSeat = new ArrayList<Ticket>();
		List<MapSeat> listSeat1 = new ArrayList<MapSeat>();
		HashMap<String,String> listSeat2;
		
		


		ObjectMapper Obj = new ObjectMapper(); 
        try { 

            					
//            
//			if(finish_place!=null&&start_place!=null&&date_start!=null&&time_start!=null)
//			{

			//listSeat = bookingTicketService.getSeatsBySchedule(1,7,3,time);

        	listSeat1 = bookingTicketService.getSeatListBySchedule(1,7,"2019-11-20","20:30:00");
        	//listSeat2 = bookingTicketService.getSeatListHashmapBySchedule(1,7,"2019-11-20","20:30:00");

	            String jsonListSeat = Obj.writeValueAsString(listSeat1); 
	           // JSONArray ja = new JSONArray();
	            System.out.println(jsonListSeat);

//            }
    		//response.getWriter().write(jsonListPlace);
    		//response.getWriter().write(jsonListFinishPlace);
    		//response.getWriter().write(jsonListTimeStart);
    		//response.getWriter().write(jsonListSeat);
            
        } 
  
        catch (IOException e) { 
            e.printStackTrace(); 
        } 		
	}
}
