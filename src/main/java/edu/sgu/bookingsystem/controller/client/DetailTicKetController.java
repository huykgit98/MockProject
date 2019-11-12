package edu.sgu.bookingsystem.controller.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.model.Ticket;
import edu.sgu.bookingsystem.service.BookedTicketService;
import edu.sgu.bookingsystem.service.impl.BookedTicketServiceImpl;

@WebServlet("/detailTicKetController")
public class DetailTicKetController extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	BookedTicketService ticketService = null;

	public DetailTicKetController() {
		// TODO Auto-generated constructor stub
		ticketService = new BookedTicketServiceImpl();
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
				String idBooking = req.getParameter("txtBookingId");
				String idCustomer = (String) req.getSession().getAttribute("customerid");
				System.out.println(name_action + "  " + idBooking);
				Ticket tk = ticketService.getIdBooking(Long.parseLong(idCustomer), Long.parseLong(idBooking));
				System.out.println(tk.toString());
				req.setAttribute("listDetailBooking", tk);
				RequestDispatcher dispatcher = req.getRequestDispatcher("view/client/detailBookingCustomer.jsp");
				dispatcher.forward(req, resp);
			} else {
				resp.sendRedirect("listTicketOfCustomer");
			}

		}
	}
}
