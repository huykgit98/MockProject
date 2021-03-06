
package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.constant.SystemConstant;
import edu.sgu.bookingsystem.model.Customer;
import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.paging.PageRequest;
import edu.sgu.bookingsystem.paging.Pageble;
import edu.sgu.bookingsystem.service.TicketService;
import edu.sgu.bookingsystem.service.impl.TicketServiceImpl;
import edu.sgu.bookingsystem.sort.Sorter;
import edu.sgu.bookingsystem.utils.FormUtil;

//dang-nhap = login
@WebServlet(name = "admin-ticket", urlPatterns = {"/admin-ticket"})
public class TicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public TicketController() {
        super();
    }

//    @Inject
//    private TicketService ticketService;
    
	private TicketService ticketService = new TicketServiceImpl(); // dc nhung tu TicketServiceImpl
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		TicketModel model = FormUtil.toModel(TicketModel.class, request); //nhan du lieu tu client gui ve - nhiem vu controller(1)
	/*	TicketModel model = new TicketModel();
		String pageStr = request.getParameter("page");
		String maxPageItemStr = request.getParameter("maxPageItem");
		if (pageStr != null)
		{
			model.setPage(Integer.parseInt(pageStr));
		}else {
			model.setPage(1);
		}
		if (maxPageItemStr != null)
		{
			model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
		} */
		
		String views="";
		String full_name = "";
		full_name=	request.getParameter("txtFullName");
		System.out.println("fullname:" + full_name);
//	if (model.getType().equals(SystemConstant.LIST))
//		{	
			
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),  new Sorter( model.getSortName(), model.getSortBy())	);
			model.setListResult(ticketService.findAll(pageble)); //pageble = offset, model.getMaxPageItem(), model.getSortName(), model.getSortBy()
			
			model.setTotalItem(ticketService.getTotalItem()); 			//model.setTotalItem(model.getListResult().size()); 
			model.setTotalPage( (int)Math.ceil((double)model.getTotalItem()/model.getMaxPageItem())); //day tat ca model(data) ra ngoai de su dung - nhiem vu controller(2)
			//totalItem lay gia tri tu findAll, maxPageItem lay gia tri tu parameter tu list
			
			views = "/views/admin/ticket/list.jsp";
//		}
//	else 
//		if(model.getType().equals(SystemConstant.UPDATE))
//		{
//			views = "/views/admin/ticket/update.jsp";
//
//			if (model.getBooking().getBookingID() != 0) // day la update
//			{
//				model = ticketService.findByBookingId(model.getBooking().getBookingID(), model.getSchedule().getId());
//				request.setAttribute("availabeSeat", ticketService.findAllAvailabeSeat(model.getBooking().getBookingID())); //gui list available seat theo busID
//				
//				TicketModel ticket = new TicketModel(full_name , 20, model.getBooking().getBookingID(), 22);
//				ticketService.updateTicket(ticket);
//			}
//			else //day la add ticket
//			{
//				request.setAttribute("availabeSeat", ticketService.findSeatByStatus()); //gui all list available seat
//			}
//
//		}
	request.setAttribute(SystemConstant.MODEL, model);
	RequestDispatcher rd = request.getRequestDispatcher(views);
	rd.forward(request, response);
		
	}


	

}
