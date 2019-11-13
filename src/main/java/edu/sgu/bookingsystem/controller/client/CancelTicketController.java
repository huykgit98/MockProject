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

import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookingTicketService;
import edu.sgu.bookingsystem.service.impl.BookingTicketServiceImpl;

/**
 * Servlet implementation class CancelTicketController
 */
@WebServlet(name="CancelTicketController",urlPatterns = {"/list_TicketController"})
public class CancelTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingTicketService ticketService = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelTicketController() {
		ticketService = new BookingTicketServiceImpl();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

				String idBooking = (String)(request.getParameter("bookingid"));
				//Long id=(Long) ( request.getSession().getAttribute("customerid"));
				int tk = ticketService.cancelBooking(Long.valueOf(idBooking));
				
				request.setAttribute("canceledticket", tk);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listTicketController");
				requestDispatcher.forward(request, response);
			

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
