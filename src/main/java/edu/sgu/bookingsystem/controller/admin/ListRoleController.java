package edu.sgu.bookingsystem.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sgu.bookingsystem.dao.RoleDao;
import edu.sgu.bookingsystem.dao.impl.RoleDaoImpl;
import edu.sgu.bookingsystem.model.RoleModel;
import edu.sgu.bookingsystem.service.RoleService;
import edu.sgu.bookingsystem.service.impl.RoleServiceImpl;

@WebServlet(name = "listRoleController", urlPatterns = { "/listRoleController" })
public class ListRoleController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RoleService roleService = null;
	RoleDao roleDAO = null;
	RequestDispatcher dispatcher = null;

	public ListRoleController() {
		// TODO Auto-generated constructor stub
		roleDAO = new RoleDaoImpl();
		roleService = new RoleServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		listRole(req, resp);
	};

	private void listRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<RoleModel> lRole = roleService.getAllRole();
		req.setAttribute("listRoleController", lRole);
		RequestDispatcher dispatcher = req.getRequestDispatcher("admin/viewAllRole.jsp");
		dispatcher.forward(req, resp);
	}

}
