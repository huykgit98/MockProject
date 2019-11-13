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

@WebServlet("/admin-updateTicket")
public class UpdateTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateTicketController() {
        super();
    }
	private TicketService ticketService = new TicketServiceImpl(); // dc nhung tu TicketServiceImpl


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketModel model = FormUtil.toModel(TicketModel.class, request);
		
		if (model.getBooking().getBookingID() != 0) // day la update
		{
			model = ticketService.findByBookingId(model.getBooking().getBookingID(), model.getSeatList());
		
			request.setAttribute("availabeSeat", ticketService.findAllAvailabeSeat(model.getBooking().getBookingID()));
		}
		else //day la add ticket
		{
			request.setAttribute("availabeSeat", ticketService.findSeatByStatus()); //gui all list available seat
		}
		request.setAttribute(SystemConstant.MODEL, model);
		 RequestDispatcher rd = request.getRequestDispatcher("/views/admin/ticket/update.jsp");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TicketModel model = FormUtil.toModel(TicketModel.class, request);
		//model = ticketService.findByBookingId(model.getBooking().getBookingID(), model.getSchedule().getId());
		
		int booking_id = Integer.valueOf(request.getParameter("txtBookingID"));
		int seatget = Integer.valueOf(request.getParameter("txtSeatGET"));
		System.out.println("seatget:" + seatget);
		String full_name = request.getParameter("txtFullName");
		int seat = Integer.valueOf(request.getParameter("txtSeat"));
		System.out.println("seat" + seat);
		String email = request.getParameter("txtEmail");
		String address = request.getParameter("txtAddress");
		String phone = request.getParameter("txtPhone");
		
		TicketModel ticket = new TicketModel( full_name ,email,address,phone,  seat	 ,booking_id,  seatget );
		ticketService.updateTicket(ticket);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("/admin-ticket?type=list&page=1&maxPageItem=10&sortName=booking.bookingID&sortBy=ASC");
		rd.forward(request, response);
	}

}
