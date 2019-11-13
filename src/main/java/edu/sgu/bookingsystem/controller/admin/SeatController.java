package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.constant.SystemConstant;
import edu.sgu.bookingsystem.model.SeatModel;
import edu.sgu.bookingsystem.paging.PageRequest;
import edu.sgu.bookingsystem.paging.Pageble;
import edu.sgu.bookingsystem.service.SeatService;
import edu.sgu.bookingsystem.service.impl.SeatServiceImpl;
import edu.sgu.bookingsystem.sort.Sorter;
import edu.sgu.bookingsystem.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-seat"})
public class SeatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SeatController() {
        super();
    }

    private SeatService seatService = new SeatServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SeatModel model = FormUtil.toModel(SeatModel.class, request);
		// model.setListResult(seatService.findByText(key));
		 
		 Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),  new Sorter( model.getSortName(), model.getSortBy()));
		 
		 model.setListResult(seatService.findAll(pageble));
		 model.setTotalItem(seatService.getTotalItem()); 
		 model.setTotalPage( (int)Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
		 String views="";
		views = "/views/admin/seat/list.jsp";
		
		//findAll Seat Status
		List<SeatModel> seatStatus = seatService.findAllStatus();
		request.setAttribute("seatStatus", seatStatus);
		
		request.setAttribute(SystemConstant.SEATMODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(views);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
