package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.model.RoleModel;
import edu.sgu.bookingsystem.model.UserModel;
import edu.sgu.bookingsystem.service.RoleService;
import edu.sgu.bookingsystem.service.UserService;
import edu.sgu.bookingsystem.service.impl.RoleServiceImpl;
import edu.sgu.bookingsystem.service.impl.UserServiceImpl;

@WebServlet(name="admin-listUserController",urlPatterns = {"/admin-listUserController"})
public class ListUserController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static UserService userService =null;
	static  RoleService roleService = null;
	public ListUserController() {
		// TODO Auto-generated constructor stub
		userService = new UserServiceImpl();
		roleService = new RoleServiceImpl();
		
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
		getListUser(req, resp);
		getListRole(req,resp);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/user/listUser.jsp");
		dispatcher.forward(req, resp);
	}
	private void getListUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<UserModel> getAllUser = userService.getAllUser();
		////System.out.println(getAllUser);
		req.setAttribute("listUser", getAllUser);
		
	}
	private void getListRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ArrayList<RoleModel> lRole = roleService.getAllRole();
		req.setAttribute("listRole", lRole);
		
	}
	
	
}
