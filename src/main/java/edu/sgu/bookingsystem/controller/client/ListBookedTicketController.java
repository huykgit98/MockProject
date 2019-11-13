package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookingTicketService;
import edu.sgu.bookingsystem.service.impl.BookingTicketServiceImpl;

@WebServlet(name="listTicketController",urlPatterns = {"/listTicketController"})
public class ListBookedTicketController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BookingTicketService ticketService = null;
	public ListBookedTicketController() {
		// TODO Auto-generated constructor stub
		ticketService = new BookingTicketServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		getList(req,resp);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/client/booked_ticket.jsp");
		dispatcher.forward(req, resp);				
	}
	private void getList(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	

		Long id=(Long) req.getSession().getAttribute("customerid");
		System.out.println(id);
		ArrayList<Ticket> listTicket=ticketService.getAllTicket((id));
		req.setAttribute("listTicketOfCustomer", listTicket);
	}
	
}
