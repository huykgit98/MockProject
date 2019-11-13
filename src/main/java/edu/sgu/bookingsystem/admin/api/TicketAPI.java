package edu.sgu.bookingsystem.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.sgu.bookingsystem.model.TicketModel;
import edu.sgu.bookingsystem.service.TicketService;
import edu.sgu.bookingsystem.service.impl.TicketServiceImpl;
import edu.sgu.bookingsystem.utils.HttpUtil;


@WebServlet("/api-admin-ticket")
public class TicketAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private TicketService ticketService = new TicketServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		TicketModel ticketModel =  HttpUtil.of(request.getReader()).toModel(TicketModel.class); //convert Json -> model
		ticketModel = ticketService.save(ticketModel); // save vao db
		System.out.println(ticketModel);
		mapper.writeValue(response.getOutputStream(), ticketModel);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		TicketModel ticketModel =  HttpUtil.of(request.getReader()).toModel(TicketModel.class);
		ticketService.delete(ticketModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		TicketModel updateTicket =  HttpUtil.of(request.getReader()).toModel(TicketModel.class);
		updateTicket =  ticketService.updateapi(updateTicket);
		mapper.writeValue(response.getOutputStream(), updateTicket);
	}
}
