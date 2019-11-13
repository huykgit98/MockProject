package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.constant.SystemConstant;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.service.TicketService;
import edu.sgu.bookingsystem.service.impl.TicketServiceImpl;
import edu.sgu.bookingsystem.utils.FormUtil;

@WebServlet("/admin-cancelTicketController")
public class CancelTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TicketService ticketService = new TicketServiceImpl(); // dc nhung tu TicketServiceImpl

    public CancelTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 TicketModel model = FormUtil.toModel(TicketModel.class, request);
	 model = ticketService.findBySeat(model.getBus().getId(), model.getSeatList());
	
	 String scheid = request.getParameter("booking.bookingID");
	 String seat = request.getParameter("seatList");
	 
	 TicketModel ti = new TicketModel(Long.parseLong(scheid), Integer.parseInt(seat));
	 ticketService.updateapi(ti);
	 
	 request.setAttribute(SystemConstant.MODEL, model);
	 RequestDispatcher rd = request.getRequestDispatcher("/admin-ticket?type=list&page=1&maxPageItem=10&sortName=booking.bookingID&sortBy=ASC");
		rd.forward(request, response);
 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
//		TicketModel model = FormUtil.toModel(TicketModel.class, request);
//		
//		 String boid = request.getParameter("txtBookingId");
//		 String seat = request.getParameter("txtSeat");
//		 System.out.println("print: " + boid + seat);
//		 
//		 TicketModel ti = new TicketModel(Long.parseLong(boid), Integer.parseInt(seat));
//		 ticketService.updateapi(ti); 
//		 
//		 request.setAttribute(SystemConstant.MODEL, model);
//		 RequestDispatcher rd = request.getRequestDispatcher("/admin-ticket?type=list&page=1&maxPageItem=10&sortName=booking.bookingID&sortBy=ASC");
//			rd.forward(request, response);
	}

}
