package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.constant.SystemConstant;
import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.service.SeatService;
import edu.sgu.bookingsystem.service.impl.SeatServiceImpl;
import edu.sgu.bookingsystem.utils.FormUtil;

//@WebServlet("/UpdateSeatController")
@WebServlet("/admin-updateseat")
public class UpdateSeatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateSeatController() {
        super();
    }
    
    private SeatService seatService = new SeatServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SeatModel model = FormUtil.toModel(SeatModel.class, request);
		model = seatService.findBySeat(model.getBus().getId(), model.getSeatList()); //tim dia chi trang: ?bus.id=?&seatList=?
		
		request.setAttribute("allCustomer", seatService.findAllCustomer());
		 
		request.setAttribute(SystemConstant.SEATMODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/seat/update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketModel model = FormUtil.toModel(TicketModel.class, request);

		long scheduleId = Long.parseLong(request.getParameter("txtScheduleId"));
		long cusID = Long.parseLong(request.getParameter("txtCustomerId"));	 //input
		int seatz = Integer.valueOf(request.getParameter("txtSeat"));
		System.out.println("print: " + scheduleId +cusID+ seatz);
		
		SeatModel seat = new SeatModel(scheduleId, cusID, seatz );
		seatService.updateSeatStatus(seat);
		
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("/admin-seat?type=list&page=1&maxPageItem=5&sortName=Booking.dateStart&sortBy=ASC");
		rd.forward(request, response);
	}

}
