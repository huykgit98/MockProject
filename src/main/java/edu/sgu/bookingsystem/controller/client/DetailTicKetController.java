package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.model.Place;
import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookingTicketService;
import edu.sgu.bookingsystem.service.impl.BookingTicketServiceImpl;

@WebServlet("/detailTicKetController")
public class DetailTicKetController extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	BookingTicketService ticketService = null;

	public DetailTicKetController() {
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
		try (PrintWriter out = resp.getWriter()) {
			String name_action = req.getParameter("action");

			if (name_action.equals("viewdetails")) {
				String idBooking = (String)(req.getParameter("bookingid"));
				Long id=(Long) ( req.getSession().getAttribute("customerid"));
				System.out.println("id cus: "+id+ name_action + "  " + idBooking);
				List<Ticket> tk = ticketService.detailTicket(Long.valueOf(id),Long.valueOf(idBooking));
				
				req.setAttribute("listDetailBooking", tk);
				RequestDispatcher dispatcher = req.getRequestDispatcher("views/client/detailBookingCustomer.jsp");
				dispatcher.forward(req, resp);
			} else {
				resp.sendRedirect("listTicketOfCustomer");
			}

		}
	}
}
